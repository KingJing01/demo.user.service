package com.xsungroup.utils;

import com.xinya.tools.utils.HttpUtils;
import com.xinya.tools.utils.JacksonUtils;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Lilei
 * @Description : 地址工具类
 * @Date : 2018/9/29
 */
@Log4j
public class AddressUtils {

    private final static String KEY = "21bd2dd844f9edb48c21f449434d6f77";

    public static String getLonLat(String address) throws Exception {
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo";
        Map<String,String> map = new HashMap<>();
        map.put("key",KEY);
        map.put("address",address);
        String result = HttpUtils.doPost(queryUrl, map);
        Map<String,Object> mapAddres = JacksonUtils.getInstance().readValue(result,Map.class);
        return (String) ((Map)((List)mapAddres.get("geocodes")).get(0)).get("location");
    }

    public static String getDistance(String startPoint, String endPoint) throws Exception {
        String queryUrl = "http://restapi.amap.com/v3/distance";
        Map<String,String> map = new HashMap<>();
        map.put("key",KEY);
        map.put("origins",startPoint);
        map.put("destination",endPoint);
        String results = HttpUtils.doPost(queryUrl, map);
        Map<String,Object> mapAddres = JacksonUtils.getInstance().readValue(results,Map.class);
        String result =(String) ((Map)((List)mapAddres.get("results")).get(0)).get("distance");
        return result;

    }
}
