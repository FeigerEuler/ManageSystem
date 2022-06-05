package com.cau.managesystem.database.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.database.service.mapper.UserMapper;
import com.cau.managesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDto {

    @Autowired
    private UserMapper userMapper;


    public List<User> selectAll() {
        List<User> userInfos = userMapper.selectList(null);
        return userInfos;
    }


    public User selectUserByUserName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userName);
        List<User> userInfos = userMapper.selectList(wrapper);
        if(userInfos != null&&userInfos.size()>0)
            return userInfos.get(0);
        return null;

    }
    public List<User> selectUserByDepartment(String department) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("department",department);
        List<User> userInfos = userMapper.selectList(wrapper);
        if(userInfos != null&&userInfos.size()>0)
            return userInfos;
        return null;

    }
    public User selectUserById(String id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        List<User> userInfos = userMapper.selectList(wrapper);
        if(userInfos != null&&userInfos.size()>0)
            return userInfos.get(0);
        return null;

    }
    public int insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }
}
