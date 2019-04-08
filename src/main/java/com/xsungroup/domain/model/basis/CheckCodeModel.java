package com.xsungroup.domain.model.basis;

import com.xinya.tools.utils.DateUtils;
import com.xinya.tools.utils.RandomUtils;
import com.xsungroup.domain.model.base.Model;
import com.xsungroup.utils.ModelUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Optional;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/6
 */
@Data
@Entity
@Table(name="t_check_code")
public class CheckCodeModel extends Model<CheckCodeModel> {

    @Column(name = "phone_num")
    private String phoneNum;

    private String code;

    private int type;

    private Date deadline;

    @Value("xsungroup.user.checkcode.digits:4")
    @Transient
    private int digits;
    @Value("xsungroup.user.checkcode.deadline:3")
    @Transient
    private int deadlineNum;


    public CheckCodeModel() {
    }

    public CheckCodeModel(String phoneNum, int type) {
        Date date = new Date();
        this.phoneNum = phoneNum;
        this.type = type;
        this.code = getCode();
        this.deadline = DateUtils.addMinute(date,deadlineNum);
        ModelUtils.newModel(this,"",date);
    }

    public String getCode(){
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
