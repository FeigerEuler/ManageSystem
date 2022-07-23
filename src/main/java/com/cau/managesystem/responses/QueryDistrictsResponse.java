package com.cau.managesystem.responses;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cau.managesystem.common.GaodeUtils;
import com.cau.managesystem.entity.District;
import com.cau.managesystem.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class QueryDistrictsResponse extends BaseResponse{
    private List<District> districtNames;
}
