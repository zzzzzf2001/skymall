package com.zhang.exception;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/21 21:26
 **/


public class CaptchaErrorException extends NormalException{
    public CaptchaErrorException(){}

    public CaptchaErrorException(String code,String msg){
        super(Integer.valueOf(code),msg);
    }
}
