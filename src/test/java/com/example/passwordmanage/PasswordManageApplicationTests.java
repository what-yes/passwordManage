package com.example.passwordmanage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.passwordmanage.mapper.accountMapper;
import com.example.passwordmanage.mapper.userMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.passwordmanage.pojo.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PasswordManageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    userMapper userMapper;

    @Autowired
    accountMapper accountMapper;
    @Test
    void test() {
        List<Account> accounts = accountMapper.selectList(null);
        accounts.forEach(System.out::println);

    }

}
