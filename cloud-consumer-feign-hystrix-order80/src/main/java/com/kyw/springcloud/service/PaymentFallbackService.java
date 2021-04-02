package com.kyw.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级，兜底的方法
 * @author kyw
 * @version 1.0
 * @date 2021/4/2 16:27
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentOK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
