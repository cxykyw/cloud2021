package com.kyw.springcloud.service;

import com.kyw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2021/3/22 22:54
 * @Created by kyw
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
