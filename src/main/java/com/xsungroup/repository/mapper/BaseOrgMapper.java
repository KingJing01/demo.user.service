package com.xsungroup.repository.mapper;

import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.mybatis.page.Pageable;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.domain.model.org.OrgModel;
import org.apache.ibatis.annotations.Param;

public interface BaseOrgMapper {
    int deleteByPrimaryKey(String pk);

    int insert(OrgModel record);

    int insertSelective(OrgModel record);

    OrgModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(OrgModel record);

    int updateByPrimaryKey(OrgModel record);


    Page<OrgModel> selectCompany(Pageable pageable, @Param("param")BaseOrgDto complaintDto);
}