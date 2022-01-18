package com.wzt.proxy.jdk;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class JdkProxyFactory {

    /**
     * target.getClass().getClassLoader(), // 目标类的类加载
     * target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
     * new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
     * @param target
     * @return
     */
    public static Object getProxy(Object target) {
        System.out.println("(JDK动态代理)接口："+Arrays.toString(target.getClass().getInterfaces()));
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
