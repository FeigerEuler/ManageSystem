package com.cau.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;


@TableName("t_process_info")
@Data
public class ProcessInfo {

    private int id;

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
    private int clue_collectioner_id;

    /**
     * 外协岗处理人id
     */
    private int extener_id;

    /**
     * 服务顾问岗处理人id
     */
    private int service_consultant_id;

    /**
     * 车间技师岗处理人id
     */
    private int technician_id;

    /**
     * 配件岗处理人id
     */
    private int componenter_id;


    /**
     * 财务岗处理人id
     */
    private int treasurer_id;

    /**
     * 管理岗处理人id
     */
    private int manager_id;

    /**
     * 当前处理人id
     */
    private int now_processer_id;
    /**
     * 流程处理状态
     */
    private String status ;

    /**
     * 备注
     */
    private  String remark;


}
