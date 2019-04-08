package com.xsungroup.service.impl;

import com.xinya.tools.utils.StringUtils;
import com.xsungroup.controller.dto.UserInfoDto;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.controller.vo.UserInfoListVo;
import com.xsungroup.domain.enums.TransModeEnum;
import com.xsungroup.domain.model.user.Organization;
import com.xsungroup.domain.model.user.Role;
import com.xsungroup.domain.model.user.UserModel;
import com.xsungroup.repository.RoleRepository;
import com.xsungroup.repository.UserRepository;
import com.xsungroup.service.UserService;
import com.xsungroup.utils.ModelUtils;
import com.xsungroup.utils.UUIDUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  /**
   * 实体管理对象
   */
  @PersistenceContext
  private EntityManager entityManager;


  @Override
  public Page<UserInfoListVo> findUserList(PageRequest pageRequest,UserInfoListDto userInfoListDto) {
    StringBuilder countSelectSql = new StringBuilder();
    countSelectSql.append("select count(*) from t_base_user user where 1=1 ");

    StringBuilder selectSql = new StringBuilder();
    selectSql.append(" SELECT ");
    selectSql.append("    user.pk, user.user_name as userName, user.display_name as displayName, ");
    selectSql.append("    user.phone_num as phoneNum, role.role_name as roleName, ");
    selectSql.append("    org.org_name as orgName, user.last_login_time as lastLoginTime, ");
    selectSql.append("    user.dr, company.org_name as companyName ");
    selectSql.append(" FROM t_base_user user ");
    selectSql.append(" LEFT JOIN t_base_role role ON user.pk_role = role.pk");
    selectSql.append(" LEFT JOIN t_base_org org ON user.pk_top_org = org.pk");
    selectSql.append(" LEFT JOIN t_base_org company ON user.pk_create_org = company.pk");
    selectSql.append(" WHERE 1=1 ");

    // 拼接参数
    Map<String,Object> params = new HashMap<>();
    StringBuilder whereSql = new StringBuilder();
    String userName = userInfoListDto.getUserName();
    if(StringUtils.isNotBlank(userName)){
      whereSql.append(" and user_name=:userName ");
      params.put("userName",userName);
    }

//    String displayName = userInfoListDto.getDisplayName();
//    if(StringUtils.isNotBlank(displayName)){
//      whereSql.append(" and display_name='aaaa' ");
//      params.put("displayName","aaaa");
//    }

    String pkRole = userInfoListDto.getPkRole();
    if(StringUtils.isNotBlank(pkRole)){
      whereSql.append(" and pk_role=:pkRole ");
      params.put("pkRole",pkRole);
    }

    String countSql = new StringBuilder().append(countSelectSql).append(whereSql).toString();
    Query countQuery = this.entityManager.createNativeQuery(countSql,UserInfoListVo.class);
    for(Map.Entry<String,Object> entry:params.entrySet()){
      countQuery.setParameter(entry.getKey(),entry.getValue());
    }
//    BigInteger totalCount = (BigInteger)countQuery.getSingleResult();

    String querySql = new StringBuilder().append(selectSql).append(whereSql).toString();
    Query query = this.entityManager.createNativeQuery(querySql,UserInfoListVo.class);

    for(Map.Entry<String,Object> entry:params.entrySet()){
      countQuery.setParameter(entry.getKey(),entry.getValue());
    }

    query.setFirstResult((pageRequest.getPageNumber()-1)*pageRequest.getPageSize());
    query.setMaxResults(pageRequest.getPageSize());

    List<UserInfoListVo> userList = query.getResultList();
    if(pageRequest != null) { //分页
      Page<UserInfoListVo> pageUser = new PageImpl<>(userList, pageRequest, 100L);
      return pageUser;
    }else{ //不分页
      return new PageImpl<>(userList);
    }
  }

  @Override
  public void saveOrModifyUserInfo(UserInfoDto userInfoDto) {
    UserModel user;
    if (StringUtils.isBlank(userInfoDto.getPk())) {
      user = new UserModel();
      ModelUtils.newModel(user,"admin",new Date());
    } else {
      user = userRepository.findById(userInfoDto.getPk()).get();
      ModelUtils.modifyModel(user,"admin",new Date());
    }

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
    Organization topOrgRange = new Organization();
    topOrgRange.setPk(userInfoDto.getPkTopOrg());
    user.setTopOrg(topOrgRange);
    // 创建组织范围
    Organization createOrgRange = new Organization();
    createOrgRange.setPk(userInfoDto.getPkCreateOrg());
    user.setCreateOrg(createOrgRange);
    // 查看组织范围
    Organization selectOrgRange = new Organization();
    selectOrgRange.setPk(userInfoDto.getPkSelectOrg());
    // 查看组织范围 todo
    user.setTransModeEnum(TransModeEnum.COLDCHAIN);
    Organization createOrg = new Organization();
    createOrg.setPk(userInfoDto.getPkCreateOrg());
    userRepository.save(user);

  }

  @Override
  public void removeUser(String pks) {
    String[] split = StringUtils.split(pks, ",");
    List<String> pkStrList = Arrays.asList(split);
    String currentUserPk = "";
    String ts = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS").format(new Date());
    userRepository.deleteBatch(pkStrList,currentUserPk,new Date(),ts);
  }


  /**
   * 给hql参数设置值
   * @param query 查询
   * @param params 参数
   */
  private void setParameters(Query query,Map<String,Object> params){
    for(Map.Entry<String,Object> entry:params.entrySet()){
      query.setParameter(entry.getKey(),entry.getValue());
    }
  }

}
