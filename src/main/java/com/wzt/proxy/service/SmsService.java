package com.wzt.proxy.service;

/**
 * @author wzt
 * @date 2022-01-09
 */
public interface SmsService {

    /**
     * 发送短信
     * @param message
     * @return
     */
    String send(String message);

    /**
     * 打招呼
     * @param message
     * @return
     */
    String sayHello(String message);
}
