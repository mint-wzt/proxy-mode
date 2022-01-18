package com.wzt.proxy.statics;

import com.wzt.proxy.service.SmsService;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }

    @Override
    public String sayHello(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method sayHello()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method sayHello()");
        return null;
    }
}
