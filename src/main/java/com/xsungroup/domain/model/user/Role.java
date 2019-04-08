package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.Model;
import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_base_role")
public class Role extends Model<Role> {

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "pk_org")
    private Organization org;

    @Column(name = "pk_create_org")
    private Organization createOrg;

    @Transient
    private List<Permission> permissions;

    @Override
    public boolean sameIdentityAs(Role other) {
        return false;
    }
}
