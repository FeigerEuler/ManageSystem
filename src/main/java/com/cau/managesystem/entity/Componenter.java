package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_componenter")
@Data
public class Componenter {

    private String id;

    private String componentCost;

    private String createTime;

}
