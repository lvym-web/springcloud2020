package com.lvym.springcloud.service.impl;


import com.lvym.springcloud.dao.PayMentDao;
import com.lvym.springcloud.entities.Payment;
import com.lvym.springcloud.service.IPayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayMentServiceImpl implements IPayMentService {
    @Autowired
    private PayMentDao payMentDao;

    public int addPay(Payment payment){
        return payMentDao.addPay(payment);
    }
    public Payment getPaymentById(Long id){
        return payMentDao.getPaymentById(id);
    }


}
