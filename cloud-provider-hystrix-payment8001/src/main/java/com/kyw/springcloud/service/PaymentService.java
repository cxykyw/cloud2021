package com.kyw.springcloud.service;

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

    public String paymentInfo_TimeOut(Integer id){
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"(#^.^#),耗时"+timeout+"秒";
    }
}
