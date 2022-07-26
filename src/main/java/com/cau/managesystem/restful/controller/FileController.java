package com.cau.managesystem.restful.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.common.GaodeUtils;
import com.cau.managesystem.database.service.dto.*;
import com.cau.managesystem.entity.*;
import com.cau.managesystem.responses.AddProcessInfoResponse;
import com.cau.managesystem.responses.QueryDistrictsResponse;
import com.cau.managesystem.responses.QueryProcessInfoResponse;
import com.cau.managesystem.responses.TaskAssignResponse;
import com.cau.managesystem.smsService.SmsNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController()
@RequestMapping("download")
public class FileController {

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


    /**
     * 文件下载
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");
        System.out.println(fileName);
        String month = "202201";
        //createClueCollectionXLS(month);

        //if (StringUtils.hasText(fileName)) {
        //设置文件路径
        File file = new File("/Users/admin-mhf/IdeaProjects/ManageSystem/mhf.txt");
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + "fileName.txt");// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                // int i = bis.read(buffer);

                // while (i != -1) {
                buffer = "01234567890123456789".getBytes(StandardCharsets.UTF_8);
                System.out.println(buffer.length);
                System.out.println(">>>>>>>>>>>>");
                for (int j = 0; j < buffer.length; j++) {
                    System.out.println(buffer[j]);
                    os.write(buffer[j]);
                }

                //    i = bis.read(buffer);
                //}
                return "下载成功";
            } catch (Exception e) {

                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally { // 做关闭操作
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //    }
            }
        }
        return "下载失败";
    }

    private String createClueCollectionXLS(String startDate, String endDate) {

        List<List<String>> heads = buildheads();
        List<List<Object>> data = buildData(startDate, endDate);


        return "./test.xls";
    }

    private List<List<Object>> buildData(String startDate, String endDate) {
        List<List<Object>> list = new ArrayList<>();
        String path = "./test.xls";
        List<ProcessInfo> processInfos = processInfoDto.selectByDate(startDate, endDate);
        for (ProcessInfo p : processInfos) {
            String id = p.getId();
            ClueCollection clueCollection = clueCollectionDto.selectClueCollectionById(id);
            Componenter componenter = componentDto.selectComponentById(id);
            Consultant consultant = consultantDto.selectConsultantById(id);
            Extener extener = extenerDto.selectExtenerById(id);
            Technician technician = technicianDto.selectTechnicianById(id);
            Treasurer treasurer = treasurerDto.selectTreasurerById(id);

            List<Object> data = new ArrayList<>();
            data.add(id);
            data.add(clueCollection.getInfoSource());
            data.add(clueCollection.getClientReportTime());
            data.add(clueCollection.getReportRegion());
            data.add(clueCollection.getAcquire_time());
            data.add(clueCollection.getClueValid());
            data.add(clueCollection.getIsSubscriber());
            data.add(consultant.getIsSubscriber());
            data.add(clueCollection.getCreateTime());
            //head9.add("线索跟进人（外拓）");
            data.add(extener.getFirstContactTime());
            data.add(extener.getIsOnSite());


            //head12.add("到达现场时间");

            //head13.add("是否首个到达现场");
            data.add(extener.getHaveCarArrived());


            //head15.add("车辆到店时间");
            data.add(consultant.getIsRepire());

           data.add(consultant.getIsTotalLoss());


            //head18.add("车辆完工时间");
            data.add(treasurer.getDeliverTime());

            data.add(consultant.getOutputValue());

            data.add(extener.getMarketingFee());

            data.add(componenter.getComponentCost());


            //head23.add("毛利率");
            data.add(consultant.getIsViscousProduct());


            //head25.add("是否二次进店（非返修）");

            //head26.add("外维修地方（找保险公司获取）");






list.add(data);
        }
        return list;
    }

    private List<List<String>> buildheads() {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("单号");
        List<String> head1 = new ArrayList<>();
        head1.add("线索获取途径");
        List<String> head2 = new ArrayList<>();
        head2.add("客户报案时间");
        List<String> head3 = new ArrayList<>();
        head3.add("客户报案区域");
        List<String> head4 = new ArrayList<>();
        head4.add("线索获取时间");
        List<String> head5 = new ArrayList<>();
        head5.add("是否有效线索");

        List<String> head6 = new ArrayList<>();
        head6.add("是否自店保险");
        List<String> head7 = new ArrayList<>();
        head7.add("是否自店维修客户");
        List<String> head8 = new ArrayList<>();
        head8.add("线索分配时间");
        List<String> head9 = new ArrayList<>();
        head9.add("线索跟进人（外拓）");
        List<String> head10 = new ArrayList<>();
        head10.add("首次联系客户时间");
        List<String> head11 = new ArrayList<>();
        head11.add("是否到达现场");
        List<String> head12 = new ArrayList<>();
        head12.add("到达现场时间");
        List<String> head13 = new ArrayList<>();
        head13.add("是否首个到达现场");
        List<String> head14 = new ArrayList<>();
        head14.add("是否到店");
        List<String> head15 = new ArrayList<>();
        head15.add("车辆到店时间");
        List<String> head16 = new ArrayList<>();
        head16.add("是否维修");
        List<String> head17 = new ArrayList<>();
        head17.add("是否全损");
        List<String> head18 = new ArrayList<>();
        head18.add("车辆完工时间");
        List<String> head19 = new ArrayList<>();
        head19.add("车辆交付时间");
        List<String> head20 = new ArrayList<>();
        head20.add("产值");
        List<String> head21 = new ArrayList<>();
        head21.add("营销费用比");
        List<String> head22 = new ArrayList<>();
        head22.add("配件工时比");
        List<String> head23 = new ArrayList<>();
        head23.add("毛利率");
        List<String> head24 = new ArrayList<>();
        head24.add("是否为粘性产品");
        List<String> head25 = new ArrayList<>();
        head25.add("是否二次进店（非返修）");
        List<String> head26 = new ArrayList<>();
        head26.add("外维修地方（找保险公司获取）");

        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        list.add(head5);
        list.add(head6);
        list.add(head7);
        list.add(head8);
        list.add(head9);
        list.add(head10);
        list.add(head11);
        list.add(head12);
        list.add(head13);
        list.add(head14);
        list.add(head15);
        list.add(head16);
        list.add(head17);
        list.add(head18);
        list.add(head19);
        list.add(head20);
        list.add(head21);
        list.add(head22);
        list.add(head23);
        list.add(head24);
        list.add(head25);
        list.add(head26);

        return list;
    }

    @GetMapping("/test")
    public String helloWeb1() {
        return "helloworld";
    }
}
