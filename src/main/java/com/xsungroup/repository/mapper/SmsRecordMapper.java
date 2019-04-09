package com.xsungroup.repository.mapper;


import com.xsungroup.domain.model.basis.SmsRecordModel;

public interface SmsRecordMapper {
    int deleteByPrimaryKey(String pk);

    int insert(SmsRecordModel record);

    int insertSelective(SmsRecordModel record);

    SmsRecordModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(SmsRecordModel record);

    int updateByPrimaryKey(SmsRecordModel record);
}