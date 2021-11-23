package com.example.passwordmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.passwordmanage.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

@Mapper
public interface userMapper extends BaseMapper<User> {
}
