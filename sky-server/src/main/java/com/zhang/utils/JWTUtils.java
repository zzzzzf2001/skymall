package com.zhang.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhang.exception.NormalException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import static com.zhang.constant.JwtClaimsConstant.TOKEN_SECRET;


/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/11 14:39
 **/


public class JWTUtils {

    /**
     * 生成token,header,payload,signature
     * */


    public static String getToken(HashMap<String, String> map){
        //设置默认时间
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        //创建JWT实例
        JWTCreator.Builder builder = JWT.create();
        //将Payload传入JWT实例中
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(TOKEN_SECRET));
    }
    /**
     * 验证token
     * */
    public static void verify(String token, HttpServletResponse response) throws IOException {
        try{
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
        }
        catch (Exception e){
            e.getStackTrace();
            throw new NormalException();
        }
    }

    /**
     * 获取token中的信息
     * */
    public static DecodedJWT  getToken(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
    }
    public static <T> T getTokenDetail(String token,String claim,Class<T> T){
        return getToken(token).getClaim(claim).as(T);
    }
}