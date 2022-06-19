package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_treasurer")
@Data
public class Manager {

    private String id;
    private String carOwnerName;

    private String carOwnerPhone;
    private String deliverTime;

    private String createTime;

}
