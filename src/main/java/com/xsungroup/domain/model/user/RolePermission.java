package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;


@Data
public class RolePermission extends ValueObject<Permission> {

    private String pkRole;

    private String pkPermission;

    @Override
    public boolean sameValueAs(Permission other) {
        return false;
    }
}