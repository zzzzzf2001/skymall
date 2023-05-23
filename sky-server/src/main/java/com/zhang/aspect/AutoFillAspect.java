package com.zhang.aspect;

import com.zhang.annotation.AutoFill;
import com.zhang.context.BaseContext;
import com.zhang.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static com.zhang.constant.AutoFillConstant.*;
import static com.zhang.enumeration.OperationType.INSERT;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/23 18:20
 **/


@Component
@Aspect
@Slf4j
public class AutoFillAspect {

    //定义切点

    @Pointcut("execution(* com.zhang.mapper.*.*(..))&& @annotation(com.zhang.annotation.AutoFill)")
    public void autoFillPoint() {
    }


    @Before("autoFillPoint()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("公共字段填充");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AutoFill annotation = method.getAnnotation(AutoFill.class);
        OperationType value = annotation.value();


        Object[] args = joinPoint.getArgs();
        //约定方法的第一个参数就是实体类
        Object entity = args[0];

        LocalDateTime now = LocalDateTime.now();

        Integer id = BaseContext.getCurrentId();
        if (id == null)
            id = 0;

        if (value == INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(SET_CREATE_TIME, LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Integer.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(SET_CREATE_USER, Integer.class);


                setCreateTime.invoke(entity, now);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, id);
                setCreateUser.invoke(entity, id);


            } catch (Exception e) {
                log.info("公共字段填充失败:{}", e.getMessage());
            }
        } else {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Integer.class);


                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, id);
            } catch (Exception e) {
                log.info("公共字段填充失败:{}", e.getMessage());
            }

        }


    }


}
