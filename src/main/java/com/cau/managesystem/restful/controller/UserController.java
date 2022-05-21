package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.database.service.dto.UserDto;
import com.cau.managesystem.entity.User;
import com.cau.managesystem.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@RestController()
@RequestMapping("mhh")
public class UserController {

    @Autowired
    private UserDto userDto;

    @PostMapping("/login")
    @ResponseBody
    public LoginResponse helloWeb(@RequestBody String body) throws IOException {

        LoginResponse loginResponse = new LoginResponse();
        System.out.println("收到请求：" + body);
        JSONObject params = JSON.parseObject(body);
        String userName = params.getString("user_name");
        String pwd = params.getString("password");
        User user = userDto.selectUserByUserName(userName);
        System.out.println(JSON.toJSONString(user));
        if (null == user) {
            System.out.println("用户不存在");
            loginResponse.buildFail("用户不存在！");
        } else if (!Objects.equals(pwd, user.getPwd())) {
            System.out.println("密码错误");
            loginResponse.buildFail("密码错误！");
        } else {
            System.out.println("当前用户信息：" + user.toString());
            System.out.println("登录成功");
            loginResponse.buildSuccess();
            loginResponse.setUser(user);
            return loginResponse;
        }

        return loginResponse;


    }

    @GetMapping("/test")
    public String helloWeb1() {
        return "helloworld";
    }
}
