package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.TechnicianMapper;
import com.cau.managesystem.entity.Extener;
import com.cau.managesystem.entity.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicianDto {

    @Autowired
    private TechnicianMapper technicianMapper;


    public List<Technician> selectAll() {
        List<Technician> Technicians = technicianMapper.selectList(null);
        return Technicians;
    }

    public List<Technician> selectByDate(String start,String end) {
        QueryWrapper<Technician> wrapper = new QueryWrapper<>();
        wrapper.ge("id",start);
        wrapper.le("id", end);
        List<Technician> Technicians = technicianMapper.selectList(wrapper);
        return Technicians;
    }
    public Technician selectTechnicianById(String id) {
        QueryWrapper<Technician> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Technician> technicianInfos = technicianMapper.selectList(wrapper);
        if (technicianInfos != null && technicianInfos.size() > 0)
            return technicianInfos.get(0);
        return null;

    }

    public int insert(Technician Technician) {
        int insert = technicianMapper.insert(Technician);
        return insert;
    }
}
