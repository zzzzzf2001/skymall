package com.zhang.service;

import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.result.Result;

/**
* @author 15754
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-05-19 16:00:55
*/
public interface UserService extends IService<User> {

    Result usersignIn( RegistrationDTO registrationDTO);
}
