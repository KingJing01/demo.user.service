package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.document.AuditDriver;

public interface AuditDriverMapper {
    int deleteByPrimaryKey(String pk);

    int insert(AuditDriver record);

    int insertSelective(AuditDriver record);

    AuditDriver selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(AuditDriver record);

    int updateByPrimaryKey(AuditDriver record);
}