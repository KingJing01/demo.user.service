package com.xsungroup.utils;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.log4j.Log4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lilei
 * @Description : 配置缓存
 * @Date : 2019/3/25
 */
@Log4j
public class PropertiesUtils {

    private static final String CUSTOMER_SERVICE = "xsungroup.user.";
    private static Map<String,String> properties = new ConcurrentHashMap<>();

    public static final String RESOURCE_ADDRESS = "resource.address";

    public static final String CHECKCODE_TIME = "checkcode.time";
    public static final String CHECKCODE_DEADLINE = "checkcode.deadline";

    private static Config config = ConfigService.getAppConfig();

    public static String getProperty(String key){
        return config.getProperty(CUSTOMER_SERVICE+key,"info");
    }

    public static int getIntProperty(String key){
        return config.getIntProperty(CUSTOMER_SERVICE+key,0);
    }

}
