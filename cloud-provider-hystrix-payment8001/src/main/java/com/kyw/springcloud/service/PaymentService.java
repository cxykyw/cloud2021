package com.kyw.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author kyw
 * @version 1.0
 * @date 2021/3/31 17:35
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"(#^.^#)";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_TimeOut(Integer id){
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a = 1/0;
//        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id:"+id+"\t"+"(#^.^#),耗时"+timeout+"秒";
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id:"+id+"\t"+"(#^.^#)";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id:"+id+"\t"+"(╯﹏╰)系统繁忙，请稍后再试";
    }
}
