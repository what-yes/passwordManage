package com.example.passwordmanage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.passwordmanage.mapper.accountMapper;
import com.example.passwordmanage.pojo.Account;
import com.example.passwordmanage.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    accountMapper accountMapper;

    @GetMapping("/account/add/{uid}")
    public String toAddAccount(@PathVariable(value="uid")Integer uId, Model model, HttpSession session){
        session.setAttribute("uId",uId);
        session.setAttribute("aId",null);
        return "addAccount";
    }

    @GetMapping("/account/add/{uId}/{aId}")
    public String toUpdateAccount(@PathVariable(value="uId")Integer uId,
                                  @PathVariable(value="aId")Integer aId,
                                  HttpSession session){
        session.setAttribute("uId",uId);
        session.setAttribute("aId",aId);
        return "addAccount";
    }

    @PostMapping("/account/add")
    public String addAccount(Account account, HttpSession session){
        log.info(session.toString());
        Integer uId =(Integer) session.getAttribute("uId");
        account.setUId(uId);
        Integer aId = (Integer) session.getAttribute("aId");
        if(aId==null){
            log.info("插入");
            accountMapper.insert(account);
        }else{
            log.info("修改");
            account.setAId(aId);
            accountMapper.updateById(account);
        }
        return "redirect:/main.html";
    }

    @GetMapping("/account/{uId}")
    public String listAccount(@SessionAttribute(value = "uId") Integer uId, Model model){
        log.info(String.valueOf(uId));
        List<Account> accounts = accountMapper.selectList(new QueryWrapper<Account>().eq("user_id", uId));
        accounts.forEach(System.out::println);
        model.addAttribute("accounts", accounts);
        model.addAttribute("uId",uId);
        return "main";
    }

    @GetMapping("/account/delete/{id}")
    public String deleteAccount(@PathVariable(value="id") Integer A_id){
        log.info("被删ID" + String.valueOf(A_id));
        accountMapper.deleteById(A_id);
        return "redirect:/main.html";
    }
}
