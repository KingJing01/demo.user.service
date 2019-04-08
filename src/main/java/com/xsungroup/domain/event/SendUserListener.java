package com.xsungroup.domain.event;

import com.xsungroup.utils.channel.UserChannel;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author : Lilei
 * @Description : 发送验证码监听
 * @Date : 2019/4/6
 */
@Component
public class SendUserListener {

    @StreamListener(UserChannel.USER_INPUT)
    public void sendSmsReceive(){

    }

}
