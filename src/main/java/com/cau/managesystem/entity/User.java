package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("t_user")
@Data
public class User {

    private int id;

    private String userName;

    private String pwd;

    private String role;

    private String realName;

    private String department;

    private Date createTime;

    private Date updateTime;


}
