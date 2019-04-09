package com.xsungroup.domain.model.document;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class DocumentIdCard extends ValueObject<DocumentDangerTransport> {

    private String cardCode;

    private String cardUrl;

    private String licensingOrganiz;

    private Date validTimeStart;

    private Date validTimeEnd;

    @Override
    public boolean sameValueAs(DocumentDangerTransport other) {
        return false;
    }
}