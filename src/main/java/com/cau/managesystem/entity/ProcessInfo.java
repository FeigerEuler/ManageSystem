package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("t_process_info")
@Data
public class ProcessInfo {

    private String id;

    private String carOwnerName;

    private String carOwnerPhone;


    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 流程标题
     */
    private String title;

    /**
     * 事故收集岗处理人id
     */
    private String clueCollectionerId;

    /**
     * 外协岗处理人id
     */
    private String extenerId;

    /**
     * 服务顾问岗处理人id
     */
    private String serviceConsultantId;

    /**
     * 车间技师岗处理人id
     */
    private String technicianId;

    /**
     * 配件岗处理人id
     */
    private String componenterId;


    /**
     * 财务岗处理人id
     */
    private String treasurerId;

    /**
     * 管理岗处理人id
     */
    private String managerId;

    /**
     * 当前处理人id
     */
    private String nowProcessorId;
    /**
     * 流程处理状态
     */
    private String status ;

    /**
     * 备注
     */
    private  String remark;

    private String createTime;

}
