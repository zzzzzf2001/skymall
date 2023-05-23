package com.zhang.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.DTO.LoginDTO;
import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.entity.User;
import com.zhang.exception.AccountNotFoundException;
import com.zhang.mapper.UserMapper;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import com.zhang.utils.JWTUtils;
import com.zhang.utils.LoginUtils;
import com.zhang.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import static com.zhang.constant.JwtClaimsConstant.*;
import static com.zhang.constant.MessageErrorConstant.ACCOUNT_NOT_FOUND;
import static com.zhang.constant.RedisConstant.REGISTER_PREFIX;
import static com.zhang.constant.StatusConstant.ENABLE;


/**
* @author 15754
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/



@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Resource
    private UserMapper userMapper;


    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private LoginUtils loginUtils;


    @Override
    public Result usersignIn( RegistrationDTO registrationDTO) {

        return null;

    }


    @Override
    @Transactional
    public Result getReregisterCaptcha(String phone) {
        String code = "";

         for (int i=0;i<6;i++){
             String random = String.valueOf(new Random().nextInt(10));
             code=code+random;
         }


        redisUtils.set(REGISTER_PREFIX+phone,code);

        redisUtils.expire(REGISTER_PREFIX+phone,120);

        return Result.success("发送成功");
    }

    @Override
    @Transactional
    public Result verifyReregisterCaptcha(String code,String phone) {
//        这里不能把过期和是否有key包含在一起，若没有key就会报空指针
        String key = REGISTER_PREFIX + phone;
        if (!redisUtils.hasKey(key)) {
            return  Result.error("验证码错误或已过期");
        }
        String getCode = (String) redisUtils.get(key);

        if (!code.equals(getCode)){
            return Result.error("验证码错误或已过期");
        }

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();



        User DBuser = userMapper.selectOne(wrapper.eq(User::getPhone, phone));
        if (Objects.nonNull(DBuser)) {
            //销毁key value
            redisUtils.del(key);

            HashMap<String,String> map=new HashMap<>();
            map.put(PRIMARY_ID,DBuser.getId().toString());
            map.put(NICKNAME,DBuser.getNickname());
            map.put(PHONE,DBuser.getPhone());
            map.put(USERNAME,DBuser.getUsername());
            String token = JWTUtils.getToken(map);

            HashMap<String,String> result=new HashMap<>();
            result.put("msg","登录成功");
            result.put(TOKEN,token);
         return  Result.success(result);

        }

        User user = User.builder().nickname("user_" + String.valueOf((int) (Math.random() * 1000 * 1000)))
                .phone(phone)
                .username("user_"+phone)
                .password(DigestUtils.md5DigestAsHex("123456".getBytes()))
                .status(ENABLE)
                .last_login_time(LocalDateTime.now())
                .create_time(LocalDateTime.now())
                .build();

        userMapper.insert(user);

        /**
         * todo 塞token
         * */

        HashMap<String,String> map=new HashMap<>();
        map.put(PRIMARY_ID,user.getId().toString());
        map.put(NICKNAME,user.getNickname());
        map.put(PHONE,user.getPhone());
        map.put(USERNAME,user.getUsername());
        String token = JWTUtils.getToken(map);

        HashMap<String,String> result=new HashMap<>();
        result.put("msg","登录成功");
        result.put("token",token);

        return Result.success(result);
    }

    @Override
    public Result Login(LoginDTO loginDTO) {
        User user = new User();

        BeanUtils.copyProperties(loginDTO,user);
        String username = user.getUsername();
        String phone = user.getPhone();

        if (StringUtils.isNotBlank(username)||StringUtils.isNotBlank(phone)) {
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(StringUtils.isNotBlank(username),User::getUsername,username)
                    .or()
                    .eq(StringUtils.isNotBlank(phone),User::getPhone,phone)
            ;
            User userDB = userMapper.selectOne(queryWrapper);

            if (Objects.isNull(userDB)) {
                throw new AccountNotFoundException(ACCOUNT_NOT_FOUND);
            }
            return Result.success(loginUtils.VerifyLoginInfo(userDB,user));
        }

          return  Result.success();

    }

    @Override
    @Transactional
    public void settingPassWord(String password, HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer userId = JWTUtils.getTokenDetail(token, PRIMARY_ID, Integer.class);
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userMapper.setPassWord(password,userId);
    }
}



