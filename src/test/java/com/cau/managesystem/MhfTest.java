package com.cau.managesystem;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.common.GaodeUtils;
import com.cau.managesystem.entity.District;
import com.cau.managesystem.entity.GaodeRes;
import com.cau.managesystem.restful.controller.FileController;
import com.google.gson.JsonObject;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.*;

public class MhfTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    @Test
    void MhfTest() throws DateParseException {

        String num = formatter.format(1655630124048L);
        System.out.println(num);
        Date date = DateUtils.parseDate(num);
        System.out.println(date);



    }

    @Test
    void MhfTest2() throws IOException {

        List<District> strings = GaodeUtils.queryDistricts("海淀区");
        System.out.println(strings);

    }

}
