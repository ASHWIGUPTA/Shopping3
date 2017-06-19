package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.connectDB.ConnectDb;
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session=request.getSession(false);
	String name=request.getParameter("UserName");
	String email=request.getParameter("Email");
	String password=request.getParameter("Password");
	String phoneNo=request.getParameter("PhoneNo");
	String address=request.getParameter("Address");
	String city=request.getParameter("City");
	String country=request.getParameter("Country");
	String state=request.getParameter("State");
	int  zipcode=Integer.parseInt( request.getParameter("PhoneNo"));
	
	
	Connection connection=null;
	ConnectDb con=new ConnectDb();
	PreparedStatement  pstmt=null;
	ResultSet rs=null;

	try {
		connection=con.getconnection();
		pstmt=(PreparedStatement) connection.prepareStatement("insert into customer(customer_name,customer_email,customer_pass,customer_phone,"
				+ "customer_city,customer_state"
				+ "customer_zipcode,customer_country)values(?,?,?,?)");
		pstmt.setString(1,name );
		pstmt.setString(2,email );
		pstmt.setString(3,password );
		pstmt.setString(4,phoneNo );
		pstmt.setString(5,city );
		pstmt.setString(6,state );
		pstmt.setInt(7,zipcode );
		pstmt.setString(8,country );
		
		int temp=pstmt.executeUpdate();
		if(temp==1){
			pstmt=(PreparedStatement) connection.prepareStatement("select customer_id from customer where customer_name=? and customer_email=? and customer_pass=? and customer_phone=?");
			pstmt.setString(1,name );
			pstmt.setString(2,email );
			pstmt.setString(3,password );
			pstmt.setString(4,phoneNo );
			rs=pstmt.executeQuery();
			if(rs.next()){
				int tempId=rs.getInt("customer_id");
				System.out.println("custmer id is"+ tempId);
				pstmt=(PreparedStatement) connection.prepareStatement("insert into cart(customer_id)values(?)");
				pstmt.setInt(1,tempId );
				int temp2=pstmt.executeUpdate();
				if(temp2==1){
					System.out.println("sucessfull update.........");
					session.setAttribute("UserId", tempId);
					response.sendRedirect("index2.jsp");

				}
			}
			
			
					}

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	

}
	}


