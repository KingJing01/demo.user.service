package com.xsungroup.domain.enums;

import com.xinya.tools.mybatis.handler.BaseEnum;

/**
 * @author : Lilei
 * @Description : 司机状态
 * @Date : 2019/3/27
 */
public enum DriverStatusEnum implements BaseEnum {

    IDLE(0,"空车"), BUSY(1,"出车中"), LEAVE(2,"请假中");

    private int code;
    private String name;

    DriverStatusEnum(int code, String name) {
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
