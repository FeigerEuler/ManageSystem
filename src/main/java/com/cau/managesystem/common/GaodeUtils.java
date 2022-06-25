package com.cau.managesystem.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.entity.District;
import com.cau.managesystem.entity.GaodeRes;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GaodeUtils {
    private static String host = "https://restapi.amap.com";
    private static String path = "/v3/config/district";
    private static String method = "GET";


    public static List<District>  queryDistricts(String keyWord) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE ");
        Map<String, String> querys = new HashMap<>();
        querys.put("keywords",keyWord);
        querys.put("subdistrict","2");
        querys.put("key","78cc8b39557cb35653932242c44ee7ba");
        HttpResponse httpResponse = null;
        try{
            httpResponse = HttpUtils.doGet(host, path, method, headers, querys);
        }catch (Exception r){
            System.out.println("http request error!!!!!!!");
            System.out.println(r);
        }
        String res = null;
        try {
            res = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            System.out.println("convert Gaode response Exception!!!!!");
        }

        JSONObject jsonObject = JSON.parseObject(res);
        GaodeRes gaodeRes = JSONObject.parseObject(res, GaodeRes.class);

        List<District> districts = gaodeRes.getDistricts().get(0).getDistricts();

        List<String> districtNames = new ArrayList<>();
        for(District district:districts){
            districtNames.add(district.getName());
        }

        return districts;
    }

}
