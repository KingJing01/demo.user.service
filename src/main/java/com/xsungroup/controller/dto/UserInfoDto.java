package com.xsungroup.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * @program: xsungroup.user.interface
 * @description: 用户信息
 * @author: ChenMan
 * @create: 2019-04-06 11:12
 */
@Data
public class UserInfoDto {

  @NotNull(groups = {UserInfoModify.class},message = "主键不能为空")
  private String pk;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "用户名不能为空")
  private String userName;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "姓名不能为空")
  private String displayName;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "手机号不能为空")
  @Pattern(groups = {UserInfoModify.class,UserInfoAdd.class},regexp = "1[3|4|5|7|8][0-9]\\d{8}",message = "请检查手机号是否正确")
  private String phoneNum;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "密码不能为空")
  private String password;
  private String pkRole;
  private String pkOrg;

  /**
   * 顶级组织范围
   */
  private String pkTopOrg;
  /**
   * 创建组织范围
   */
  private String pkCreateOrg;

  /**
   * // TODO 查看组织范围
   */
  private String pkSelectOrg;

  /**
   * 运输模式  0:全部  1:整车  2:零担
   */
  private String transportType;


  public interface UserInfoAdd{}

  public interface UserInfoModify{}
}


