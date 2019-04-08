package com.xsungroup.utils.exception;

import com.xinya.tools.constant.ErrorBaseEnum;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/6
 */
public enum UserErrorEnum implements ErrorBaseEnum {
    OPERATION_ERRORO("OPE_1001","操作失败"),
    PHONE_NUM_ERRORO("ONE_1001","手机号码格式不正确！"),
    CHECK_CODE_ERRORO("CCE_1001","请勿重复获取！"),
    CHECK_NEWPWD_ERRORO("CNE_1001","密码不能为空！"),

    ;


    private String errorCode;

    private String message;

    UserErrorEnum(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
