package com.xsungroup.service;

import com.xinya.tools.mybatis.page.Page;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.domain.model.org.OrgModel;

public interface BaseOrgService {


    String addCompany (BaseOrgDto baseOrgDto);

    void deleCompany (String pk);

    void editCompany (BaseOrgDto baseOrgDto);

    Page<OrgModel> selectCompany (BaseOrgDto baseOrgDto);

    OrgModel complaintDetail (String pk);

}
