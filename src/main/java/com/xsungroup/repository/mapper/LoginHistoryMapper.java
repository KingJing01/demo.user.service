package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.LoginHistory;

public interface LoginHistoryMapper {
    int deleteByPrimaryKey(String pk);

    int insert(LoginHistory record);

    int insertSelective(LoginHistory record);

    LoginHistory selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(LoginHistory record);

    int updateByPrimaryKey(LoginHistory record);
}