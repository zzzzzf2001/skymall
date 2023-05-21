package com.zhang.exception;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/17 20:14
 **/


public class TokenExpireException extends NormalException{
    public TokenExpireException(){}


    public TokenExpireException(String code,String msg){
        super(Integer.valueOf(code),msg);
    }


}
