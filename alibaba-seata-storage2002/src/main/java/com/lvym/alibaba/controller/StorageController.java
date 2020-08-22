package com.lvym.alibaba.controller;

import com.lvym.alibaba.domain.CommonResult;
import com.lvym.alibaba.domain.Storage;
import com.lvym.alibaba.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {


    @Autowired
    private IStorageService iStorageService;

    //扣减库存  @PostMapping("/storage/decrease")
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        iStorageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
    @RequestMapping("/storage/check")
    public CommonResult check(@RequestParam("productId") Long productId) {
      Storage storage=iStorageService.check(productId);
        return new CommonResult(200,"扣减库存成功！",storage);
    }


}
