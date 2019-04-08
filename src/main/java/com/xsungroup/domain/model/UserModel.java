package com.xsungroup.domain.model;

import com.xsungroup.domain.model.base.Model;
import java.util.Date;
import lombok.Data;

@Data
public class UserModel extends Model<UserModel> {

    private String userName;

    private String displayName;

    private String pkRole;

    private String pkOrg;

    private String pkTopOrg;

    private String pkCreateOrg;

    private Date lastLoginTime;

    private Integer isValid;

    private String password;

    private String phoneNum;

    private String topOrgRange;

    private String createOrgRange;

    private String orgRange;

    private Integer transportModel;


    @Override
    public boolean sameIdentityAs(UserModel other) {
        return false;
    }
}