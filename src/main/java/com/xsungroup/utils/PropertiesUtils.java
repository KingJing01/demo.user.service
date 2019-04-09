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
    public static final String CHECKCODE_DIGITS = "checkcode.digits";
    private static Config config = ConfigService.getAppConfig();

    @Value("xsungroup.user.checkcode.digits:4")
    private int digits;
    @Value("xsungroup.user.checkcode.deadline:3")
    private int deadlineNum;

    public static String getProperty(String key){
        return config.getProperty(CUSTOMER_SERVICE+key,"info");
    }

    public static int getIntProperty(String key,int defaul){
        return config.getIntProperty(CUSTOMER_SERVICE+key,defaul);
    }

    public int getDigits() {
        return digits;
    }

    public int getDeadlineNum() {
        return deadlineNum;
    }
}
