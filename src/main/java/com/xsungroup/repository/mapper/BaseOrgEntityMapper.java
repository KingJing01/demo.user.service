package com.xsungroup.repository.mapper;

import com.xsungroup.repository.entity.BaseOrgEntity;

public interface BaseOrgEntityMapper {
    int deleteByPrimaryKey(String pk);

    int insert(BaseOrgEntity record);

    int insertSelective(BaseOrgEntity record);

    BaseOrgEntity selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(BaseOrgEntity record);

    int updateByPrimaryKey(BaseOrgEntity record);
}