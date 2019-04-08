package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.TransModeEnum;
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
public class UserModel extends Model<UserModel> {

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

    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name ="pk_create_org")
    private Organization createOrg;

    @Column(name="last_login_time")
    private Date lastLoginTime;

    @Column(name="is_valid")
    private String isValid;

    private String password;

    @Column(name="phone_num")
    private String phoneNum;

    @Column(name="transport_type")
    @Enumerated
    private TransModeEnum transModeEnum;


    @Override
    public boolean sameIdentityAs(UserModel other) {
        return Optional.ofNullable(other).isPresent();
    }
}