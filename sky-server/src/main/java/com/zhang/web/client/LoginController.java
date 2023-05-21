package com.zhang.web.client;

import com.zhang.entity.DTO.RegistrationDTO;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import com.zhang.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
 * @param phone 用户手机号
 * @author : 15754
 * @return Result
 * */


    @PostMapping("/getCaptcha")
    public Result getRegisterCaptcha (@RequestParam("phone") String phone){
        return userService.getReregisterCaptcha(phone);
    }

    @PostMapping("/verifyCaptcha")
    public Result verifyRegisterCaptcha(@RequestParam("code") String code,@RequestParam("phone") String phone){
        return userService.verifyReregisterCaptcha(code,phone);
    }





}
