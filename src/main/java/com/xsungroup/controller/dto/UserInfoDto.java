package com.xsungroup.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
  @Size(max = 20, min = 5,groups = {UserInfoModify.class,UserInfoAdd.class},message = "请检查长度")
  private String userName;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "姓名不能为空")
  @Size(max = 20, min = 5,groups = {UserInfoModify.class,UserInfoAdd.class},message = "请检查长度")
  private String displayName;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "手机号不能为空")
  @Pattern(groups = {UserInfoModify.class,UserInfoAdd.class},regexp = "1[3|4|5|7|8][0-9]\\d{8}",message = "请检查手机号是否正确")
  private String phoneNum;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "密码不能为空")
  @Size(max = 20, min = 5,groups = {UserInfoModify.class,UserInfoAdd.class},message = "请检查长度")
  private String password;
  @NotBlank(groups = {UserInfoModify.class,UserInfoAdd.class},message = "角色不能为空")
  private String pkRole;

  /**
   * 顶级组织范围
   */
  private String topOrgRange;
  /**
   * 创建组织范围
   */
  private String createOrgRange;

  /**
   * 查看组织范围
   */
  private String orgRange;

  /**
   * 运输模式  0:全部  1:整车  2:零担
   */
  private Integer transportType;

  /**
   * 暂定失效  0:否  1:是
   */
  private String dr;

  /**
   * 创建组织
   */
  private Integer isValid;

  public interface UserInfoAdd{}

  public interface UserInfoModify{}
}


