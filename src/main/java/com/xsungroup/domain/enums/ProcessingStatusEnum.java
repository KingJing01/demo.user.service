package com.xsungroup.domain.enums;

import com.xinya.tools.mybatis.handler.BaseEnum;

/**
 * @author : Lilei
 * @Description : 订单处理状态 baseEnum mybatis
 * @Date : 2019/3/21
 */
public enum ProcessingStatusEnum implements BaseEnum {
    WAIT(0,"待处理"),DURING(1,"处理中"),CONNECT(2,"待交接"),ALREADY(3,"已处理") ;

    private int status;

    private String name;

    ProcessingStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getCode() {
        return status;
    }

    @Override
    public String toString() {
        return name;
    }
}
