package com.xsungroup.domain.model.basis;

import com.xsungroup.domain.model.base.Model;
import com.xsungroup.utils.ModelUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author : Lilei
 * @Description : 短信记录模型
 * @Date : 2019/4/6
 */
@Data
public class SmsRecordModel extends Model<SmsRecordModel> {

    private String type;
    private String phoneNum;
    private String name;
    private String param;
    private String memo;
    private int sendFlag;
    private Date sendTime;
    private String sendResult;

    public SmsRecordModel(){

    }

    public SmsRecordModel(String type, String phoneNum, String param) {
        this.type = type;
        this.phoneNum = phoneNum;
        this.param = param;
        this.sendFlag = 0;
        ModelUtils.newModel(this,phoneNum,new Date());
    }

    @Override
    public boolean sameIdentityAs(SmsRecordModel other) {
        return false;
    }
}
