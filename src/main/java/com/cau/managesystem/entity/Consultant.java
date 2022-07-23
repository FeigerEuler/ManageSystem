package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_consultant")
@Data
public class Consultant {

    private String id;

    private String carOwnerName;

    private String carOwnerPhone;
    /**
     * 首次联系时间
     */
    private int isSubscriber;

    /**
     * 是否到达现场
     */
    private int isOnArrival;

    /**
     * 线索信息是否有效 1-有效，0-无效
     */
    private String arriveTime;

    /**
     * 是否已经到店 1-是，2-否
     */
    private int isRepire;

    /**
     * 营销费用
     */
    private int isTotalLoss;

    /**
     * 创建时间，即提交到数据库的时间。
     */
    private String deliverTime;

    /**
     * 创建人，即提交到数据库的员工
     */
    private String accomplishmentTime;

    private String outputValue;
    private String componentCost;
    private int isViscousProduct;
    private String createTime;





}
