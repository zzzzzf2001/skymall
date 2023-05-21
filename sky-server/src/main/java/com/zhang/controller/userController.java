package com.zhang.controller;

import com.zhang.result.Result;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/19 16:48
 **/


@RestController
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/a")
    public Result test(){
     return    Result.success(userService.getById(1));
    }


}
