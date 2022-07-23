package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.database.service.dto.UserDto;
import com.cau.managesystem.entity.ProcessInfo;
import com.cau.managesystem.entity.User;
import com.cau.managesystem.responses.CommonResponse;
import com.cau.managesystem.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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

    @PostMapping("/queryBydepartment")
    @ResponseBody
    public List<User> helloWeb2(@RequestBody String body) {
        System.out.println("收到按部门查询请求:" + body);
        JSONObject params = JSON.parseObject(body);
        List<User> users = userDto.selectUserByDepartment(params.getString("department"));
        for (User user:users) {
            user.setPwd("******");
        }
        return users;
    }

    @PostMapping("/queryMemInfoById")
    @ResponseBody
    public User helloWeb3(@RequestBody String body) {
        System.out.println("收到按usrId查询请求:" + body);
        JSONObject params = JSON.parseObject(body);
        User user = userDto.selectUserById(params.getString("userId"));
        user.setPwd("********");
        return user;
    }


    @PostMapping("/queryMemInfoByUserName")
    @ResponseBody
    public User helloWeb4(@RequestBody String body) {
        System.out.println("收到按usrName查询请求:" + body);
        JSONObject params = JSON.parseObject(body);
        User user = userDto.selectUserByUserName(params.getString("userName"));
        if (user==null){
            user = new User();
            user.setUserName("!!!!查无此用户！！！");
        }
        //user.setPwd("********");
        return user;
    }
    @PostMapping("/updateMemInfoById")
    @ResponseBody
    public CommonResponse helloWeb5(@RequestBody String body) {
        System.out.println("收到按usrId更新用户请求:" + body);
        CommonResponse response = new CommonResponse();

        JSONObject params = JSON.parseObject(body);
        User newInfo = JSONObject.parseObject(body, User.class);
        User old = userDto.selectUserById(newInfo.getId());
        if(newInfo.getPwd().equals("********")){
            newInfo.setPwd(old.getPwd());
        }
        int update = userDto.update(newInfo);
        if(update==1){
            response.buildSuccess();
        }else {
            response.buildFail("更新失败，请重新登陆后重试");
        }
        return response;
    }



    @PostMapping("/addMembers")
    @ResponseBody
    public CommonResponse addMembers(@RequestBody String body) {
        System.out.println("收到新增用户:" + body);
        CommonResponse response = new CommonResponse();

        User user = JSONObject.parseObject(body, User.class);
        User unique = userDto.selectUserByUserName(user.getUserName());
        if (null != unique) {
            response.buildFail("该登陆名已存在！！！");
            return response;
        }
        int insert = userDto.insert(user);
        if (1 == insert) {
            response.buildSuccess();
            return response;
        }

        response.buildFail("添加失败");
        return response;
    }
}

