package com.zhang.handler;

import com.zhang.exception.NormalException;
import com.zhang.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*
 * @Description
 * @author 15754
 * @Date 2023/5/23
 */

@RestControllerAdvice
@Slf4j
public class NormalExceptionAdvice {
    @ExceptionHandler(NormalException.class)
    public Result handleBusinessException(NormalException e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }
}
