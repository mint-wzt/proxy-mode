package com.wzt.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB：类："+o.getClass().getName());
        System.out.println("CGLIB：methodProxy.getSuperName："+methodProxy.getSuperName());
        //调用方法之前，我们可以添加自己的操作
        System.out.println("CGLIB：before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("CGLIB：after method " + method.getName());
        return object;
    }
}
