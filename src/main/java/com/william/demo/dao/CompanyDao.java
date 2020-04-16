package com.william.demo.dao;

import com. william.demo.model.Company;
import com. william.demo.util.ConnDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    public List<Company> get6_items(Company qcompany){
        List<Company>list=new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select * from company_info LIMIT 6";
//        if(qcompany!=null){
//            String name=qcompany.getName();
//            String content=qcompany.getContent();
//            String funds=qcompany.getFunds();
//            String tel=qcompany.getTel();
//            String address=qcompany.getAddress();
//            String scale=qcompany.getScale();
//            String indus=qcompany.getIndustry();
//            String description=qcompany.getDescription();
//            if(name!=null && !name.equals("")){//如果查询条件有用户名
//                //把查询用户名的条件拼接到sql中
//                sql += "and name like'" + name + "%' ";
//            }
//            if(content!=null && !content.equals("")){
//                sql += "and content like'" + content + "%' ";
//            }
//            if(funds!=null && !funds.equals("")){
//                sql += "and funds like'" + funds + "%' ";
//            }
//            if(tel!=null && !tel.equals("")){
//                sql += "and tel like'" + tel + "%' ";
//            }
//            if(address!=null && !address.equals("")){
//                sql += "and address like'" + address + "%' ";
//            }
//            if(scale!=null && !scale.equals("")){
//                sql += "and scale like'" + scale + "%' ";
//            }
//            if(indus!=null && !indus.equals("")){
//                sql += "and industry like'" + indus + "%' ";
//            }
//            if(description!=null && !description.equals("")){
//                sql += "and description like'" + description + "%' ";
//            }
//            System.out.println(sql);
//        }

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Company company=new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setContent(rs.getString(3));
                company.setFunds(rs.getString(4));
                company.setTel(rs.getString(5));
                company.setAddress(rs.getString(6));
                company.setScale(rs.getString(7));
                company.setIndustry(rs.getString(8));
                company.setDescription(rs.getString(9));
                company.setHerf(rs.getString(10));
                company.setAddDate(rs.getString(11));
                list.add(company);
            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }


    public List<Company> get_items(Company qcompany){
        List<Company>list=new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select * from company_info where 1=1";
        if(qcompany!=null){
            String name=qcompany.getName();
            if(name!=null && !name.equals("")){//如果查询条件有用户名
                //把查询用户名的条件拼接到sql中
                sql += " and name like'" + name + "%' ";
            }
            System.out.println(sql);
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Company company=new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setContent(rs.getString(3));
                company.setFunds(rs.getString(4));
                company.setTel(rs.getString(5));
                company.setAddress(rs.getString(6));
                company.setScale(rs.getString(7));
                company.setIndustry(rs.getString(8));
                company.setDescription(rs.getString(9));
                company.setHerf(rs.getString(10));
                company.setAddDate(rs.getString(11));
                list.add(company);
            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }



    public void add(Company company){
        Connection conn=ConnDB.getConn();
        String sql="insert into company_info(name,content,funds,tel,address,scale,industry,description,herf,add_date) values(?,?,?,?,?,?,?,?,?,now())";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,company.getName());
            pst.setString(2,company.getContent());
            pst.setString(3,company.getFunds());
            pst.setString(4,company.getTel());
            pst.setString(5,company.getAddress());
            pst.setString(6,company.getScale());
            pst.setString(7,company.getIndustry());
            pst.setString(8,company.getDescription());
            pst.setString(9,company.getHerf());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Company> get_Allitems(){
        List<Company>list=new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select * from company_info";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Company company=new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setContent(rs.getString(3));
                company.setFunds(rs.getString(4));
                company.setTel(rs.getString(5));
                company.setAddress(rs.getString(6));
                company.setScale(rs.getString(7));
                company.setIndustry(rs.getString(8));
                company.setDescription(rs.getString(9));
                company.setHerf(rs.getString(10));
                company.setAddDate(rs.getString(11));
                list.add(company);
            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }
    public void del(Integer id){
        String sql = "delete from company_info where id="+id;
        Connection conn = ConnDB.getConn();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Company selById(Integer id){
        Company company = new Company();
        Connection conn = ConnDB.getConn();
        String sql = "select id,name,content,funds,tel,address,scale," +
                "industry,description,herf,add_date from company_info " +
                "where id="+id;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                company.setId(rs.getInt("id"));
                company.setName(rs.getString("name"));
                company.setContent(rs.getString("content"));
                company.setFunds(rs.getString("funds"));
                company.setTel(rs.getString("tel"));
                company.setAddress(rs.getString("address"));
                company.setScale(rs.getString("scale"));
                company.setIndustry(rs.getString("industry"));
                company.setDescription(rs.getString("description"));
                company.setHerf(rs.getString("herf"));
                company.setAddDate(rs.getString("add_date"));

            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void update(Company company){
        Connection conn = ConnDB.getConn();
        String sql = "update company_info set name=?,content=?," +
                "funds=?,tel=?,address=?,scale=?,industry=?," +
                "description=?,herf=?,add_date=? where id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,company.getName());
            pst.setString(2,company.getContent());
            pst.setString(3,company.getFunds());
            pst.setString(4,company.getTel());
            pst.setString(5,company.getAddress());
            pst.setString(6,company.getScale());
            pst.setString(7,company.getIndustry());
            pst.setString(8,company.getDescription());
            pst.setString(9,company.getHerf());
            pst.setString(10,company.getAddDate());
            pst.setInt(11,company.getId());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
