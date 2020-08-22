package com.lvym.springcloud.service;


import com.lvym.springcloud.entities.Payment;


public interface IPayMentService {
  public   int addPay(Payment payment);
   public Payment getPaymentById(Long id);
}
