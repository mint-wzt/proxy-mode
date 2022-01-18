package com.wzt.proxy.cglib;

/**
 * @author wzt
 * @date 2022-01-09
 */
public class AliSmsService {

    public String send(String message) {
        System.out.println("CGLIB：send message:" + message);
        return message;
    }
}
