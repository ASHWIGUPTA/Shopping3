/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingWeb.servlets;

import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.connectDB.ConnectDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "FetchProduct", urlPatterns = {"/FetchProduct"})
public class FetchProduct extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            String id = request.getParameter("id");
            Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			
			con = ConnectDb.getconnection();
			psmt = con.prepareStatement("Select * from product where product_id = ?;");
			psmt.setInt(1, Integer.parseInt(id));
                        System.out.println(psmt);
			rs = psmt.executeQuery();
                        ProductDTO p = new ProductDTO();
                        if(rs.next()){
                   //     System.out.println(psmt + rs.getString("product_names"));
                        p.setName(rs.getString("product_name"));
                        p.setPrice(rs.getDouble("product_price"));
                        p.setWeight(rs.getString("product_weight"));
                        p.setDimensions(rs.getString("product_dimensions"));
                        p.setDescr(rs.getString("product_desc"));
                        p.setCategory(rs.getInt("category_id"));
                        p.setSeller(rs.getInt("seller_id"));
                        p.setQuantity(rs.getInt("product_quantity"));
                        p.setImg_path(rs.getString("img1"));
                        HttpSession session1 = request.getSession(true);
                        session1.setAttribute("product", p);
                        response.sendRedirect("single.jsp");
                        }}catch(Exception e){
                    e.printStackTrace();
                }	
        }
    }

    
    

