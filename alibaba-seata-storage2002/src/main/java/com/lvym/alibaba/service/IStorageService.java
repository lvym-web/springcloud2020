package com.lvym.alibaba.service;

import com.lvym.alibaba.domain.Storage;

public interface IStorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
    Storage check(Long productId);

}
