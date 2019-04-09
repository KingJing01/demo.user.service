package com.xsungroup.domain.model.org;

import lombok.Data;

import java.util.Date;

@Data
public class AuditOrg {
    private String pkOrg;

    private Integer status;

    private Integer auditMode;

    private String auditUser;

    private Date auditTime;

    private String auditMemo;


}