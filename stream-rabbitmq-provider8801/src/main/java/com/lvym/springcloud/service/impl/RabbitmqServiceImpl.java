package com.lvym.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lvym.springcloud.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Source.class)
public class RabbitmqServiceImpl implements IRabbitmqService {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("*****uuid: "+uuid);

        return null;
    }
}
