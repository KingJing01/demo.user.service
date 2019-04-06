package com.xsungroup.service;

import com.xsungroup.controller.dto.UserInfoDto;
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

  /**
   * @Author Chenman
   * @Description  添加用户信息
   * @Date 11:47 2019/4/6
   * @Param [userInfoDto]
   * @return void
   **/
  void saveOrModifyUserInfo(UserInfoDto userInfoDto);

  /**
   * @Author Chenman
   * @Description  删除用户信息
   * @Date 14:29 2019/4/6
   * @Param [pks]
   * @return void
   **/
  void removeUser(String pks);
}
