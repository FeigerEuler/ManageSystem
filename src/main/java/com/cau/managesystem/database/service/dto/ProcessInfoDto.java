package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.entity.ProcessInfo;
import com.cau.managesystem.database.service.mapper.ProcessInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcessInfoDto {

    @Autowired
    private ProcessInfoMapper processInfoMapper;


    public List<ProcessInfo> selectAll() {
        List<ProcessInfo> ProcessInfos = processInfoMapper.selectList(null);
        return ProcessInfos;
    }


    public ProcessInfo selectProcessInfoByProcessInfoName(String processInfoName) {
        QueryWrapper<ProcessInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("ProcessInfo_name", processInfoName);
        List<ProcessInfo> ProcessInfoInfos = processInfoMapper.selectList(wrapper);
        if (ProcessInfoInfos != null && ProcessInfoInfos.size() > 0)
            return ProcessInfoInfos.get(0);
        return null;

    }

    public int insert(ProcessInfo processInfo) {
        int insert = processInfoMapper.insert(processInfo);
        return insert;
    }
}
