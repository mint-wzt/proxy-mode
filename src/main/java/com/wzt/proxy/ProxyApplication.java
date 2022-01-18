package com.wzt.proxy;

import com.wzt.proxy.cglib.AliSmsService;
import com.wzt.proxy.cglib.CglibProxyFactory;
import com.wzt.proxy.jdk.JdkProxyFactory;
import com.wzt.proxy.statics.SmsProxy;
import com.wzt.proxy.service.SmsService;
import com.wzt.proxy.service.SmsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wzt
 */
@SpringBootApplication
public class ProxyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProxyApplication.class, args);

        //静态代理
        ProxyApplication.staticProxy();

        //JDK动态代理
        ProxyApplication.jdkProxy();

        //CGLIB动态代理
        ProxyApplication.cglibProxy();
    }

    /**
     * 静态代理模式
     */
    public static void staticProxy(){
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }

    /**
     * JDK动态代理
     */
    public static void jdkProxy(){
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
        smsService.sayHello("hello world");
    }

    /**
     * CGLIB动态代理
     */
    public static void cglibProxy(){
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        System.out.println(aliSmsService.getClass());
        aliSmsService.send("java");
    }

}
