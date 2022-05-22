package com.cau.managesystem;

import com.cau.managesystem.entity.Extener;
import com.cau.managesystem.entity.User;

import com.cau.managesystem.database.service.dto.ExtenerDto;
import com.cau.managesystem.database.service.dto.UserDto;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManageSystemApplication.class)
class ManageSystemApplicationTests {

    @Autowired
    private UserDto userDto;
    @Autowired
    private ExtenerDto extenerDto;

    @Test
    void contextLoads() {
        System.out.println("hello world myq");
    }

    @Test
    void MhfTest() {
        User user = new User();
        user.setId("100");
        user.setUserName("admin2");
        user.setPwd("admin2");
        System.out.println(Date.valueOf(LocalDate.now()));

        System.out.println(userDto.insert(user));


    }

    @Test
    void MhfTest2() {
        Extener extener = new Extener();
        extener.setId("1");
        extener.setHaveCarArrived(1);
        extener.setFirstContactTime("2022-05-21");


        System.out.println("已插入："+extenerDto.insert(extener));


    }
}
