package com.xsungroup.domain.model.org;

import com.xsungroup.domain.model.base.ValueObject;
import com.xsungroup.domain.model.user.Permission;
import lombok.Data;

import java.util.Date;

@Data
public class AuditOrg extends ValueObject<AuditOrg> {
    private String pkOrg;

    private Integer status;

    private Integer auditMode;

    private String auditUser;

    private Date auditTime;

    private String auditMemo;


    @Override
    public boolean sameValueAs(AuditOrg other) {
        return false;
    }
}