package com.william.demo.controller;

import com. william.demo.dao.NewsDao;
import com. william.demo.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsInfoController {
    private NewsDao newsDao=new NewsDao();
@RequestMapping("list")
    public String list(News news, Model model){
    model.addAttribute("list",newsDao.get6_items());
    return "news_list";
}
    @RequestMapping("Alllist")
    public String alllist(News news, Model model){
        model.addAttribute("news_list",newsDao.get_AllItems(news));
        return "news_list";
    }
@RequestMapping("toAdd")
    public String toAdd(){
    return "news_Add";

}
    @RequestMapping("add")
    public String add(News news){
        newsDao.add(news);
        //重定向到url地址是:/user/list
        return "redirect:/news/Alllist";
    }
    @RequestMapping("del")
    public String del(Integer id){
        newsDao.del(id);
        //重定向到url地址是:/user/list
        return "redirect:/news/Alllist";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(Integer id,Model model){
        //根据主键加载记录放入model
        model.addAttribute("news",newsDao.selById(id));
        return "news_update";
    }
    @RequestMapping("update")
    public String update(News news){
        newsDao.update(news);
        return "redirect:/news/Alllist";
    }

}
