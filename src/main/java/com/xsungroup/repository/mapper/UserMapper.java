package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.user.UserModel;

public interface UserMapper {
    int deleteByPrimaryKey(String pk);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}