package com.wzt.proxy.service;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class SmsServiceImpl implements SmsService{

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String sayHello(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
