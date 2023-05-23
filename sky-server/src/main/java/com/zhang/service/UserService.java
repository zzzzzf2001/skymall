package com.zhang.service;

import com.zhang.entity.DTO.LoginDTO;
import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 15754
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-05-19 16:00:55
 */
public interface UserService extends IService<User> {

    Result usersignIn(RegistrationDTO registrationDTO);

    Result getReregisterCaptcha(String phone);

    Result verifyReregisterCaptcha(String code, String phone);

    Result Login(LoginDTO loginDTO);

    void settingPassWord(String password, HttpServletRequest request);
}
