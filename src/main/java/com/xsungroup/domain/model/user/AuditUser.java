package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class AuditUser extends ValueObject<AuditUser> {
    private String pkUser;

    private Integer status;

    private Integer auditMode;

    private String auditUser;

    private Date auditTime;

    private String auditMemo;

    @Override
    public boolean sameValueAs(AuditUser other) {
        return false;
    }
}