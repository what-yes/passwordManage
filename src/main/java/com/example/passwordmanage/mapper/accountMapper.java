package com.example.passwordmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.passwordmanage.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface accountMapper extends BaseMapper<Account> {
}
