package com.xsungroup.utils;

import com.xinya.tools.utils.DateUtils;
import com.xsungroup.domain.model.base.Model;
import com.xsungroup.repository.entity.BaseEntity;

import java.util.Date;
import java.util.UUID;

public class ModelUtils {

    public static String getPk() {
       return UUID.randomUUID().toString().replace("-","");
    }

    public static void newEntity(BaseEntity baseEntity, String userId, Date date){
        baseEntity.setModifyUser(userId);
        baseEntity.setModifyTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseEntity.setCreateUser(userId);
        baseEntity.setCreateTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseEntity.setDr(0);
        baseEntity.setTs(DateUtils.get4yMdHmsS(date));
    }

    public static void newEntity(Iterable<? extends BaseEntity> baseModel, String userId, Date date){
        baseModel.forEach(item->
                newEntity(item,userId,date)
        );
    }

    public static void modifyEntity(BaseEntity baseModel, String userId, Date date){
        baseModel.setModifyUser(userId);
        baseModel.setModifyTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseModel.setTs(DateUtils.get4yMdHmsS(date));
    }
    public static void modifyEntity(Iterable<? extends BaseEntity> baseModel,final String userId,final Date date){
        baseModel.forEach(item->
            modifyEntity(item,userId,date)
        );
    }
    public static void newModel(Model baseModel, String userId, Date date){
        baseModel.setModifyUser(userId);
        baseModel.setModifyTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseModel.setCreateUser(userId);
        baseModel.setCreateTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseModel.setDr(0);
        baseModel.setTs(DateUtils.get4yMdHmsS(date));
    }

    public static void newModel(Iterable<? extends Model> baseModel, String userId, Date date){
        baseModel.forEach(item->
                newModel(item,userId,date)
        );
    }

    public static void modifyModel(Model baseModel, String userId, Date date){
        baseModel.setModifyUser(userId);
        baseModel.setModifyTime(DateUtils.getDateFormate(date,DateUtils.DEFAULT_DATE_FORMAT));
        baseModel.setTs(DateUtils.get4yMdHmsS(date));
    }
    public static void modifyModel(Iterable<? extends Model> baseModel,final String userId,final Date date){
        baseModel.forEach(item->
                modifyModel(item,userId,date)
        );
    }

}
