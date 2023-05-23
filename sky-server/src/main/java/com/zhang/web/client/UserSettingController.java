package com.zhang.web.client;

import com.zhang.entity.DTO.LoginDTO;
import com.zhang.result.Result;
import com.zhang.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/22 21:55
 **/

@Slf4j
@RestController
@RequestMapping("/user/setting")

public class UserSettingController {

    @Resource
    private UserService userService;


    @PutMapping("/settingPassword")
    @ApiOperation("用户设置密码")
    @Transactional
    public Result SettingPassWord(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
        userService.settingPassWord(loginDTO.getPassword(), request);
        return Result.success("密码设置成功");

    }


}
