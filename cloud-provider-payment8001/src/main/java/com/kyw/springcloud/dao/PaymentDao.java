package com.kyw.springcloud.dao;

import com.kyw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Description TODO
 * @Date 2021/3/22 22:44
 * @Created by kyw
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
