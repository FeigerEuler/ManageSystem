package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("t_extener")
@Data
public class Extener {

    private String id;

    private String carOwnerName;

    private String carOwnerPhone;
    /**
     * 首次联系时间
     */
    private String firstContactTime;

    /**
     * 是否到达现场
     */
    private int isOnSite;

    /**
     * 线索信息是否有效 1-有效，0-无效
     */
    private int isValid;

    /**
     * 是否已经到店 1-是，2-否
     */
    private int haveCarArrived;

    /**
     * 营销费用
     */
    private int marketingFee;

    /**
     * 创建时间，即提交到数据库的时间。
     */
    private String createTime;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String createBy;


}
