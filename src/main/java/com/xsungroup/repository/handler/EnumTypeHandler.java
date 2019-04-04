package com.xsungroup.repository.handler;

import com.xinya.tools.mybatis.handler.AutoEnumTypeHandler;
import com.xsungroup.domain.enums.DriverStatusEnum;
import com.xsungroup.domain.enums.ProcessingStatusEnum;
import com.xsungroup.domain.enums.TransTypeEnum;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/3/22
 */
@MappedTypes(value = {ProcessingStatusEnum.class,DriverStatusEnum.class,TransTypeEnum.class})
public class EnumTypeHandler<E extends Enum<E>> extends AutoEnumTypeHandler<E> {

    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
