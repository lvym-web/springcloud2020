package com.lvym.alibaba.service.impl;

import com.lvym.alibaba.dao.StorageDao;
import com.lvym.alibaba.domain.Storage;
import com.lvym.alibaba.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements IStorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");

    }

    @Override
    public Storage check(Long productId) {
        Storage storage=storageDao.check(productId);
        return storage;
    }
}
