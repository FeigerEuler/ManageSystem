package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.TreasurerMapper;
import com.cau.managesystem.entity.Treasurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreasurerDto {

    @Autowired
    private TreasurerMapper treasurerMapper;


    public List<Treasurer> selectAll() {
        List<Treasurer> Treasurers = treasurerMapper.selectList(null);
        return Treasurers;
    }


    public Treasurer selectTreasurerById(String id) {
        QueryWrapper<Treasurer> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Treasurer> treasurerInfos = treasurerMapper.selectList(wrapper);
        if (treasurerInfos != null && treasurerInfos.size() > 0)
            return treasurerInfos.get(0);
        return null;

    }

    public int insert(Treasurer treasurer) {
        int insert = treasurerMapper.insert(treasurer);
        return insert;
    }
}
