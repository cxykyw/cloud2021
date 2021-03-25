package com.kyw.springcloud.controller;

import com.kyw.springcloud.entities.CommonResult;
import com.kyw.springcloud.entities.Payment;
import com.kyw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int count = paymentService.create(payment);
        log.info("####插入结果####:"+count);
        if(count > 0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,count);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id")Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("####查询结果####:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(500,"无记录,查询ID："+id,null);
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            log.info("*******element********:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
