package com.lvym.alibaba.controller.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lvym.springcloud.common.CommonResult;


public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
}
