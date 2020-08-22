package com.lvym.alibaba.service.impl;

import com.lvym.alibaba.dao.AccountDao;
import com.lvym.alibaba.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
  //     try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
