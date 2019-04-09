package com.xsungroup.service;

import com.xinya.tools.mybatis.page.Page;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.repository.entity.BaseOrgEntity;

public interface BaseOrgService {


    String addCompany (BaseOrgDto baseOrgDto);

    void deleCompany (String pk);

    void editCompany (BaseOrgDto baseOrgDto);

    Page<BaseOrgEntity> selectCompany (BaseOrgDto baseOrgDto);

    BaseOrgEntity complaintDetail (String pk);

}
