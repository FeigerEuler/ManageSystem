package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.database.service.dto.*;
import com.cau.managesystem.entity.*;
import com.cau.managesystem.responses.AddProcessInfoResponse;
import com.cau.managesystem.responses.QueryProcessInfoResponse;
import com.cau.managesystem.responses.TaskAssignResponse;
import com.cau.managesystem.smsService.SmsNotify;
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
    @Autowired
    private ConsultantDto consultantDto;

    @Autowired
    private TechnicianDto technicianDto;
    @Autowired
    private ComponentDto componentDto;
    @Autowired
    private TreasurerDto treasurerDto;
    @Autowired
    private ManagerDto managerDto;



    @Autowired
    private UserDto userDto;

    @Autowired
    private SmsNotify smsNotify;

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
        User user = userDto.selectUserById(processInfo.getNowProcessorId());

        try {
            smsNotify.sendNotifySms(user.getPhoneNo());
        } catch (Exception e) {
            System.out.println("短信发送失败");
        }

        int insert = processInfoDto.insert(processInfo);
        if (1 == insert) {
            rep.setProcessInfo(processInfo);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }


    @PostMapping("/addConsultantInfo")
    @ResponseBody
    public AddProcessInfoResponse addConsultantInfo(@RequestBody String body) {
        System.out.println("收到顾问岗处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        Consultant consultant = JSONObject.parseObject(body, Consultant.class);
        consultant.setCreateTime(formatter.format(new Date()));
        consultant.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();


        int insert = consultantDto.insert(consultant);
        if (1 == insert) {
           // rep.setProcessInfo(consultant);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }


    @PostMapping("/addTechnicianInfo")
    @ResponseBody
    public AddProcessInfoResponse addTechnicianInfo(@RequestBody String body) {
        System.out.println("收到车间技师岗处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        Technician technician = JSONObject.parseObject(body, Technician.class);
        technician.setCreateTime(formatter.format(new Date()));
       technician.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();

        int insert = technicianDto.insert(technician);
        if (1 == insert) {
            // rep.setProcessInfo(consultant);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }

    @PostMapping("/addComponentInfo")
    @ResponseBody
    public AddProcessInfoResponse addComponentInfo(@RequestBody String body) {
        System.out.println("收到车间技师岗处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        Componenter component = JSONObject.parseObject(body, Componenter.class);
        component.setCreateTime(formatter.format(new Date()));
        component.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();

        int insert = componentDto.insert(component);
        if (1 == insert) {
            // rep.setProcessInfo(consultant);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }
    @PostMapping("/addTreasurerInfo")
    @ResponseBody
    public AddProcessInfoResponse addTreasurerInfo(@RequestBody String body) {
        System.out.println("收到配件岗处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        Treasurer treasurer = JSONObject.parseObject(body, Treasurer.class);
        treasurer.setCreateTime(formatter.format(new Date()));
        treasurer.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();

        int insert = treasurerDto.insert(treasurer);
        if (1 == insert) {
            // rep.setProcessInfo(consultant);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }
    @PostMapping("/addManagerInfo")
    @ResponseBody
    public AddProcessInfoResponse addManagerInfo(@RequestBody String body) {
        System.out.println("收到车间技师岗处理流程请求:" + body);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        Manager manager = JSONObject.parseObject(body, Manager.class);
        manager.setCreateTime(formatter.format(new Date()));
        manager.setId(id);
        AddProcessInfoResponse rep = new AddProcessInfoResponse();

        int insert = managerDto.insert(manager);
        if (1 == insert) {
            // rep.setProcessInfo(consultant);
            rep.buildSuccess();
        } else {
            rep.buildFail("数据插入失败");
        }
        return rep;
    }

    @PostMapping("/updateProcessInfo")
    @ResponseBody
    public AddProcessInfoResponse updateProcessInfo(@RequestBody String body) {
        System.out.println("收到更新处理流程请求:" + body);
        //SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
       // String id = format2.format(new Date());
        JSONObject jsonObject = JSON.parseObject(body);
        ProcessInfo processInfo = JSONObject.parseObject(body, ProcessInfo.class);
        processInfo.setCreateTime(formatter.format(new Date()));
        AddProcessInfoResponse rep = new AddProcessInfoResponse();
        User user = userDto.selectUserById(processInfo.getNowProcessorId());

//        try {
//            smsNotify.sendNotifySms(user.getPhoneNo());
//        } catch (Exception e) {
//            System.out.println("短信发送失败");
//        }
        int i = processInfoDto.updateProcessInfoById(processInfo);
        if (1==i){
            rep.buildSuccess();
        }else{
            rep.buildFail("请稍后再试");
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
