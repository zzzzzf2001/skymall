package com.zhang.exception;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/17 19:00
 **/


public class AccountNotFoundException extends NormalException{
    public AccountNotFoundException(){}

    public AccountNotFoundException(String code,String msg){
        super(Integer.valueOf(code),msg);
    }

    }

