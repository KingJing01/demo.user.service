package com.xsungroup.domain.model.org;

import com.xsungroup.domain.enums.SourceEnum;
import com.xsungroup.domain.model.base.Model;
import com.xsungroup.domain.model.document.*;
import lombok.Data;

import java.util.List;

@Data
public class OrgModel extends Model<OrgModel> {

    private String orgName;

    private SourceEnum source;

    private String orgCode;

    private Integer orgType;

    private Integer legalPerson;

    private Integer accountant;

    private Integer operation;

    private OrgModel parentPk;

    private DocumentBusiness businessCode;

    private DocumentIdCard legalPersonIdCard;

    private DocumentRoadTransport roadTransport;

    private DocumentDangerTransport dangerTransport;

    private String warrant;

    private Integer auditStatus;

    private List<AuditOrg> audits;

    @Override
    public boolean sameIdentityAs(OrgModel other) {
        return false;
    }
}