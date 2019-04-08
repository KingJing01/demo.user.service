package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.Model;
import java.util.Optional;

import lombok.Data;

/**
 * @author : Chenman
 * @Description : 角色权限模型
 * @Date : 2019/4/4
 */
@Data

public class RolePermission extends Model<RolePermission> {

    private Permission permission;

    private Role role;

    @Override
    public boolean sameIdentityAs(RolePermission other) {
        return Optional.ofNullable(other).isPresent();
    }
}
