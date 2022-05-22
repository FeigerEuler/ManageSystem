package com.cau.managesystem;

import com.cau.managesystem.entity.User;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MhfTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    @Test
    void MhfTest() {
        int random= (int) (Math.random()*1000);
        String num = formatter.format(new Date());
        System.out.println(num);
        System.out.println(num+random);

    }
}
