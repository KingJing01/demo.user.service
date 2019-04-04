package com.xsungroup.service.impl;

import com.xinya.tools.utils.StringUtils;
import com.xsungroup.domain.model.user.User;
import com.xsungroup.repository.UserRepository;
import com.xsungroup.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  /**
   * 实体管理对象
   */
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<User> findUserList(Pageable pageable) {
    StringBuilder countSelectSql = new StringBuilder();
    countSelectSql.append("select count(*) from User po where 1=1 ");

    StringBuilder selectSql = new StringBuilder();
    selectSql.append("from User po where 1=1 ");

    Map<String,Object> params = new HashMap<>();
    StringBuilder whereSql = new StringBuilder();
    whereSql.append(" and user_name=:cpId ");
    params.put("cpId","aa");

    String countSql = new StringBuilder().append(countSelectSql).append(whereSql).toString();
    Query countQuery = this.entityManager.createQuery(countSql,Long.class);
    this.setParameters(countQuery,params);
    Long count = (Long) countQuery.getSingleResult();

    String querySql = new StringBuilder().append(selectSql).append(whereSql).toString();
    Query query = this.entityManager.createQuery(querySql,User.class);
    this.setParameters(query,params);
    if(pageable != null){ //分页
      query.setFirstResult((int) pageable.getOffset());
      query.setMaxResults(pageable.getPageSize());
    }

    List<User> userList = query.getResultList();
    if(pageable != null) { //分页
      Pageable page = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
      Page<User> pageUser = new PageImpl<>(userList, page, count);
      return pageUser;
    }else{ //不分页
      return new PageImpl<>(userList);
    }
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
