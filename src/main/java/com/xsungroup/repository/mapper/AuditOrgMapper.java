package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.org.AuditOrg;

public interface AuditOrgMapper {
    int deleteByPrimaryKey(String pk);

    int insert(AuditOrg record);

    int insertSelective(AuditOrg record);

    AuditOrg selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(AuditOrg record);

    int updateByPrimaryKey(AuditOrg record);
}