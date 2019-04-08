package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.SourceEnum;
import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_base_org")
public class Organization extends ValueObject {

    @Column(name = "org_name")
    private String orgName;
    @Column(name = "org_code")
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

    @Column(name = "danger_transport")
    private String dangerTranspost;

    private String warrant;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}
