package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.ComponenterMapper;
import com.cau.managesystem.entity.ClueCollection;
import com.cau.managesystem.entity.Componenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComponentDto {

    @Autowired
    private ComponenterMapper componenterMapper;


    public List<Componenter> selectAll() {
        List<Componenter> Components = componenterMapper.selectList(null);
        return Components;
    }

    public List<Componenter> selectByDate(String start,String end) {
        QueryWrapper<Componenter> wrapper = new QueryWrapper<>();
        wrapper.ge("id",start);
        wrapper.le("id", end);
        List<Componenter> Components = componenterMapper.selectList(wrapper);
        return Components;
    }

    public Componenter selectComponentById(String id) {
        QueryWrapper<Componenter> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Componenter> componentInfos = componenterMapper.selectList(wrapper);
        if (componentInfos != null && componentInfos.size() > 0)
            return componentInfos.get(0);
        return null;

    }

    public int insert(Componenter component) {
        int insert = componenterMapper.insert(component);
        return insert;
    }
}
