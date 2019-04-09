package com.xsungroup.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseOrgDto {
    private String pk;

    private String orgName;

    private Integer source;

    private String orgCode;

    private Integer orgType;

    private Integer legalPerson;

    private Integer accountant;

    private Integer operation;

    private String parentPk;

    private String business;

    private String legalPersonIdCard;

    private String roadTransport;

    private String auditStatus;

    private String dangerTransport;

    private String warrant;

    private Integer dr;

    private String ts;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private int pageNum = 1;

    private int pageSize = 10;
}
