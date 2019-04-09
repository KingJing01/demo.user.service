package com.xsungroup.service;

import com.xsungroup.domain.model.basis.CheckCodeModel;

/**
 * @author : Lilei
 * @Description : 验证业务编排
 * @Date : 2019/4/6
 */
public interface UserCheckService {

    void sendCheck(String phone,String type);

}
