package com.cau.managesystem;


import com.cau.managesystem.common.HttpUtils;
import com.cau.managesystem.smsService.AliyunSmsService;
import com.cau.managesystem.smsService.BaiduSmsService;
import com.cau.managesystem.smsService.SmsBao;
import com.cau.managesystem.smsService.SmsNotify;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MhfTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    @Test
    void MhfTest() {
        int random= (int) (Math.random()*1000);
        String num = formatter.format(new Date());
        System.out.println(num);
        System.out.println(num+random);

    }

    @Test
    void MhfTest2() {

//        String content = "【马哈哈工作室】 通知短信测试";
//        BaiduSmsService.sendSmsNotify("18811211838",content);
      //  AliyunSmsService.addSignature("尊敬的#username#您好！#name#已将流程单号#id#指派给您，请及时处理。","马哈哈Studio");
     //   AliyunSmsService.queryStatus("3889");

       // AliyunSmsService.addSignature("尊敬的#username#您好！您的马哈哈代理服务将由#oldService#在#time#后调整为#newService#,请您及时调整配置文件#config#。详情请咨询马哈哈工作室内",
             //   "马哈哈工作室");

        //AliyunSmsService.query();


    }
}
