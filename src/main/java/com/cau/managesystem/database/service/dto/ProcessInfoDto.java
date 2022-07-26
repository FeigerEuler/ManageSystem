package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.entity.ProcessInfo;
import com.cau.managesystem.database.service.mapper.ProcessInfoMapper;
import com.cau.managesystem.entity.Technician;
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

    public List<ProcessInfo> selectByDate(String start,String end) {
        QueryWrapper<Technician> wrapper = new QueryWrapper<>();
        wrapper.ge("id",start);
        wrapper.le("id", end);
        wrapper.eq("status", "done");
        List<ProcessInfo> ProcessInfos = processInfoMapper.selectList(null);
        return ProcessInfos;
    }


    public ProcessInfo selectProcessInfoByProcessInfoName(String processInfoName) {
        QueryWrapper<ProcessInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("processInfo_name", processInfoName);
        List<ProcessInfo> ProcessInfoInfos = processInfoMapper.selectList(wrapper);
        if (ProcessInfoInfos != null && ProcessInfoInfos.size() > 0)
            return ProcessInfoInfos.get(0);
        return null;

    }

    public List<ProcessInfo> selectProcessInfoByNowProcessorId(String nowProcessorId) {
        System.out.println("nowProcessorId="+nowProcessorId);
        QueryWrapper<ProcessInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("now_processor_id", nowProcessorId);
        wrapper.eq("status", "doing");
        List<ProcessInfo> processInfoInfos = processInfoMapper.selectList(wrapper);
        if (processInfoInfos != null && processInfoInfos.size() > 0)
            return processInfoInfos;
        return null;

    }

    public List<ProcessInfo> selectProcessInfoByStatus(String status) {
      //  System.out.println("nowProcessorId="+nowProcessorId);
        QueryWrapper<ProcessInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("status", status);
        List<ProcessInfo> processInfoInfos = processInfoMapper.selectList(wrapper);
        if (processInfoInfos != null && processInfoInfos.size() > 0)
            return processInfoInfos;
        return null;

    }
    public ProcessInfo selectProcessInfoById(String id) {
        System.out.println("tProcessorId="+id);
        QueryWrapper<ProcessInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<ProcessInfo> processInfoInfos = processInfoMapper.selectList(wrapper);
        if (processInfoInfos != null && processInfoInfos.size() > 0)
            return processInfoInfos.get(0);
        return null;
    }
    public int updateProcessInfoById(ProcessInfo processInfo) {
        System.out.println("tProcessorId="+processInfo.toString());
        int i = processInfoMapper.updateById(processInfo);
        return i;

    }
    public int insert(ProcessInfo processInfo) {
        int insert = processInfoMapper.insert(processInfo);
        return insert;
    }
}
