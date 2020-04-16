package com.william.demo.controller;

import com. william.demo.dao.CompanyDao;
import com. william.demo.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private CompanyDao companyDao=new CompanyDao();
    @RequestMapping("list")
    public String list(Company company, Model model){
        model.addAttribute("list",companyDao.get6_items(company));
        return "company_list";
    }
    @RequestMapping("slist")
    public String slist(Company company, Model model){
        model.addAttribute("list",companyDao.get_items(company));
        return "company_list";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
    return "company_add";
    }
    @RequestMapping("add")
    public String add(Company company){
        companyDao.add(company);
        return "redirect:/company/alllist";
    }
    @RequestMapping("alllist")
    public String alllist(Company company, Model model){
        model.addAttribute("list",companyDao.get_Allitems());
        return "company_list";
    }
    @RequestMapping("del")
    public String del(Integer id){
        companyDao.del(id);
        //重定向到url地址是:/user/list
        return "redirect:/company/alllist";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(Integer id,Model model){
        model.addAttribute("company",companyDao.selById(id));
        return "company_update";
    }
    @RequestMapping("update")
    public String update(Company company){
        companyDao.update(company);
        return "redirect:/company/alllist";
    }
}
