package com.shoppingWeb.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.POJO.CategoryDTO;
import com.shoppingWeb.connectDB.ConnectDb;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	static int id;
	@Override
	public void init() throws ServletException {
		id =0 ;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Category_name");
		String brand = request.getParameter("Category_brand");
		try {
			
			Connection con = ConnectDb.getconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category (category_name,category_brand)values(?,?);");
			//System.out.println(id);
			pstmt.setString(1, name);
			pstmt.setString(2, brand);
			int result =0; 
			result = pstmt.executeUpdate();
			if(result > 0){
				response.sendRedirect("addcategory.jsp");
			}
			else{
				response.sendRedirect("error.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
