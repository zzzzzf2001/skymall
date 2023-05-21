package com.zhang.exception;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/21 21:32
 **/


public class PhoneHasError extends NormalException{
    public PhoneHasError(){}

    public PhoneHasError(String code,String msg){
        super(Integer.valueOf(code),msg);
    }
}
