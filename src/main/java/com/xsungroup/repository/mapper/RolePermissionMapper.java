package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(String pk);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}