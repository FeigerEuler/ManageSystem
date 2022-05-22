package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.database.service.dto.ClueCollectionDto;
import com.cau.managesystem.database.service.dto.ExtenerDto;
import com.cau.managesystem.database.service.dto.ProcessInfoDto;
import com.cau.managesystem.database.service.dto.UserDto;
import com.cau.managesystem.entity.ClueCollection;
import com.cau.managesystem.entity.Extener;
import com.cau.managesystem.entity.ProcessInfo;
import com.cau.managesystem.entity.User;
import com.cau.managesystem.responses.AddProcessInfoResponse;
import com.cau.managesystem.responses.LoginResponse;
import com.cau.managesystem.responses.QueryProcessInfoResponse;
import com.cau.managesystem.responses.TaskAssignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController()
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ExtenerDto extenerDto;
    @Autowired
    private ClueCollectionDto clueCollectionDto;

    @Autowired
    private ProcessInfoDto processInfoDto;


    //时间格式化对象
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PostMapping("/addExtensionInfo")
    @ResponseBody
    public TaskAssignResponse helloWeb(@RequestBody String body) {
        System.out.println("收到外协岗位处理请求:" + body);
        TaskAssignResponse rep = new TaskAssignResponse();
        //JSONObject jsonObject = JSON.parseObject(body);
        Extener extener = JSONObject.parseObject(body, Extener.class);
        extener.setCreateTime(formatter.format(new Date()));
        System.out.println(JSON.toJSONString(extener));
        int insert = extenerDto.insert(extener);
        if (1 == insert) {
            rep.buildSuccess();
        } else {
            rep.buildFail("交办失败");
        }
        return rep;

    }

    @PostMapping("/addClueInfo")
    @ResponseBody
    public TaskAssignResponse helloWeb2(@RequestBody String body) {
        System.out.println("收到外协岗位处理请求:" + body);
        TaskAssignResponse rep = new TaskAssignResponse();
        //JSONObject jsonObject = JSON.parseObject(body);
        ClueCollection clueCollection = JSONObject.parseObject(body, ClueCollection.class);
        clueCollection.setCreateTime(formatter.format(new Date()));
        System.out.println(JSON.toJSONString(clueCollection));
        int insert = clueCollectionDto.insert(clueCollection);
        if (1 == insert) {
            System.out.println("sucess");
            rep.buildSuccess();
        } else {
            rep.buildFail("交办失败");
        }
        return rep;

    }


    @PostMapping("/addProcessInfo")
    @ResponseBody
    public AddProcessInfoResponse addProcessInfo(@RequestBody String body) {
        System.out.println("收到新增处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        ProcessInfo processInfo = JSONObject.parseObject(body, ProcessInfo.class);
        processInfo.setCreateTime(formatter.format(new Date()));
        processInfo.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();
        int insert = processInfoDto.insert(processInfo);
        if (1 == insert) {
            rep.setProcessInfo(processInfo);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }


    @PostMapping("/getToDoList")
    @ResponseBody
    public QueryProcessInfoResponse getToDoList(@RequestBody String body) {
        System.out.println("收到查询待办列表请求:" + body);

        JSONObject jsonObject = JSON.parseObject(body);
        String userid = jsonObject.getString("nowProcessorId");
        List<ProcessInfo> processInfos = processInfoDto.selectProcessInfoByNowProcessorId(userid);

        QueryProcessInfoResponse rep = new QueryProcessInfoResponse();
        if (null != processInfos) {
            rep.setProcessInfos(processInfos);
            rep.buildSuccess();
        } else {
            rep.buildFail("您暂无待办");
        }
        return rep;
    }

    @GetMapping("/test")
    public String helloWeb1() {
        return "helloworld";
    }
}
