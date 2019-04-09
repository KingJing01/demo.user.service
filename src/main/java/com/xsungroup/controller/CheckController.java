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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Lilei
 * @Description : 验证和登陆控制
 * @Date : 2019/4/6
 */
@RestController
public class CheckController {

    private final static String VERIFICATION = "verification";
    @Autowired
    private CheckService checkService;

    /**
     * @Description : 生成及发送验证码
     * @param : [phone, type]
     * @return :
     * @auther : 李雷
     * @date : 2019/4/8 9:22
     */
    @PostMapping(Url.VERIFICATION)
    public ResponseBaseDto getVerification(@PathVariable String phone, @RequestBody CheckCodeDto type){
        // 验证手机号码
        Optional optional = Optional.ofNullable(phone).filter(str->VerifyUtils.validateTelFormat(phone));
        if (!optional.isPresent()) {
            return ResponseBaseDto.error(UserErrorEnum.PHONE_NUM_ERRORO);
        }
        //是否重复
        if (redisRepeat(VERIFICATION,phone,type.getType())) {
            return ResponseBaseDto.error(UserErrorEnum.CHECK_CODE_ERRORO);
        }
        //考虑加入防腐层
        CheckCodeModel model = new CheckCodeModel(phone,Integer.parseInt(type.getType()));
        checkService.sendCheck(model);
        return ResponseBaseDto.succeed();
    }

    /**
     * @Description : 是否重复,控制请求间隔时间
     * @param : [keys]
     * @return : boolean
     * @auther : 李雷
     * @date : 2019/4/8 19:05
     */
    private boolean redisRepeat(String ... keys) {
        String key = StringUtils.join(keys);
        if(RedisUtil.hasKey(key)){
            return true;
        }
        int time = PropertiesUtils.getIntProperty(PropertiesUtils.CHECKCODE_TIME,60);
        RedisUtil.set(key,1,time);
        return false;
    }

    /**
     * @Description : 验证验证码
     * @param : [phone, type]
     * @return : message,success
     * @auther : 李雷
     * @date : 2019/4/8 9:22
     */
    @PutMapping(Url.VERIFICATION)
    public ResponseBaseDto verificationCode(@PathVariable String phone,@RequestBody CheckCodeDto dto){
        return ResponseBaseDto.succeed();
    }


}
