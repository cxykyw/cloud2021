package com.kyw.springcloud.service.impl;

import com.kyw.springcloud.dao.PaymentDao;
import com.kyw.springcloud.entities.Payment;
import com.kyw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description TODO
 * @Date 2021/3/22 22:54
 * @Created by kyw
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
