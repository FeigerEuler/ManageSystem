package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_treasurer")
@Data
public class Treasurer {

    private String id;

    private String deliverTime;

    private String createTime;

}
