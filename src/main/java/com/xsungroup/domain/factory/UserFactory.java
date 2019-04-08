package com.xsungroup.domain.factory;

import com.xsungroup.domain.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Lilei
 * @Description : user模型工厂类
 * @Date : 2019/4/4
 */
@Component
public class UserFactory {

    public UserModel getUser(){
        return new UserModel();
    }
}
