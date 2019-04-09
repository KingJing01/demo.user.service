package com.xsungroup.service.impl;

import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.mybatis.page.Pageable;
import com.xinya.tools.utils.StringUtils;
import com.xsungroup.controller.dto.UserInfoDto;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.controller.vo.UserInfoListVo;
import com.xsungroup.domain.model.user.Role;
import com.xsungroup.domain.model.user.UserModel;
import com.xsungroup.repository.mapper.UserMapper;
import com.xsungroup.service.UserService;
import com.xsungroup.utils.ModelUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: xsungroup.user.interface
 * @description: 用户信息实现层
 * @author: ChenMan
 * @create: 2019-04-04 17:04
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;


  @Override
  public Page<UserInfoListVo> findUserList(UserInfoListDto userInfoListDto) {
    return userMapper.findUserList(new Pageable(userInfoListDto.getPageNum() - 1,
            userInfoListDto.getPageSize()), userInfoListDto);
  }

  @Override
  public void saveOrModifyUserInfo(UserInfoDto userInfoDto) {
    UserModel user = new UserModel();
    user.setDisplayName(userInfoDto.getDisplayName());
    user.setUserName(userInfoDto.getUserName());
    // todo 密码需要处理
    user.setPassword(userInfoDto.getPassword());
    user.setPhoneNum(userInfoDto.getPhoneNum());
    // 用户所属角色
    Role role = new Role();
    role.setPk(userInfoDto.getPkRole());
    user.setRole(role);
    // 顶级组织范围
    user.setTopOrgRange(userInfoDto.getTopOrgRange());
    // 创建组织范围
    user.setCreateOrgRange(userInfoDto.getCreateOrgRange());
    // 查看组织范围
    user.setOrgRange(userInfoDto.getOrgRange());
//    user.setTransportMode(TransModeEnum.valueOf());

    if (StringUtils.isBlank(userInfoDto.getPk())) {
      ModelUtils.newModel(user, "admin", new Date());
      userMapper.insertSelective(user);
    } else {
      ModelUtils.modifyModel(user, "admin", new Date());
      user.setPk(userInfoDto.getPk());
      userMapper.updateByPrimaryKeySelective(user);
    }
  }

  @Override
  public void removeUser(String pks) {
    List<String> pkStrList = Arrays.asList(StringUtils.split(pks, ","));
    String currentUserPk = "";
    userMapper.deleteBatch(pkStrList,currentUserPk);
  }

  @Override
  public void updateSelect(String userPk,String newPwd) {
    UserModel userModel = userMapper.selectByPrimaryKey(userPk);
    userModel.setPassword(newPwd);
    userMapper.updateByPrimaryKeySelective(userModel);
  }

  @Override
  public UserModel findByPk(String userPk) {
    return userMapper.selectByPrimaryKey(userPk);
  }



}
