package com.xsungroup.domain.enums;

import com.xinya.tools.mybatis.handler.BaseEnum;
import com.xinya.tools.utils.CodeEnumUtils;
import com.xinya.tools.utils.StringUtils;
import java.util.stream.Stream;

/**
 * @program: xsungroup.user.interface
 * @description: 运输模式枚举
 * @author: ChenMan
 * @create: 2019-04-08 13:36
 */
public enum TransModeEnum implements BaseEnum {
  ZORE(0,""),COLDCHAIN(1,"整车"),GENERAL(2,"零担"),
  ;

  private int code;
  private String name;

  TransModeEnum(int code, String name) {
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
        .forEach(item->sb.append(CodeEnumUtils.codeOf(TransModeEnum.class,item)).append(','));
    return sb.toString().substring(0,sb.length()-1);
  }


}
