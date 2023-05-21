package com.zhang.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.TimeUtil;
import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.entity.User;
import com.zhang.exception.CaptchaErrorException;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import com.zhang.mapper.UserMapper;

import com.zhang.utils.RedisUtils;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;


import java.util.Objects;

import static com.zhang.constant.HttpStatusConstant.CODE_411;


/**
* @author 15754
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Resource
    private UserMapper userMapper;


    private final String REGISTER="registerUser:";
    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public Result usersignIn( RegistrationDTO registrationDTO) {

        return null;

    }


    @Override
    @Transactional
    public Result getReregisterCaptcha(String phone) {

       String code=String.valueOf ((int) (Math.random() * 1000 * 1000));

        redisUtils.set(REGISTER+phone,code);
        redisUtils.expire(REGISTER+phone,120);
        return Result.success("发送成功");
    }

    @Override
    public Result verifyReregisterCaptcha(String code,String phone) {
//        这里不能把过期和是否有key包含在一起，若没有key就会报空指针
        String key = REGISTER + phone;
        if (!redisUtils.hasKey(key)) {
            throw new CaptchaErrorException(CODE_411,"验证码错误或已过期");
        }
        String getCode = (String) redisUtils.get(key);

        if (!code.equals(getCode)){
            throw new CaptchaErrorException(CODE_411,"验证码错误或已过期");
        }
        //销毁key value
        redisUtils.del(key);

        return Result.success("验证成功");
    }


}




