package com.xsungroup.utils.exception;


import com.xinya.tools.constant.ErrorEnum;

/**
 * 自定义业务异常
 */
public class BadRequestException extends BaseException {
    public BadRequestException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

    public BadRequestException(ErrorEnum errorEnum, String mes) {
        super(errorEnum, mes);
    }

    public BadRequestException(String errorCode, String message) {
        super(errorCode, message);
    }
}
