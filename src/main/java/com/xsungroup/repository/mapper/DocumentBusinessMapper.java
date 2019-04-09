package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.document.DocumentBusiness;

public interface DocumentBusinessMapper {
    int deleteByPrimaryKey(String pk);

    int insert(DocumentBusiness record);

    int insertSelective(DocumentBusiness record);

    DocumentBusiness selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(DocumentBusiness record);

    int updateByPrimaryKey(DocumentBusiness record);
}