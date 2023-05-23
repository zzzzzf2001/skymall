package com.zhang.utils;

import com.zhang.context.BaseContext;
import com.zhang.entity.User;
import com.zhang.exception.PasswordErrorException;
import com.zhang.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.HashMap;

import static com.zhang.constant.HttpStatusConstant.CODE_411;
import static com.zhang.constant.JwtClaimsConstant.*;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/21 21:06
 **/

@Component

public class LoginUtils {

    @Resource
    private  UserMapper userMapper;
    public  HashMap<String,String> VerifyLoginInfo(User userDb,User u2) {
          String  password = DigestUtils.md5DigestAsHex(u2.getPassword().getBytes());
          u2.setPassword(password);
        if (!userDb.getPassword().equals(u2.getPassword())) {
            throw new PasswordErrorException(CODE_411,"密码不正确,请检查后重新登录");
        }

        BaseContext.setCurrentId(u2.getId());

        HashMap<String,String> map=new HashMap<>();

        map.put(PRIMARY_ID, String.valueOf(u2.getId()));
        map.put(USERNAME,u2.getUsername());
        String token = JWTUtils.getToken(map);

        HashMap<String,String> result =new HashMap<>();
        result.put(TOKEN,token);
        result.put("msg","登录成功");

        return result;
    }
}
