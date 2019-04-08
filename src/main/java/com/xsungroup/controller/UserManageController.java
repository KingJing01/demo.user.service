package com.xsungroup.controller;

import com.xsungroup.controller.dto.UserInfoDto;
import com.xsungroup.controller.dto.UserInfoDto.UserInfoAdd;
import com.xsungroup.controller.dto.UserInfoDto.UserInfoModify;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xsungroup.user.interface
 * @description: 用户管理
 * @author: ChenMan
 * @create: 2019-04-04 19:35
 */
@RestController
@RequestMapping(value = "userManage")
public class UserManageController {

  @Autowired
  private UserService userService;

  /**
   * @Author Chenman
   * @Description
   * @Date 11:03 2019/4/6
   * @Param [request, response]
   * @return org.springframework.data.domain.Page
   **/
  @GetMapping
  @RequestMapping(value = "findUserList")
  public Page findUserInfoList (HttpServletRequest request, HttpServletResponse response,
      @RequestBody(required = false) UserInfoListDto userInfoListDto) {
    PageRequest pageRequest = PageRequest.of(1, 10);
    return userService.findUserList(pageRequest,userInfoListDto);
  }

  /**
   * @Author Chenman
   * @Description  添加用户信息
   * @Date 11:20 2019/4/6
   * @Param [request, response, userInfoDto]
   * @return void
   **/
  @PostMapping(Url.USER_MANAGER_ADDUSER)
  public void addUserInfo(HttpServletRequest request, HttpServletResponse response,
      @RequestBody @Validated(UserInfoAdd.class) UserInfoDto userInfoDto, BindingResult result) {

    // 参数校验
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return;
    }

    // 业务逻辑处理
    userService.saveOrModifyUserInfo(userInfoDto);

  }

  /**
   * @Author Chenman
   * @Description  修改用户信息
   * @Date 15:41 2019/4/6
   * @Param [request, response, userInfoDto, result]
   * @return void
   **/
  @PutMapping(Url.USER_MANAGER_MODIFYUSER)
  public void modifyUserInfo(HttpServletRequest request, HttpServletResponse response,
      @RequestBody @Validated(UserInfoModify.class) UserInfoDto userInfoDto, BindingResult result) {

    // 参数校验
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return;
    }

    // 业务逻辑处理
    userService.saveOrModifyUserInfo(userInfoDto);
  }

  /**
   * @Author Chenman
   * @Description  删除此用户
   * @Date 15:02 2019/4/6
   * @Param [request, response, pks]
   * @return void
   **/
  @DeleteMapping(Url.USER_MANAGER_DELETEUSER)
  public void modifyUserInfo(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("pks") String pks) {

    // 业务逻辑处理
    userService.removeUser(pks);
  }
}
