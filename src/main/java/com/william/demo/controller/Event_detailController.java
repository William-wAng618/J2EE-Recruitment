package com.william.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventdetail")
public class Event_detailController {
    @RequestMapping("event_detail1")
    public String todetail(){
        return "event_detail1";
    }
    @RequestMapping("event_detail2")
    public String todetai2(){
        return "event_detail2";
    }
    @RequestMapping("event_detail3")
    public String todetai3(){
        return "event_detail3";
    }
    @RequestMapping("event_detail4")
    public String todetai4(){
        return "event_detail4";
    }
    @RequestMapping("event_detail5")
    public String todetai5(){
        return "event_detail5";
    }
    @RequestMapping("event_detail6")
    public String todetai6(){
        return "event_detail6";
    }
}
