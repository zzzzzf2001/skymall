package com.zhang.web.client;

import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/19 17:57
 **/

@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private UserService userService;

/**
 * @param registrationDTO 用户注册DTO
 * @author : 15754
 * @return Result
 * */



    public Result userRegistration (@RequestBody RegistrationDTO registrationDTO){

        userService.usersignIn(registrationDTO);


        return Result.success();
    }





}
