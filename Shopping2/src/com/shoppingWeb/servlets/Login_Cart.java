package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.connectDB.ConnectDb;

/**
 * Servlet implementation class Login_Cart
 */

public class Login_Cart extends HttpServlet {
	HashSet list=null;
	public void init() throws ServletException {
		   // Initialization code...
   list=new HashSet();
		}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		
		int pId=Integer.parseInt(request.getParameter("productID"));
		
Connection connection=null;
ConnectDb con=new ConnectDb();
PreparedStatement  pstmt=null;
ResultSet rs=null;

int tempCart_Id=0;
int tempTotalProduct = 0;
int tempAddedProduct = 0;
int counter=0;
ArrayList<Integer> pID=new ArrayList<Integer>();

if(true){
	
}

if(session.getAttribute("UserId")==null && request.getParameter("productID")!=null){                   // session Attribute Added
	System.out.println("enter the login");
Iterator it=list.iterator();
	
	while(it.hasNext()){
		System.out.println("List1"+it.next());
	}
	System.out.println();

	list.add(Integer.parseInt(request.getParameter("productID")));
	 it=list.iterator();
	
	while(it.hasNext()){
		System.out.println("List 2"+it.next());
	}
	session.setAttribute("aa", 1);           //temp
	session.setAttribute("ProductNo", list);
	
	   if(session.getAttribute("list2")!=null){
			  session.setAttribute("list2",session.getAttribute("list2"));
			  response.sendRedirect("product.jsp");
		  }
	   else{
	
	
	response.sendRedirect("index.jsp");
	}}
else{
	int userId=(Integer)session.getAttribute("UserId");
	session.setAttribute("UserId", userId);
	
try {
	connection=con.getconnection();
	pstmt= (PreparedStatement) connection.prepareStatement("select cart_id ,total_products,added_products from cart where customer_id=?");
	pstmt.setInt(1, userId);
	rs=pstmt.executeQuery();
	System.out.println("query exicuted.......");
	if(rs.next()){
     tempCart_Id=rs.getInt("cart_id");
     tempTotalProduct=rs.getInt("total_products");
	 tempAddedProduct=rs.getInt("added_products");
	System.out.println("cart Id is "+tempCart_Id);
	}pstmt=(PreparedStatement) connection.prepareStatement("select product_id from cart_products where cart_id=?");// Duplicate 
	pstmt.setInt(1, tempCart_Id);
	rs=pstmt.executeQuery();
	while(rs.next()){
		
		pID.add(rs.getInt("product_id"));
		
	}
	Iterator<Integer> it=pID.iterator();
	while(it.hasNext()){
		int ProID=it.next();
		if(ProID==pId){
			counter++;
		}
	}
	if(counter<1){
	pstmt=(PreparedStatement) connection.prepareStatement("insert into cart_products values(?,?)");//insert value
   pstmt.setInt(1, tempCart_Id);
   pstmt.setInt(2, pId);
   int ex=pstmt.executeUpdate();
   if(ex==1){
	   tempTotalProduct++; 
	   tempAddedProduct++;
	   pstmt= (PreparedStatement) connection.prepareStatement("update cart set total_products=?, added_products=? where cart_id=? ");// update totel product 
	   pstmt.setInt(1, tempTotalProduct);
	   pstmt.setInt(2, tempAddedProduct);
	   pstmt.setInt(3, tempCart_Id);
	   int temp=pstmt.executeUpdate();
	   if(temp==1){
   System.out.println("Succesfull added in cart");
   if(session.getAttribute("list2")!=null){
		  session.setAttribute("list2",session.getAttribute("list2"));
		  response.sendRedirect("product.jsp");
	  }else
	  {
   response.sendRedirect("index.jsp");
      }}
	   
   }
   else{
	   System.out.println("Qery not exicuted....");
   }
   }else{System.out.println("Duplicate product ....");

	   if(session.getAttribute("list2")!=null){
			  session.setAttribute("list2",session.getAttribute("list2"));
			  response.sendRedirect("product.jsp");
		  }
	   
	   else{	   	
response.sendRedirect("index.jsp");
}}
	} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}}}

