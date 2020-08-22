package com.lvym.springcloud.dao;


import com.lvym.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PayMentDao {

     int addPay(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
