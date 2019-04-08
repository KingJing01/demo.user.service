package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

/**
 * @author : Lilei
 * @Description : 权限值类型
 * @Date : 2019/4/4
 */
@Data
public class Permission extends ValueObject {

    private String permissionName;

    private String permissionCode;

    private String permissionUrl;

    private Permission parent;

    @Override
    public boolean sameValueAs(Object other) {
        return false;
    }
}
