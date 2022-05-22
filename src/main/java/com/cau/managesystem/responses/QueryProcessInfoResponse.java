package com.cau.managesystem.responses;

import com.cau.managesystem.entity.ProcessInfo;
import lombok.Data;

import java.util.List;

@Data
public class QueryProcessInfoResponse extends BaseResponse{
    private List<ProcessInfo> processInfos;
}
