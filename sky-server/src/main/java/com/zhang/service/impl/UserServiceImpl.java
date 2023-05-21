package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.entity.User;
import com.zhang.exception.CaptchaErrorException;
import com.zhang.exception.PhoneHasError;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import com.zhang.mapper.UserMapper;
import com.zhang.utils.LoginUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
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

    @Resource
    private TransactionTemplate transactionTemplate;



    @Override
    public Result usersignIn( RegistrationDTO registrationDTO) {

        transactionTemplate.execute(status -> {
            String captcha = registrationDTO.getCaptcha();
            if (!LoginUtils.verifyCaptcha(captcha)) {
               throw new CaptchaErrorException(CODE_411,"验证码错误");
            }
            String phone = registrationDTO.getPhone();
            if (!Objects.isNull( userMapper.hasPhoneInDB(phone))){
                throw new PhoneHasError(CODE_411,"手机号已存在，请检查手机号或更换手机号");
            }


            return true;
        });

    }





}




