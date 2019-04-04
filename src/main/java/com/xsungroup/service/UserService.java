package com.xsungroup.service;

import com.xsungroup.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @program: xsungroup.user.interface
 * @description: 用户信息服务
 * @author: ChenMan
 * @create: 2019-04-04 17:03
 */
public interface UserService {

  Page<User> findUserList(Pageable pageable);
}
