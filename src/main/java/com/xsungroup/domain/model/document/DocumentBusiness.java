package com.xsungroup.domain.model.document;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class DocumentBusiness extends ValueObject<DocumentBusiness> {

    private String businessCode;

    private String orgName;

    private String registeredCapital;

    private String capitalType;

    private String businessAddress;

    private Date vaildTimeStart;

    private Date validTimeEnd;

    private String licensingOrganiz;

    private String businessUrl;

    @Override
    public boolean sameValueAs(DocumentBusiness other) {
        return false;
    }
}