package com.sky.context;

/**
 * 基于ThreadLocal封装根据类，用于存储和获取当前线程的用户ID和上下文信息
 */
public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
//ThreadLocal绑定的是线程的生命周期，如果不动手清理，线程池复用导致数据错乱
    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
//应用场景
//1.在Spring Boot中获取当前用户ID在拦截器，过滤器或AOP切面中，登录成功后，将用户ID存入BaseContext
//避免使用 ThreadLocal 传递全局变量
//        ThreadLocal 适用于 线程隔离的数据，不适用于全局共享的数据。
//        注意 ThreadLocal 在线程池环境下的影响
//        线程池会复用线程，如果不手动 remove()，可能会导致数据泄漏或数据错乱。
//        尽量封装 ThreadLocal 访问
//        通过 BaseContext 统一管理 ThreadLocal，避免外部代码直接访问 threadLocal 变量。