package com.xsungroup.controller;


import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.res.PageResponse;
import com.xinya.tools.res.ResultResponse;
import com.xinya.tools.rest.dto.ResponseBaseDto;
import com.xsungroup.controller.dto.BaseOrgDto;
import com.xsungroup.domain.model.org.OrgModel;
import com.xsungroup.service.BaseOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Alex
 * @Description : 单位(公司)模块的控制器
 * @Date : 2019/4/8
 */
@RestController
public class CompanyController {

    @Autowired
    private BaseOrgService baseOrgService;

    //新增单位（就是公司）
    @PostMapping(Url.ADDCOMPANY)
    public ResponseBaseDto addCompany(@RequestBody BaseOrgDto baseOrgDto){
        String pk = "";
        pk = baseOrgService.addCompany(baseOrgDto);
        return new ResultResponse(pk);
    }

    //删除单位（原型图上没有这个功能，先预留，防添加）
    @PostMapping(Url.DELECOMPANY)
    public ResponseBaseDto deleCompany(@RequestBody BaseOrgDto baseOrgDto){
        baseOrgService.deleCompany(baseOrgDto.getPk());
        return ResponseBaseDto.succeed();
    }


    /**
     * @Description //修改单位（编辑）
     * @param baseOrgDto
     * @return
     * @Author Alex
     * @Date 2019 4 9
     */


    @PostMapping(Url.EDITCOMPANY)
    public ResponseBaseDto editCompany(@RequestBody BaseOrgDto baseOrgDto){
        baseOrgService.editCompany(baseOrgDto);
        return ResponseBaseDto.succeed();
    }

    //查列表的接口
    @PostMapping(Url.SELECTCOMPANY)
    public PageResponse<OrgModel> selectCompany(@RequestBody BaseOrgDto baseOrgDto){
        Page<OrgModel> complaintDtos = null;
        complaintDtos = baseOrgService.selectCompany(baseOrgDto);
        return PageResponse.succeed(complaintDtos.getContent(),complaintDtos.getTotal());
    }

    //详情的接口
    @PostMapping(Url.DETAILCOMPANY)
    public ResponseBaseDto complaintDetail(@RequestBody BaseOrgDto baseOrgDto){
        return new ResultResponse(baseOrgService.complaintDetail(baseOrgDto.getPk()));
    }
}
