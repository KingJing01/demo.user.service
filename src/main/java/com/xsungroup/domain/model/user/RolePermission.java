package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.Model;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author : Chenman
 * @Description : 角色权限模型
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_role_permission")
public class RolePermission extends Model<RolePermission> {

    @Column(name="pk_permission")
    private Permission permission;

    @Column(name="pk_role")
    private Role role;

    @Override
    public boolean sameIdentityAs(RolePermission other) {
        return Optional.ofNullable(other).isPresent();
    }
}
