package com.william.demo.controller;

import com.william.demo.dao.CompanyDao;
import com.william.demo.dao.NewsDao;
import com.william.demo.model.Company;
import com.william.demo.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class IndexController {
    private CompanyDao companyDao = new CompanyDao();
    private NewsDao newsDao=new NewsDao();
//    @RequestMapping("/")
//    public String index(Model model){
//        //取5条最新的新闻
//        model.addAttribute("companyList",companyDao.list(5));
//        //取5个最新的公司
//        //取5个最新的岗位
//        return "index";
//    }
    @RequestMapping("/")
    public String news_list(Company company, Model model){
        model.addAttribute("company_list", companyDao.get6_items(company));
        System.out.println(Arrays.toString(companyDao.get6_items(company).toArray()));
        return "index";
    }
//    @RequestMapping("event")
//    public String toEvent(){
//        return "event";
//    }
}