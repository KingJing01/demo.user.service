package com.xsungroup.service;

import com.xinya.tools.mybatis.page.Page;
import com.xsungroup.controller.dto.UserInfoDto;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.controller.vo.UserInfoListVo;
import com.xsungroup.domain.model.user.UserModel;

/**
 * @program: xsungroup.user.interface
 * @description: 用户信息服务
 * @author: ChenMan
 * @create: 2019-04-04 17:03
 */
public interface UserService {

  Page<UserInfoListVo> findUserList(UserInfoListDto userInfoListDto);

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

  /**
   * @Author Chenman
   * @Description
   * @Date 18:40 2019/4/8
   * @Param [userPk,newPwd]
   * @return void
   **/
  void updateSelect(String userPk,String newPwd);

  /**
   * @Author Chenman
   * @Description  通过主键查询用户信息
   * @Date 18:49 2019/4/8
   * @Param [userPk]
   * @return com.xsungroup.domain.model.user.UserModel
   **/
  UserModel findByPk(String userPk);
}
