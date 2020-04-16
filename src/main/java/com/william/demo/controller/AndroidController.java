package com.william.demo.controller;

import com. william.demo.dao.UserInfoDao;
import com. william.demo.model.ResultView;
import com. william.demo.model.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/android")
public class AndroidController {
    private UserInfoDao userInfoDao = new UserInfoDao();
    private ResultView resultView = new ResultView();
    @RequestMapping("list")
    private List<UserInfo> list(){
        return userInfoDao.getAll();
    }
    @RequestMapping("login")
    public ResultView login(UserInfo userInfo){
        System.out.println(userInfo);
        if (userInfoDao.login(userInfo)){
            resultView.setFlag("succ");
        }else{
            resultView.setFlag("error");
        }
        return resultView;
    }
}
