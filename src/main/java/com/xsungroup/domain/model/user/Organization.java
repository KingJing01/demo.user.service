package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.SourceEnum;
import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
@Data
public class Organization extends ValueObject {

    private String orgName;
    private String orgCode;

    private String type;

    private SourceEnum source;

    private String legal_person;

    private String accountant;

    private String operation;

    private String parent;

    private String business;

    private String legal_person_id_card;

    private String roadTransport;

    private String dangerTranspost;

    private String warrant;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}
