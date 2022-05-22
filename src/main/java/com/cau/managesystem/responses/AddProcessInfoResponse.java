package com.cau.managesystem.responses;

import com.cau.managesystem.entity.ProcessInfo;
import com.cau.managesystem.entity.User;
import lombok.Data;

@Data
public class AddProcessInfoResponse extends BaseResponse{
    private ProcessInfo processInfo;
}
