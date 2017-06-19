package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.connectDB.ConnectDb;


public class Delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
	   ArrayList<ProductDTO> productList=(ArrayList<ProductDTO>)session.getAttribute("List");
	   
	   int id=Integer.parseInt(request.getParameter("productID"));
	   String option=request.getParameter("type");
	   System.out.println("type of oprestion....."+option);
	   System.out.println("ID is..."+id);
	   if(session.getAttribute("UserId")==null){                   // session Attribute Added


	 
	   
	   if(option.equals("Delete")){
			
	   for(Iterator<ProductDTO> it=productList.iterator();it.hasNext();){
		   ProductDTO temp=it.next();
		   if(temp.getId()==id){
			   it.remove();
				  session.setAttribute("List", productList);
				  response.sendRedirect("checkout.jsp");
		   }}
	   }
	   else{
		   response.sendRedirect("login.html");
	   }}
	   
	   else{                                            // UserId Delete
		   int userID=(int) session.getAttribute("UserId");
		   session.setAttribute("UserId", userID);
		   Connection connection=null;
			ConnectDb con=new ConnectDb();
			PreparedStatement  pstmt=null;
			ResultSet rs=null;
			int tempTotalProduct = 0;
			int tempAddedProduct = 0;
			int tempCart_Id=0;
			int tempPurchasedProducts=0;
	      if(option.equals("Delete")){
				
			
			try {
				connection=con.getconnection();
				pstmt= (PreparedStatement) connection.prepareStatement("select cart_id, total_products,added_products from cart where customer_id=?");
				pstmt.setInt(1, userID);
				rs=pstmt.executeQuery();
				System.out.println("query exicuted.......");
				if(rs.next()){
					tempCart_Id=rs.getInt("cart_id");
			     tempTotalProduct=rs.getInt("total_products");
				 tempAddedProduct=rs.getInt("added_products");
				System.out.println("cart Id is "+tempCart_Id);
				
				pstmt=(PreparedStatement) connection.prepareStatement("delete from cart_products where product_id=? and cart_id=?");
				pstmt.setInt(1, id);
				pstmt.setInt(2, tempCart_Id);
				int temp=pstmt.executeUpdate();
				if(temp==1){
					
					
					tempTotalProduct--;
					tempAddedProduct--;
					System.out.println(" Totel product "+tempAddedProduct);
					 pstmt= (PreparedStatement) connection.prepareStatement("update cart set total_products=?, added_products=? where cart_id=? ");// update totel product 
					   pstmt.setInt(1, tempTotalProduct);
					   pstmt.setInt(2, tempAddedProduct);
					   pstmt.setInt(3,tempCart_Id );
					   int temp2=pstmt.executeUpdate();
					   System.out.println(" temp value "+temp2);
					   if(temp2==1){
				System.out.println("Sucessfull Delete Item EveryWhere");
					   }	   } }}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				response.sendRedirect("CartProduct");
			}
	        
		}
	else{System.out.println("Buy the Product......");
		try {
			connection=con.getconnection();
			pstmt= (PreparedStatement) connection.prepareStatement("select cart_id, total_products,added_products,purchased_products from cart where customer_id=?");
			pstmt.setInt(1, userID);
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
			int temp=pstmt.executeUpdate();
			if(temp==1){
				
				
				
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
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			response.sendRedirect("CartProduct");
		}
	    
		

	}
	   
	   
	   }
	}

}
