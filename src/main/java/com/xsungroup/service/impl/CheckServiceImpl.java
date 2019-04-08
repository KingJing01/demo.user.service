package com.xsungroup.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsungroup.domain.model.basis.CheckCodeModel;
import com.xsungroup.domain.model.basis.SmsRecordModel;
import com.xsungroup.repository.CheckCodeRepository;
import com.xsungroup.service.CheckService;
import com.xsungroup.utils.channel.UserChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lilei
 * @Description : 验证业务编排
 * @Date : 2019/4/6
 */
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckCodeRepository checkCodeRepository;

    @Resource(name = UserChannel.USER_OUTPUT)
    private MessageChannel sendUserMessageChannel;

    @Override
    public void sendCheck(CheckCodeModel model) {
        model = checkCodeRepository.save(model);
        Map<String,String> param =new HashMap(1);
        param.put("code",model.getCode());
        SmsRecordModel sms = new SmsRecordModel("SMS_139238346",model.getPhoneNum(),JSON.toJSONString(param));
        boolean bool = sendUserMessageChannel.send(MessageBuilder.withPayload(sms).build());
        //不成功自动触发
        if (!bool){

        }
    }
}
