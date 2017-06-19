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

/**
 * Servlet implementation class order
 */
@WebServlet("/order")
public class order extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
	  int userId=(Integer) session.getAttribute("userId");
		int id=(Integer)session.getAttribute("productNo");
		String name=request.getParameter("UserName");
		int quantity=Integer.parseInt(request.getParameter("Quatity"));
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
		int tempTotalProduct = 0;
		int tempAddedProduct = 0;
		int tempCart_Id=0;
		int tempPurchasedProducts=0;
       
		try {
			
			int price=0;
		connection=con.getconnection();
		pstmt=(PreparedStatement)connection.prepareStatement("select product_price from product where product_id=? ");
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		if(rs.next()){
			price=rs.getInt("product_price");
		}
		price=price*quantity;
		pstmt=(PreparedStatement) connection.prepareStatement("insert into cart_orders(customer_name,order_quantity,order_amount,customer_phone,"
				+ "customer_city,customer_state"
				+ "customer_zipcode,customer_country)values(?,?,?,?,?,?,?,?)");
		pstmt.setString(1,name );
		pstmt.setInt(2,quantity );
		pstmt.setInt(3, price);
		pstmt.setString(4,phoneNo );
		pstmt.setString(5,city );
		pstmt.setString(6,state );
		pstmt.setInt(7,zipcode );
		pstmt.setString(8,country );
		
		int temp=pstmt.executeUpdate();
		if(temp==1){
		pstmt= (PreparedStatement) connection.prepareStatement("select cart_id, total_products,added_products,purchased_products from cart where customer_id=?");
		pstmt.setInt(1, userId);
		rs=pstmt.executeQuery();
		System.out.println("query exicuted.......");
		if(rs.next()){
			tempCart_Id=rs.getInt("cart_id");
	     tempTotalProduct=rs.getInt("total_products");
		 tempAddedProduct=rs.getInt("added_products");
		 tempPurchasedProducts=rs.getInt("purchased_products");
		System.out.println("cart Id is "+tempCart_Id);
		pstmt=(PreparedStatement) connection.prepareStatement("delete from cart_products where product_id=? and cart_id=?");
		pstmt.setInt(1, id);
		pstmt.setInt(2, tempCart_Id);
		int temp1=pstmt.executeUpdate();
		if(temp1==1){
			
			
			
			tempAddedProduct--;
			tempPurchasedProducts++;
			System.out.println(" Totel product "+tempAddedProduct);
			 pstmt= (PreparedStatement) connection.prepareStatement("update cart set purchased_products=?, added_products=? where cart_id=? ");// update totel product 
			   pstmt.setInt(1, tempPurchasedProducts);
			   pstmt.setInt(2, tempAddedProduct);
			   pstmt.setInt(3,tempCart_Id );
			   int temp2=pstmt.executeUpdate();
			   System.out.println(" temp value "+temp2);
			   if(temp2==1){
		System.out.println("Sucessfull Buy..... Item EveryWhere");
	
			   }	   } }
		} 
		}
	catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		response.sendRedirect("CartProduct");
	}
    
	


	
	}

}
