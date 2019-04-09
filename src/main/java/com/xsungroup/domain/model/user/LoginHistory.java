package com.xsungroup.domain.model.user;

import com.xsungroup.domain.model.base.ValueObject;
import lombok.Data;

import java.util.Date;

@Data
public class LoginHistory extends ValueObject<LoginHistory> {

    private String userName;

    private String loginIp;

    private Date loginTime;

    @Override
    public boolean sameValueAs(LoginHistory other) {
        return false;
    }
}