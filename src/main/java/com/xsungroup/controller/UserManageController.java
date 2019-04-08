package com.xsungroup.controller;

import com.xinya.tools.constant.OperatorConstant;
import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.res.PageResponse;
import com.xinya.tools.rest.dto.ResponseBaseDto;
import com.xinya.tools.utils.StringUtils;
import com.xsungroup.controller.dto.UserInfoDto;
import com.xsungroup.controller.dto.UserInfoDto.UserInfoAdd;
import com.xsungroup.controller.dto.UserInfoDto.UserInfoModify;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.controller.vo.UserInfoListVo;
import com.xsungroup.service.UserService;
import com.xsungroup.utils.exception.BadRequestException;
import com.xsungroup.utils.exception.UserErrorEnum;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
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
   * @Description  用户列表查询
   * @Date 11:03 2019/4/6
   * @Param [request, response]
   * @return org.springframework.data.domain.Page
   **/
  @ApiOperation(value="用户列表查询", notes = "用户列表查询")
  @GetMapping(value = "findUserList")
  public PageResponse<UserInfoListVo> findUserInfoList (HttpServletRequest request, HttpServletResponse response,
      @RequestBody(required = false) UserInfoListDto userInfoListDto) {
    Page<UserInfoListVo> userList = userService.findUserList(userInfoListDto);
    return PageResponse.succeed(userList.getContent(),userList.getTotal());
  }

  /**
   * @Author Chenman
   * @Description  添加用户信息
   * @Date 11:20 2019/4/6
   * @Param [request, response, userInfoDto]
   * @return void
   **/
  @ApiOperation(value="添加用户信息", notes = "添加用户信息")
  @PostMapping(Url.USER_MANAGER_ADDUSER)
  public ResponseBaseDto addUserInfo(HttpServletRequest request, HttpServletResponse response,
      @RequestBody @Validated(UserInfoAdd.class) UserInfoDto userInfoDto, BindingResult result) {

    // 参数校验
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        return new ResponseBaseDto(error.getDefaultMessage(),OperatorConstant.RETURN_FAILURE);
      }
    }

    // 业务逻辑处理
    userService.saveOrModifyUserInfo(userInfoDto);
    return ResponseBaseDto.succeed();
  }

  /**
   * @Author Chenman
   * @Description  修改用户信息
   * @Date 15:41 2019/4/6
   * @Param [request, response, userInfoDto, result]
   * @return void
   **/
  @ApiOperation(value="修改用户信息", notes = "修改用户信息")
  @PutMapping(Url.USER_MANAGER_MODIFYUSER)
  public ResponseBaseDto modifyUserInfo(HttpServletRequest request, HttpServletResponse response,
      @RequestBody @Validated(UserInfoModify.class) UserInfoDto userInfoDto, BindingResult result) {

    // 参数校验
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        return new ResponseBaseDto(error.getDefaultMessage(),OperatorConstant.RETURN_FAILURE);
      }
    }

    // 业务逻辑处理
    userService.saveOrModifyUserInfo(userInfoDto);
    return ResponseBaseDto.succeed();
  }

  /**
   * @Author Chenman
   * @Description  删除此用户
   * @Date 15:02 2019/4/6
   * @Param [request, response, pks]
   * @return void
   **/
  @ApiOperation(value="删除此用户", notes = "删除此用户")
  @DeleteMapping(Url.USER_MANAGER_DELETEUSER)
  public ResponseBaseDto modifyUserInfo(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("pks") String pks) {

    // 参数校验
    Optional.ofNullable(pks).orElseThrow(()->new BadRequestException("CPE_1001","请检查主键！"));

    // 业务逻辑处理
    userService.removeUser(pks);
    return ResponseBaseDto.succeed();
  }

  /**
   * @Author Chenman
   * @Description  密码重置
   * @Date 18:34 2019/4/8
   * @Param []
   * @return com.xinya.tools.rest.dto.ResponseBaseDto
   **/
  @ApiOperation(value="密码重置", notes = "密码重置")
  @PutMapping(Url.USER_MANAGER_PASSWORD_RESET)
  public ResponseBaseDto passwordReset(HttpServletRequest request, HttpServletResponse response,
      @RequestParam String newPwd) {

    // 校验
    if (StringUtils.isBlank(newPwd)) {
      return ResponseBaseDto.error(UserErrorEnum.CHECK_NEWPWD_ERRORO);
    }
    String userPk = "";
    userService.updateSelect(userPk,newPwd);
    return ResponseBaseDto.succeed();
  }


}
