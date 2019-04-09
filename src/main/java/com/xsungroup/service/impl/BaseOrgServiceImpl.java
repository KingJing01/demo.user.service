package com.xsungroup.service.impl;


import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.mybatis.page.Pageable;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.domain.model.org.OrgModel;
import com.xsungroup.repository.mapper.BaseOrgMapper;
import com.xsungroup.service.BaseOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseOrgServiceImpl implements BaseOrgService {

    @Autowired
    private BaseOrgMapper baseOrgMapper;

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
        Page<OrgModel> baseOrgModel = baseOrgMapper.selectCompany(new Pageable(baseOrgDto.getPageNum()-1,baseOrgDto.getPageSize()),baseOrgDto);
        return baseOrgModel;
    }

    @Override
    public OrgModel complaintDetail(String pk) {
        return null;
    }
}
