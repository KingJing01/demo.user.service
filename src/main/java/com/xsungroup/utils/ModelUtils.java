package com.xsungroup.utils;

import com.xinya.tools.utils.DateUtils;
import com.xsungroup.domain.model.base.Model;

import java.util.Date;
import java.util.UUID;

public class ModelUtils {

    public static String getPk() {
       return UUID.randomUUID().toString().replace("-","");
    }


    public static void newModel(Model baseModel, String userId, Date date){
        baseModel.setPk(UUID.randomUUID().toString());
        baseModel.setModifyUser(userId);
        baseModel.setModifyTime(date);
        baseModel.setCreateUser(userId);
        baseModel.setCreateTime(date);
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
        baseModel.setModifyTime(date);
        baseModel.setTs(DateUtils.get4yMdHmsS(date));
    }
    public static void modifyModel(Iterable<? extends Model> baseModel,final String userId,final Date date){
        baseModel.forEach(item->
                modifyModel(item,userId,date)
        );
    }

}
