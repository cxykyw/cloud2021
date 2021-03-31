package com.kyw.springcloud.service;

import com.kyw.springcloud.entities.CommonResult;
import com.kyw.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kyw
 * @version 1.0
 * @date 2021/3/31 15:00
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    public String timeOut();
}
