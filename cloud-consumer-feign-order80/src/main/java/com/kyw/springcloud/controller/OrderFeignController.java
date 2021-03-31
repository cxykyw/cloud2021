package com.kyw.springcloud.controller;

import com.kyw.springcloud.entities.CommonResult;
import com.kyw.springcloud.entities.Payment;
import com.kyw.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyw
 * @version 1.0
 * @date 2021/3/31 15:09
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/feign/get/{id}")
    public CommonResult<Payment> getByid(@PathVariable("id")Long id){
       return paymentFeignService.queryById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String timeOut(){
        //openfeign默认等待1秒钟
        return paymentFeignService.timeOut();
    }
}
