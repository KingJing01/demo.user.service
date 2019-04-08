package com.xsungroup.repository.handler;

import com.xinya.tools.mybatis.handler.AutoEnumTypeHandler;
import com.xsungroup.domain.enums.DriverStatusEnum;
import com.xsungroup.domain.enums.TransTypeEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/3/22
 */
@MappedTypes(value = {DriverStatusEnum.class,TransTypeEnum.class})
public class EnumTypeHandler<E extends Enum<E>> extends AutoEnumTypeHandler<E> {

    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
