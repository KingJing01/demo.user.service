package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_base_role")
public class Role extends ValueObject {

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "pk_org")
    private Organization org;

    @Column(name = "pk_create_org")
    private Organization createOrg;

//    private List<Permission> permissions;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}