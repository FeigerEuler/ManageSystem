package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.ClueCollectionMapper;
import com.cau.managesystem.entity.ClueCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClueCollectionDto {

    @Autowired
    private ClueCollectionMapper clueCollectionMapper;


    public List<ClueCollection> selectAll() {
        List<ClueCollection> ClueCollections = clueCollectionMapper.selectList(null);
        return ClueCollections;
    }
    public List<ClueCollection> selectRecordsByDate(String start,String end) {
        QueryWrapper<ClueCollection> wrapper = new QueryWrapper<>();
        wrapper.ge("id",start);
        wrapper.le("id", end);
        List<ClueCollection> ClueCollections = clueCollectionMapper.selectList(null);
        return ClueCollections;
    }

    public ClueCollection selectClueCollectionByClueCollectionName(String ClueCollectionName) {
        QueryWrapper<ClueCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("ClueCollection_name", ClueCollectionName);
        List<ClueCollection> clueCollectionInfos = clueCollectionMapper.selectList(wrapper);
        if (clueCollectionInfos != null && clueCollectionInfos.size() > 0)
            return clueCollectionInfos.get(0);
        return null;

    }


    public ClueCollection selectClueCollectionById(String id) {
        QueryWrapper<ClueCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<ClueCollection> clueCollectionInfos = clueCollectionMapper.selectList(wrapper);
        if (clueCollectionInfos != null && clueCollectionInfos.size() > 0)
            return clueCollectionInfos.get(0);
        return null;

    }


    public int insert(ClueCollection ClueCollection) {
        int insert = clueCollectionMapper.insert(ClueCollection);
        return insert;
    }
}
