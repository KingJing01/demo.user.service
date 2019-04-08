package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
@Data
public class Role extends ValueObject {

    private String roleCode;

    private String roleName;

    private Organization org;

    private Organization createOrg;

    private List<Permission> permissions;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}
