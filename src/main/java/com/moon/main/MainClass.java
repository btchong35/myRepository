package com.moon.main;

import com.moon.entity.Product;
import groovy.transform.ASTTest;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/5/8
 * @since 1.0.0
 */
public class MainClass{

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        List<Product> list=new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/auctionsystem", "root", "123456");
        PreparedStatement statement=conn.prepareStatement("select * from product");
        ResultSet res=statement.executeQuery();
        while(res.next()){
            Product product=new Product(){
                @Override
                public String toString() {
                    return this.getPid()+"-"+this.getProductname()+"-"+this.getCreatedate();
                }
            };
            product.setPid(res.getInt("pid"));
            product.setProductname(res.getString("productname"));
            product.setCreatedate(res.getDate("createdate"));
            list.add(product);
        }
        for(Product e:list){
            System.out.println(e);
        }

    }
}