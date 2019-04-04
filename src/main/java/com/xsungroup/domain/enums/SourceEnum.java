package com.xsungroup.domain.enums;

import com.xinya.tools.mybatis.handler.BaseEnum;

/**
 * @author : Lilei
 * @Description : 司机状态
 * @Date : 2019/3/27
 */
public enum SourceEnum implements BaseEnum {

    IDLE(0,"注册"), BUSY(1,"创建");

    private int code;
    private String name;

    SourceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }
}
