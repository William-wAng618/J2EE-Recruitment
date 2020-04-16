package com.william.demo.dao;

import com. william.demo.model.News;
import com. william.demo.util.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    public List<News> get6_items(){
        List<News>list=new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql="select *from news_info LIMIT 6";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){

                News news=new News();
                news.setId(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setContent(rs.getString(3));
                news.setAddress(rs.getString(4));
                news.setAddDate(rs.getString(5));
                list.add(news);
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
    public List<News> get_AllItems(News qnews){
        List<News>list=new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql="select id,title,content,address,add_date from news_info where 1=1 ";
        if (qnews !=null){
            String title=qnews.getTitle();
            if(title!=null && !title.equals("")){//如果查询条件有用户名
                //把查询用户名的条件拼接到sql中
                sql += "and title like'" + title + "%' ";
            }
            System.out.println(sql);
            System.out.println(title);
        }

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){

                News news=new News();
                news.setId(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setContent(rs.getString(3));
                news.setAddress(rs.getString(4));
                news.setAddDate(rs.getString(5));
                list.add(news);
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
        String sql = "delete from news_info where id="+id;
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
    public News selById(Integer id){
        News news = new News();
        Connection conn = ConnDB.getConn();
        String sql = "select id,title,content,address from news_info " +
                "where id="+id;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setAddress(rs.getString("address"));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }
    public void update(News userInfo){
        Connection conn = ConnDB.getConn();
        String sql = "update news_info set title=?,content=?,address=? where id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,userInfo.getTitle());
            pst.setString(2,userInfo.getContent());
            pst.setString(3,userInfo.getAddress());
            pst.setInt(4,userInfo.getId());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void add(News news){
        Connection conn = ConnDB.getConn();
        String sql = "insert into news_info(title,content,address,add_date) " +
                "values(?,?,?,now())";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,news.getTitle());
            pst.setString(2,news.getContent());
            pst.setString(3,news.getAddress());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

