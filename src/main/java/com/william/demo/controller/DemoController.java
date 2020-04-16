package com.william.demo.controller;


import com. william.demo.dao.UserInfoDao;
import com. william.demo.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    private UserInfoDao userInfoDao = new UserInfoDao();

//    public String login(UserInfo userInfo, Model model){
////        System.out.println(userInfo);
////        if(userInfoDao.login(userInfo)){//成功
////            return "main";
////        }
////        //把页面需要访问的数据放入modle对象
////        model.addAttribute("flag","0");
//        return "login-page";
//
//    }
    @RequestMapping("login")
    public String login(){
        return"login-page";
    }
    @RequestMapping("main")
    public String main(UserInfo userInfo,Model model){
        if(userInfoDao.login(userInfo)){//成功
            return "main";
        }
        //把页面需要访问的数据放入modle对象
        model.addAttribute("flag","0");
        return "login-page";
    }
//注册页面没写
//    @RequestMapping("register")
//    public String register(){
//        System.out.println("register");
//        return "";
//    }
//

}
