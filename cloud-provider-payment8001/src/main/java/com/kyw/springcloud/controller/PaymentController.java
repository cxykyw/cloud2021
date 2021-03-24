package com.kyw.springcloud.controller;

import com.kyw.springcloud.entities.CommonResult;
import com.kyw.springcloud.entities.Payment;
import com.kyw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2021/3/22 22:56
 * @Created by kyw
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int count = paymentService.create(payment);
        log.info("####插入结果####:"+count);
        if(count > 0){
            return new CommonResult(200,"插入数据成功",count);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id")Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("####查询结果####:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(500,"无记录,查询ID："+id,null);
        }

    }

}
