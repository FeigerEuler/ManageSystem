package com.cau.managesystem;

import com.cau.managesystem.entity.User;
import com.cau.managesystem.service.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManageSystemApplication.class)
class ManageSystemApplicationTests {

    @Autowired
    private UserDto userDto;

    @Test
    void contextLoads() {
        System.out.println("hello world myq");
    }

    @Test
    void MhfTest() {
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        user.setPwd("admin");

        System.out.println(userDto.insert(user));


    }

}
