package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.UserModel;

public interface UserModelMapper {
    int deleteByPrimaryKey(String pk);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}