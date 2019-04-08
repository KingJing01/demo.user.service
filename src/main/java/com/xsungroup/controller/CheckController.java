package com.xsungroup.controller;

import com.xinya.tools.rest.dto.ResponseBaseDto;
import com.xinya.tools.utils.StringUtils;
import com.xinya.tools.utils.VerifyUtils;
import com.xsungroup.controller.dto.CheckCodeDto;
import com.xsungroup.domain.model.basis.CheckCodeModel;
import com.xsungroup.service.CheckService;
import com.xsungroup.utils.PropertiesUtils;
import com.xsungroup.utils.RedisUtil;
import com.xsungroup.utils.exception.UserErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author : Lilei
 * @Description : 验证控制器
 * @Date : 2019/4/6
 */
@RestController
public class CheckController {

    private final static String VERIFICATION = "verification";
    @Autowired
    private CheckService checkService;

    /**
     * @Description : 获取验证码
     * @param : [phone, type]
     * @return : com.xinya.tools.rest.dto.ResponseBaseDto
     * @auther : 李雷
     * @date : 2019/4/8 9:22
     */
    @PostMapping(Url.VERIFICATION)
    public ResponseBaseDto getVerification(@PathVariable String phone, @RequestBody CheckCodeDto type){

        Optional optional = Optional.ofNullable(phone).filter(str->VerifyUtils.validateTelFormat(phone));
        if (!optional.isPresent()){
            return ResponseBaseDto.error(UserErrorEnum.PHONE_NUM_ERRORO);
        }
        if(RedisUtil.hasKey(StringUtils.join(new String[]{VERIFICATION,phone,type.getType()},'-'))){
            return ResponseBaseDto.error(UserErrorEnum.CHECK_CODE_ERRORO);
        }
        int time = PropertiesUtils.getIntProperty(PropertiesUtils.CHECKCODE_TIME);
        RedisUtil.set(StringUtils.join(new String[]{VERIFICATION,phone,type.getType()},'-'),time,1);
        //考虑加入防腐层
        CheckCodeModel model = new CheckCodeModel(phone,Integer.parseInt(type.getType()));
        checkService.sendCheck(model);
        return ResponseBaseDto.succeed();
    }




}
