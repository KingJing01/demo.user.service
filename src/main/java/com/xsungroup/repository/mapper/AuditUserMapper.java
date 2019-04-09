package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.AuditUser;

public interface AuditUserMapper {
    int deleteByPrimaryKey(String pk);

    int insert(AuditUser record);

    int insertSelective(AuditUser record);

    AuditUser selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(AuditUser record);

    int updateByPrimaryKey(AuditUser record);
}