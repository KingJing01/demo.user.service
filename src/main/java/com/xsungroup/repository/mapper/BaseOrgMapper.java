package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.org.OrgModel;

public interface BaseOrgMapper {
    int deleteByPrimaryKey(String pk);

    int insert(OrgModel record);

    int insertSelective(OrgModel record);

    OrgModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(OrgModel record);

    int updateByPrimaryKey(OrgModel record);
}