package com.xsungroup.domain.enums;

import com.xinya.tools.mybatis.handler.BaseEnum;
import com.xinya.tools.utils.CodeEnumUtils;
import com.xinya.tools.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/3/22
 */
public enum TransTypeEnum implements BaseEnum {
       ZORE(0,""),COLDCHAIN(1,"冷链运输"),GENERAL(2,"普货运输"),
    DANGEROUS(3,"危险品运输"),CONTAINER(4,"集装箱运输");

    private int code;
    private String name;

    TransTypeEnum(int code, String name) {
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


    /**
     * @Description : code转换成name
     * @param : [str]1,2,3
     * @return : java.lang.String
     * @auther : 李雷
     * @date : 2019/3/27 18:13
     */
    public static String getNames(String str){
        StringBuffer sb= new StringBuffer();
        if (StringUtils.isEmpty(str))
            return StringUtils.EMPTY;
       Stream.of(str.split(","))
               .mapToInt(item->Integer.parseInt(item))
               .forEach(item->sb.append(CodeEnumUtils.codeOf(TransTypeEnum.class,item)).append(','));
        return sb.toString().substring(0,sb.length()-1);
    }
}
