package com.cau.managesystem.database.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cau.managesystem.entity.User;
import org.springframework.stereotype.Repository;


@Repository()
public interface UserMapper extends BaseMapper<User> {
}
