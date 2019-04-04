package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : Lilei
 * @Description : 权限值类型
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_base_permission")
public class Permission extends ValueObject {

    @Column(name="permission_name")
    private String permissionName;

    @Column(name="permission_code")
    private String permissionCode;

    @Column(name="permission_url")
    private String permissionUrl;

    @Column(name="permission_parent")
    private Permission parent;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}
