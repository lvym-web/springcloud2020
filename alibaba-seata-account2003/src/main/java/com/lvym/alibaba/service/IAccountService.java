package com.lvym.alibaba.service;
import java.math.BigDecimal;

public interface IAccountService {

    void decrease(Long userId,BigDecimal money);
}
