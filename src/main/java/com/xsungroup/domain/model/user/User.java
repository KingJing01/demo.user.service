package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.TransTypeEnum;
import com.xsungroup.domain.model.base.Model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

/**
 * @author : Lilei
 * @Description : 用户模型
 * @Date : 2019/4/4
 */
@Data
@Entity
@Table(name="t_base_user")
public class User extends Model<User> {

    @Column(name="user_name")
    private String userName;

    @Column(name="display_name")
    private String displayName;

    @Column(name="pk_role")
    private Role role;

    @Column(name="pk_org")
    private Organization org;

    @Column(name="pk_top_org")
    private Organization topOrg;

    @Column(name="pk_create_org")
    private Organization createOrg;

    @Column(name="last_login_time")
    private Date lastLoginTime;

    @Column(name="is_valid")
    private String isValid;

    private String password;

    @Column(name="transport_type")
    private TransTypeEnum transportType;


    @Override
    public boolean sameIdentityAs(User other) {
        return Optional.ofNullable(other).isPresent();
    }
}
