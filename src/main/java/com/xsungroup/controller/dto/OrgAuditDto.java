package com.xsungroup.controller.dto;

import lombok.Data;

/**
 * @Description: 企业信息审核前台查询接受参数
 * @Author: liyoujing
 * @Date: 2019/4/9 16:33
 **/
@Data
public class OrgAuditDto {

  String contactNum;

  String orgName;

  String auditStatus;

  int pageNum = 1;

  int pageSize = 10;
}
