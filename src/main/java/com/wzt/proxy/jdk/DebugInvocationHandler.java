package com.wzt.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class DebugInvocationHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK: 代理类： " + proxy.getClass().getName());
        System.out.println("JDK: 目标类： " + target.getClass().getName());
        //调用方法之前，我们可以添加自己的操作
        System.out.println("JDK: before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("JDK: after method " + method.getName());
        return result;
    }
}
