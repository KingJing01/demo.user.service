package com.xsungroup.domain.model.document;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class AuditDriver extends ValueObject<AuditDriver> {

    private String pkDriver;

    private Integer status;

    private Integer auditMode;

    private String auditUser;

    private Date auditTime;

    private String auditMemo;

    @Override
    public boolean sameValueAs(AuditDriver other) {
        return false;
    }
}