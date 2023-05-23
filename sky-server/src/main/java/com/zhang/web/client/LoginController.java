package com.zhang.web.client;

import com.zhang.entity.DTO.LoginDTO;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import io.swagger.annotations.ApiOperation;
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
     * @return Result
     * @author : 15754
     */


    @PostMapping("/getCaptcha")
    @ApiOperation("发送验证码实现登录或注册")
    public Result getRegisterCaptcha(@RequestParam("phone") String phone) {
        return userService.getReregisterCaptcha(phone);
    }

    @PostMapping("/verifyCaptcha")
    @ApiOperation("验证验证码，实现注册或手机号登录")
    public Result verifyRegisterCaptcha(@RequestParam("code") String code, @RequestParam("phone") String phone) {
        return userService.verifyReregisterCaptcha(code, phone);
    }


    @PutMapping("/signIn")
    @ApiOperation("使用账号或手机号和密码进行登录")
    public Result signIn(@RequestBody LoginDTO loginDTO) {

        return userService.Login(loginDTO);
    }


}
