package com.cau.managesystem.service.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cau.managesystem.entity.User;
import com.cau.managesystem.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
    public int insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }
}
