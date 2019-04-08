package com.xsungroup.domain.factory;

import com.xsungroup.domain.model.user.UserModel;
import com.xsungroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Lilei
 * @Description : user模型工厂类
 * @Date : 2019/4/4
 */
@Component
public class UserFactory {

    @Autowired
    private UserRepository userRepository;
    public UserModel getUser(){
        return new UserModel();
    }
}
