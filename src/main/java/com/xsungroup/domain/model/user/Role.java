package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;


@Data
public class Role extends ValueObject<Role> {
    private String roleCode;

    private String roleName;

    private String pkOrg;

    private String pkCreateOrg;

    @Override
    public boolean sameValueAs(Role other) {
        return false;
    }
}