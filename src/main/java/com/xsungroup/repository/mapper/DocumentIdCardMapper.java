package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.document.DocumentIdCard;

public interface DocumentIdCardMapper {
    int deleteByPrimaryKey(String pk);

    int insert(DocumentIdCard record);

    int insertSelective(DocumentIdCard record);

    DocumentIdCard selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(DocumentIdCard record);

    int updateByPrimaryKey(DocumentIdCard record);
}