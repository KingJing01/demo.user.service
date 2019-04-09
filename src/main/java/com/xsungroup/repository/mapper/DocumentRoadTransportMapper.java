package com.xsungroup.repository.mapper;

import com.xsungroup.domain.model.document.DocumentRoadTransport;

public interface DocumentRoadTransportMapper {
    int deleteByPrimaryKey(String pk);

    int insert(DocumentRoadTransport record);

    int insertSelective(DocumentRoadTransport record);

    DocumentRoadTransport selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(DocumentRoadTransport record);

    int updateByPrimaryKey(DocumentRoadTransport record);
}