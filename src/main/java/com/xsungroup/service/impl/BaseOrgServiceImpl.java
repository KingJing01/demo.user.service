package com.xsungroup.service.impl;


import com.xinya.tools.mybatis.page.Page;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.repository.entity.BaseOrgEntity;
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
    public Page<BaseOrgEntity> selectCompany(BaseOrgDto baseOrgDto) {
        return null;
    }

    @Override
    public BaseOrgEntity complaintDetail(String pk) {
        return null;
    }
}
