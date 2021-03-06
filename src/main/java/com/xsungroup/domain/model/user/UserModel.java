package com.xsungroup.domain.model.user;

import com.xsungroup.domain.enums.TransModeEnum;
import com.xsungroup.domain.model.base.Model;
import com.xsungroup.domain.model.org.OrgModel;
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

    private OrgModel org;

    private OrgModel topOrg;

    private OrgModel createOrg;

    private Date lastLoginTime;

    private String isValid;

    private String password;

    private String phoneNum;

    private TransModeEnum transportMode;

    private String topOrgRange;

    private String createOrgRange;

    private String orgRange;

    @Override
    public boolean sameIdentityAs(UserModel other) {
        return Optional.ofNullable(other).isPresent();
    }
}
