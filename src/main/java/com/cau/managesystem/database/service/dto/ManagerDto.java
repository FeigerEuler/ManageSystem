package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.ManagerMapper;
import com.cau.managesystem.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDto {

    @Autowired
    private ManagerMapper managerMapper;


    public List<Manager> selectAll() {
        List<Manager> Managers = managerMapper.selectList(null);
        return Managers;
    }


    public Manager selectManagerById(String id) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Manager> managerInfos = managerMapper.selectList(wrapper);
        if (managerInfos != null && managerInfos.size() > 0)
            return managerInfos.get(0);
        return null;

    }

    public int insert(Manager manager) {
        int insert = managerMapper.insert(manager);
        return insert;
    }
    public int updateById(Manager manager){
        int ret = managerMapper.updateById(manager);
        return ret;
    }
}
