package com.xsungroup.controller;

import com.xinya.tools.res.PageResponse;
import com.xinya.tools.res.ResultResponse;
import com.xsungroup.controller.dto.OrgAuditDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
* @Description: 企业信息审核Controller
* @Author: liyoujing
* @Date: 2019/4/9 15:59
**/
@RestController
@RequestMapping(value = "org/audit")
public class OrgAuditController  {

    @PostMapping(value = "findOrgAuditPage")
    public PageResponse findOrgAuditPage(@RequestBody OrgAuditDto dto){
        Pageable pageable = new PageRequest(dto.getPageNum()-1,dto.getPageSize());
        return PageResponse.succeed(new ArrayList<>(),10L,"成功");
    }
}
