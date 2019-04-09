package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;


/**
 * @author thinkpad
 */
@Data
public class Permission extends ValueObject<Permission> {

    private String permissionName;

    private String permissionCode;

    private String permissionUrl;

    private String permissionParent;

    @Override
    public boolean sameValueAs(Permission other) {
        return false;
    }
}