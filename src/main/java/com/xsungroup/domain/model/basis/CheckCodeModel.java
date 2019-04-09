package com.xsungroup.domain.model.basis;

import com.xinya.tools.utils.DateUtils;
import com.xinya.tools.utils.RandomUtils;
import com.xsungroup.domain.model.base.Model;
import com.xsungroup.utils.ModelUtils;
import com.xsungroup.utils.PropertiesUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/6
 */
@Data
public class CheckCodeModel extends Model<CheckCodeModel> {

    private String phoneNum;

    private String code;

    private int type;

    private Date deadline;

    public CheckCodeModel() {
    }

    public CheckCodeModel(String phoneNum, int type) {
        Date date = new Date();
        this.phoneNum = phoneNum;
        this.type = type;
        this.code = getCode(PropertiesUtils.getIntProperty(PropertiesUtils.CHECKCODE_DIGITS,4));
        this.deadline = DateUtils.addMinute(date, PropertiesUtils.getIntProperty(
                PropertiesUtils.CHECKCODE_DEADLINE,3));
        ModelUtils.newModel(this,"",date);
    }

    public String getCode(int digits){
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < digits; i++) {
            code.append(RandomUtils.getRandom(1,9));
        }
        return code.toString();
    }

    @Override
    public boolean sameIdentityAs(CheckCodeModel other) {
        return false;
    }
}
