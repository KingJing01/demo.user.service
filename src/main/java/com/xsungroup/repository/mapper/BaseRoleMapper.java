package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.Role;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(String pk);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}