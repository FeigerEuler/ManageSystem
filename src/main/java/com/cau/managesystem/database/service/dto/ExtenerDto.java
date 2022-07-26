package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.ExtenerMapper;
import com.cau.managesystem.entity.Consultant;
import com.cau.managesystem.entity.Extener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtenerDto {

    @Autowired
    private ExtenerMapper extenerMapper;


    public List<Extener> selectAll() {
        List<Extener> Exteners = extenerMapper.selectList(null);
        return Exteners;
    }
    public List<Extener> selectByDate(String start,String end) {
        QueryWrapper<Extener> wrapper = new QueryWrapper<>();
        wrapper.ge("id",start);
        wrapper.le("id", end);
        List<Extener> Exteners = extenerMapper.selectList(wrapper);
        return Exteners;
    }

    public Extener selectExtenerByExtenerName(String ExtenerName) {
        QueryWrapper<Extener> wrapper = new QueryWrapper<>();
        wrapper.eq("extener_name", ExtenerName);
        List<Extener> extenerInfos = extenerMapper.selectList(wrapper);
        if (extenerInfos != null && extenerInfos.size() > 0)
            return extenerInfos.get(0);
        return null;

    }

    public Extener selectExtenerById(String id) {
        QueryWrapper<Extener> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Extener> extenerInfos = extenerMapper.selectList(wrapper);
        if (extenerInfos != null && extenerInfos.size() > 0)
            return extenerInfos.get(0);
        return null;

    }
    public int insert(Extener Extener) {
        int insert = extenerMapper.insert(Extener);
        return insert;
    }
}
