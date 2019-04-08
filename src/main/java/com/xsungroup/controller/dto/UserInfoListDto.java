package com.xsungroup.controller.dto;

import lombok.Data;

/**
 * @program: xsungroup.user.interface
 * @description: 用户管理列表查询dto
 * @author: ChenMan
 * @create: 2019-04-06 16:22
 */
@Data
public class UserInfoListDto {
  private String userName;
  private String displayName;
  private String pkRole;
  private int pageNum = 1;
  private int pageSize = 10;
}
