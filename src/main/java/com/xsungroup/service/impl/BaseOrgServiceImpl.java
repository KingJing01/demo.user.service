package com.xsungroup.service.impl;


import com.xinya.tools.mybatis.page.Page;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.domain.model.org.OrgModel;
import com.xsungroup.service.BaseOrgService;
import org.springframework.stereotype.Service;

@Service
public class BaseOrgServiceImpl implements BaseOrgService {

    @Override
    public String addCompany(BaseOrgDto baseOrgDto) {
        return null;
    }

    @Override
    public void deleCompany(String pk) {

    }

    @Override
    public void editCompany(BaseOrgDto baseOrgDto) {

    }

    @Override
    public Page<OrgModel> selectCompany(BaseOrgDto baseOrgDto) {
        return null;
    }

    @Override
    public OrgModel complaintDetail(String pk) {
        return null;
    }
}
