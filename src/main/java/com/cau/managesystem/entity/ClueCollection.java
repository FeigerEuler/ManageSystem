package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_clue_collection")
@Data
public class ClueCollection {

    private String id;

    private String carOwnerName;


    private String carOwnerPhone;

    /**
     * 首次联系时间
     */
    private String infoSource;

    /**
     * 是否到达现场
     */
    private String acquire_time;

    /**
     * 线索信息是否有效 1-有效，0-无效
     */
    private int clueValid;

    /**
     * 是否已经到店 1-是，2-否
     */
    private String clientReportTime;

    /**
     * 营销费用
     */
    private String reportRegion;

    /**
     * 创建时间，即提交到数据库的时间。
     */
    private int isSubscriber;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String brand;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String createTime;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String model;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String createBy;

}
