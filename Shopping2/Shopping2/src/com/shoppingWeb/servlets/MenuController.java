/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingWeb.servlets;

import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.POJO.SearchCategory;
import com.shoppingWeb.connectDB.ConnectDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author puneet gupta
 */
@WebServlet(name = "MenuController", urlPatterns = {"/MenuController"})
public class MenuController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
      System.out.println("enter the menu");  
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        String menu = request.getParameter("menu");
        System.out.println(menu);
        ArrayList<ProductDTO>  a = new ArrayList<ProductDTO>();
        
        if(session.getAttribute("UserId")==null){                   // session Attribute Added
         HashSet List=(HashSet)session.getAttribute("list");
         session.setAttribute("ProductNo", List);
        
        }
        else{                                                           //Login Attribute Added
        	  int userID=(Integer)session.getAttribute("UserId");
        		session.setAttribute("UserId", userID);
        		
        }
        
        try{
            con = ConnectDb.getconnection();
            psmt = con.prepareStatement("select category_id from Category where category_name=?");
            System.out.println(psmt);
            psmt.setString(1, menu);
            System.out.println(psmt);
            rs = psmt.executeQuery();
            while(rs.next()){
                System.out.println("hii , i'm in resultset 1");
                System.out.println("Id is"+rs.getInt("category_id"));
                int Id=rs.getInt("category_id");
                psmt = con.prepareStatement("select * from product where category_id=?");
			psmt.setInt(1, Id);
			System.out.println("Second pstmt"+psmt);
			rs1 = psmt.executeQuery();
			
			while(rs1.next()){
                            System.out.println("hii , im in resultset 2");
				ProductDTO pd = new ProductDTO();
				pd.setId(rs1.getInt("product_id"));
				pd.setName(rs1.getString("product_name"));
				pd.setPrice(rs1.getDouble("product_price"));
				pd.setWeight(rs1.getString("product_weight"));
				pd.setDimensions(rs1.getString("product_dimensions"));
				pd.setDescr(rs1.getString("product_desc"));
				pd.setQuantity(rs1.getInt("product_quantity"));
				pd.setSeller(rs1.getInt("seller_id"));
				pd.setCategory(rs1.getInt("category_id"));
				pd.setImg_path(rs1.getString("img1"));
				a.add(pd);
			
                        }
                       
                       for(ProductDTO pd : a){
                        System.out.println(pd.getId() + pd.getName());
                    } 
                        session.setAttribute("list2", a);
                      
            }
        }catch(Exception e){
            e.printStackTrace();
                  }
        finally{
        	 response.sendRedirect("product.jsp");
 			
        }
	
    }
}
