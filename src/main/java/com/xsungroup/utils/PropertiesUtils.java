package com.xsungroup.utils;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;

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

    @Value("xsungroup.user.checkcode.digits:4")
    private static int digits;
    @Value("xsungroup.user.checkcode.deadline:3")
    private static int deadlineNum;

    public static String getProperty(String key){
        return config.getProperty(CUSTOMER_SERVICE+key,"info");
    }

    public static int getIntProperty(String key){
        return config.getIntProperty(CUSTOMER_SERVICE+key,0);
    }

    public static int getDigits() {
        return digits;
    }

    public static int getDeadlineNum() {
        return deadlineNum;
    }
}
