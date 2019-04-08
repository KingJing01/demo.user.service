package com.xsungroup.utils.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author : Lilei
 * @Description : 用户渠道
 * @Date : 2019/4/6
 */
public interface UserChannel {

    /**
     * 发消息的通道名称
     */
    String USER_OUTPUT = "user_output";

    /**
     * 消息的订阅通道名称
     */
    String USER_INPUT = "user_input";

    /**
     * 发消息的通道
     *
     * @return
     */
    @Output(USER_OUTPUT)
    MessageChannel sendUserMessage();

    /**
     * 收消息的通道
     *
     * @return
     */
    @Input(USER_INPUT)
    SubscribableChannel recieveUserMessage();

}
