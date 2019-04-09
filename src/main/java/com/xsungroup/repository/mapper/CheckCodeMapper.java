package com.xsungroup.repository.mapper;


import com.xsungroup.domain.model.basis.CheckCodeModel;

public interface CheckCodeMapper {
    int deleteByPrimaryKey(String pk);

    int insert(CheckCodeModel record);

    int insertSelective(CheckCodeModel record);

    CheckCodeModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(CheckCodeModel record);

    int updateByPrimaryKey(CheckCodeModel record);
}