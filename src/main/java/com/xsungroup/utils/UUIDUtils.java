package com.xsungroup.utils;

import com.xinya.tools.utils.StringUtils;
import java.util.UUID;

/**
 * @program: xsungroup.user.interface
 * @description: UUID 生成器
 * @author: ChenMan
 * @create: 2019-04-06 11:57
 */
public class UUIDUtils {

  public static String getPk() {
    String pk = UUID.randomUUID().toString();
    return StringUtils.replace(pk,"-","");
  }
}
