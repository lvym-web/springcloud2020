package com.lvym.alibaba.dao;

import com.lvym.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
     //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
    Storage check(Long productId);
}
