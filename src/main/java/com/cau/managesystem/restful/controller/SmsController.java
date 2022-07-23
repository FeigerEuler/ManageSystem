package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.database.service.dto.UserDto;
import com.cau.managesystem.entity.User;
import com.cau.managesystem.responses.LoginResponse;
import com.cau.managesystem.smsService.SmsBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@RestController()
@RequestMapping("/sendSms")
public class SmsController {



    @GetMapping("/send")
    @ResponseBody
    public LoginResponse  helloWeb(@RequestParam("phone") String phoneNum,@RequestParam("content") String content) throws IOException {

        LoginResponse loginResponse = new LoginResponse();
        System.out.println("收到请求——手机号" + phoneNum);
        System.out.println("收到请求——文本：" + content);
        if(phoneNum.length()!=11){
            loginResponse.buildFail("请检查手机号");
            return loginResponse;
        }
       // JSONObject params = JSON.parseObject(body);
       // String phoneNo = params.getString("phoneNo");
      //  String content = params.getString("content");

        SmsBao.sendSms(phoneNum,content);
        System.out.println("已发送！");
        loginResponse.buildSuccess();
        return loginResponse;

    }


}
