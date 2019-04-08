package com.xsungroup.domain.model.basis;

import com.xsungroup.domain.model.base.Model;
import com.xsungroup.utils.ModelUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Lilei
 * @Description : 短信记录模型
 * @Date : 2019/4/6
 */
@Data
@Entity
@Table(name="t_sms_record")
public class SmsRecordModel extends Model<SmsRecordModel> {

    private String type;
    @Column(name = "phone_num")
    private String phoneNum;
    private String name;
    private String param;
    private String memo;
    @Column(name = "send_flag")
    private String sendFlag;
    @Column(name = "send_time")
    private String sendTime;

    public SmsRecordModel(){

    }

    public SmsRecordModel(String type, String phoneNum, String param) {
        this.type = type;
        this.phoneNum = phoneNum;
        this.param = param;
        ModelUtils.newModel(this,phoneNum,new Date());
    }

    @Override
    public boolean sameIdentityAs(SmsRecordModel other) {
        return false;
    }
}
