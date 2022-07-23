package com.cau.managesystem.utils;


import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExcelUtil {

    @Test
    public void test() {
        // 生成Excel路径
        String fileName = "./test.xls";
        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("姓");
        head0.add("名");
        List<String> head1 = new ArrayList<>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<>();
        head2.add("生日");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("张三");
            data.add(25);
            data.add(new Date());
            list.add(data);
        }
        return list;
    }
}



