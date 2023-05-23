package com.zhang.context;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/23 17:50
 **/


public class BaseContext {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void setCurrentId(Integer id) {
        threadLocal.set(id);
    }

    public static Integer getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }



}
