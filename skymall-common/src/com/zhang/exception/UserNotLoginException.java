package com.zhang.exception;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/17 20:17
 **/


public class UserNotLoginException extends NormalException{
    public UserNotLoginException(){}

    public UserNotLoginException(String code,String msg){
        super(Integer.valueOf(code),msg);
    }

}
