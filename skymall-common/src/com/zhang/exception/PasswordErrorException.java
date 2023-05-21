package com.zhang.exception;

/**
 * 密码错误异常
 */
public class PasswordErrorException extends NormalException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String code, String msg) {
        super(Integer.valueOf(code),msg);
    }

}
