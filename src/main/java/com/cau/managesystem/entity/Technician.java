package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_technician")
@Data
public class Technician {

    private String id;
    private String carOwnerName;

    private String carOwnerPhone;
    private String accomplishmentTime;

    private String createTime;

}
