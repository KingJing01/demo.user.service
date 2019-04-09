package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.Permission;

public interface BasePermissionMapper {
    int deleteByPrimaryKey(String pk);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}