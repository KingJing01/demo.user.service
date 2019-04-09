package com.xsungroup.repository.entity;

import org.unidal.lookup.container.model.BaseEntity;
import org.unidal.lookup.container.model.IVisitor;

import java.util.Date;

public class BaseOrgEntity extends BaseEntity {
    private String pk;

    private String orgName;

    private Integer source;

    private String orgCode;

    private Integer orgType;

    private Integer legalPerson;

    private Integer accountant;

    private Integer operation;

    private String parentPk;

    private String businessCode;

    private String legalPersonIdCard;

    private String roadTransport;

    private String dangerTransport;

    private String warrant;

    private Integer auditStatus;

    private Integer dr;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private String ts;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk == null ? null : pk.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Integer getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(Integer legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Integer getAccountant() {
        return accountant;
    }

    public void setAccountant(Integer accountant) {
        this.accountant = accountant;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getParentPk() {
        return parentPk;
    }

    public void setParentPk(String parentPk) {
        this.parentPk = parentPk == null ? null : parentPk.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    public String getLegalPersonIdCard() {
        return legalPersonIdCard;
    }

    public void setLegalPersonIdCard(String legalPersonIdCard) {
        this.legalPersonIdCard = legalPersonIdCard == null ? null : legalPersonIdCard.trim();
    }

    public String getRoadTransport() {
        return roadTransport;
    }

    public void setRoadTransport(String roadTransport) {
        this.roadTransport = roadTransport == null ? null : roadTransport.trim();
    }

    public String getDangerTransport() {
        return dangerTransport;
    }

    public void setDangerTransport(String dangerTransport) {
        this.dangerTransport = dangerTransport == null ? null : dangerTransport.trim();
    }

    public String getWarrant() {
        return warrant;
    }

    public void setWarrant(String warrant) {
        this.warrant = warrant == null ? null : warrant.trim();
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }

    @Override
    public void accept(IVisitor iVisitor) {

    }

    @Override
    public void mergeAttributes(Object o) {

    }
}