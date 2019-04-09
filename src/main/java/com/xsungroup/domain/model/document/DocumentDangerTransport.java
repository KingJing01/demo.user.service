package com.xsungroup.domain.model.document;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class DocumentDangerTransport extends ValueObject<DocumentDangerTransport> {

    private String certificateCode;

    private String businessName;

    private String chargePerson;

    private String businessScope;

    private String businessAddress;

    private Date vaildTimeStart;

    private Date validTimeEnd;

    private String licensingOrganiz;

    private String certificateUrl;

    @Override
    public boolean sameValueAs(DocumentDangerTransport other) {
        return false;
    }
}