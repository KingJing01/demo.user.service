package com.xsungroup.utils.exception;


import com.xinya.tools.constant.ErrorEnum;

/**
 * 自定义异常基类
 */
public abstract class BaseException extends RuntimeException {
    private String errorCode;
    private String message;
    private String mesConent;

    public BaseException(ErrorEnum errorEnum, String mesConent) {
        this.errorCode = errorEnum.getErrorCode();
        this.message = String.format(errorEnum.getMessage(), mesConent);

    }

    public BaseException(ErrorEnum errorEnum) {
        this.errorCode = errorEnum.getErrorCode();
        this.message = errorEnum.getMessage();
    }

    public BaseException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getMesConent() {
        return mesConent;
    }
}