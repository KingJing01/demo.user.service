package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.TransTypeEnum;
import com.xsungroup.domain.model.base.Model;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

/**
 * @author : Lilei
 * @Description : 用户模型
 * @Date : 2019/4/4
 */
@Data
public class UserModel extends Model<UserModel> {

    private String userName;

    private String displayName;

    private Role role;

    private Organization org;

    private Organization topOrg;

    private Organization createOrg;

    private Date lastLoginTime;

    private String isValid;

    private String password;

    private TransTypeEnum transportType;


    @Override
    public boolean sameIdentityAs(UserModel other) {
        return Optional.ofNullable(other).isPresent();
    }
}
