package com.xsungroup.domain.event;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.xsungroup.domain.model.basis.SmsRecordModel;
import com.xsungroup.repository.SmsRecordRepository;
import com.xsungroup.utils.AliSms;
import com.xsungroup.utils.channel.UserChannel;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @author : Lilei
 * @Description : 发送验证码监听
 * @Date : 2019/4/6
 */
@Log
@Component
public class SendSmsEvent {

    @Autowired
    private SmsRecordRepository smsRecordRepository;


    //@StreamListener(UserChannel.USER_INPUT)
    public void sendSmsReceive(Message<SmsRecordModel> message) {
        log.info("收到消息：" + message.getPayload());
        SmsRecordModel smsRecordModel = message.getPayload();
        sendSms(smsRecordModel);
    }

    public void sendSms(SmsRecordModel smsRecordModel) {
        smsRecordModel.setSendTime(new Date());
        AliSms.setTemplateCode(smsRecordModel.getType());
        try {
            //发送短信 调用aliapi
            SendSmsResponse smsResponse = AliSms.sendSms(smsRecordModel.getPhoneNum(), smsRecordModel.getParam());
            //记录返回结果
            Optional.ofNullable(smsResponse)
                    .filter(r -> {
                        smsRecordModel.setSendResult(r.getMessage());
                        return "200".equals(r.getCode()); })
                    .ifPresent(r -> smsRecordModel.setSendFlag(1));
        } catch (ClientException e) {
            log.info("发送短信失败:"+e.getErrMsg());
            smsRecordModel.setSendResult(e.getErrMsg());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("发送短信失败:"+e.getMessage());
            smsRecordModel.setSendResult(e.getMessage());
            e.printStackTrace();
        }
        //持久化
        smsRecordRepository.save(smsRecordModel);
    }

}
