package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.ConsultantMapper;
import com.cau.managesystem.entity.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultantDto {

    @Autowired
    private ConsultantMapper consultantMapper;


    public List<Consultant> selectAll() {
        List<Consultant> Consultants = consultantMapper.selectList(null);
        return Consultants;
    }


    public Consultant selectConsultantById(String id) {
        QueryWrapper<Consultant> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Consultant> consultantInfos = consultantMapper.selectList(wrapper);
        if (consultantInfos != null && consultantInfos.size() > 0)
            return consultantInfos.get(0);
        return null;

    }

    public int insert(Consultant Consultant) {
        int insert = consultantMapper.insert(Consultant);
        return insert;
    }
}
