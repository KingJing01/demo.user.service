package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.document.DocumentDangerTransport;

public interface DocumentDangerTransportMapper {
    int deleteByPrimaryKey(String pk);

    int insert(DocumentDangerTransport record);

    int insertSelective(DocumentDangerTransport record);

    DocumentDangerTransport selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(DocumentDangerTransport record);

    int updateByPrimaryKey(DocumentDangerTransport record);
}