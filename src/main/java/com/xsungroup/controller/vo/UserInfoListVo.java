package com.xsungroup.controller.vo;

import lombok.Data;

/**
 * @program: xsungroup.user.interface
 * @description: 用户管理响应vo
 * @author: ChenMan
 * @create: 2019-04-06 16:41
 */
@Data
public class UserInfoListVo {

  private String pk;

  private String userName;

  private String displayName;

  private String phoneNum;

  private String roleName;

  private String orgName;

  private String lastLoginTime;

  private String dr;

  private String companyName;


}
