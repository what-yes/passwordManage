package com.example.passwordmanage.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.passwordmanage.mapper.userMapper;
import com.example.passwordmanage.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class indexController {

    @Autowired
    userMapper userMapper;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @PostMapping("/login")
    public String loginUser(User user, HttpSession session, Model model){

        System.out.println(user.toString());
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("user_name",user.getName()).eq("user_password",user.getPassword());
        List<User> users = userMapper.selectList(userWrapper);
        if(!users.isEmpty()){
            log.info("users not empty");
            session.setAttribute("LoginUser", users.get(0));
            session.setAttribute("uId",users.get(0).getID());
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg", "账号密码错误");
            return "index";
        }
    }

    @GetMapping("/main.html")
    public String Main(@SessionAttribute(value = "uId") Integer uId, Model model){
//    public String Main(Model model,HttpSession session){
//        log.info(session.getAttribute("uId")+"");
//        log.info(session.getAttribute("LoginUser").toString());
        model.addAttribute("uId",uId);
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("LoginUser");
        return "redirect:/index";
    }
}
