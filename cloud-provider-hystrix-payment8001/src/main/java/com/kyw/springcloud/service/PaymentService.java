package com.kyw.springcloud.service;

import org.springframework.stereotype.Service;

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
}
