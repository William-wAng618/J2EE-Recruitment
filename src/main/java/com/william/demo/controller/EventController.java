package com.william.demo.controller;

import com. william.demo.dao.NewsDao;
import com. william.demo.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {
    private NewsDao newsDao=new NewsDao();
    @RequestMapping("")
    public String toEvent(News news, Model model){
        model.addAttribute("news_list",newsDao.get_AllItems(news));
        return "event";
    }
}
