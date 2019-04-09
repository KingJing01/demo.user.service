package com.xsungroup.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsungroup.domain.event.SendSmsEvent;
import com.xsungroup.domain.model.basis.CheckCodeModel;
import com.xsungroup.domain.model.basis.SmsRecordModel;
import com.xsungroup.repository.mapper.CheckCodeMapper;
import com.xsungroup.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lilei
 * @Description : 验证业务编排
 * @Date : 2019/4/6
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {


    @Autowired
    private SendSmsEvent sendSmsEvent;
    @Autowired
    private CheckCodeMapper checkCodeMapper;

    @Override
    public void sendCheck(String phone, String type) {
        CheckCodeModel model = new CheckCodeModel(phone,Integer.parseInt(type));
        checkCodeMapper.deleteByPhone(phone);
        checkCodeMapper.insertSelective(model);
        Map<String,String> param =new HashMap(1);
        param.put("code",model.getCode());
        SmsRecordModel sms = new SmsRecordModel("SMS_139238346",model.getPhoneNum(),JSON.toJSONString(param));
        //boolean bool = sendUserMessageChannel.send(MessageBuilder.withPayload(sms).build());
        //todo 不成功自动触发 后期走mq
        sendSmsEvent.sendSms(sms);
    }
}
