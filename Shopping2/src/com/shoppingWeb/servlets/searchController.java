package com.shoppingWeb.servlets;

import java.io.IOException;
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

import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.POJO.SearchCategory;
import com.shoppingWeb.POJO.SearchCategoryAbove;
import com.shoppingWeb.POJO.SearchCategoryUnder;
import com.shoppingWeb.POJO.SearchProduct;
import com.shoppingWeb.connectDB.ConnectDb;
import javax.servlet.http.HttpSession;

@WebServlet("/searchController")
public class searchController extends HttpServlet {
	
    public String[] converter(String[] word){
      int s =0;
      int t =0;
        for(s=0 ;s<word.length;s++){
            word[s] = word[s].toLowerCase();
            if(word[s].equalsIgnoreCase("men")|| word[s].equalsIgnoreCase("man")){
               t = s+1;
              word[s] = "men_" + word[s+1];
             word[s+1] = "";
              System.out.println(word[s]);
        }
        }
        if(t == 0 ){
        for(s=0 ;s<word.length;s++){
            word[s] = word[s].toLowerCase();
            if(word[s].equalsIgnoreCase("women")|| word[s].equalsIgnoreCase("woman")){
                word[s] = "women_" + word[s+1];
               word[s+1] = "";
               t=s+1;
              System.out.println(word[s]); 
        }
        }
        }
        if(t == 0 ){
            for(s=0 ;s<word.length;s++){
                word[s] = word[s].toLowerCase();
                if(word[s].equalsIgnoreCase("women")|| word[s].equalsIgnoreCase("woman")){
                    word[s] = "women_" + word[s+1];
                   word[s+1] = "";
                   t=s+1;
                  System.out.println(word[s]); 
            }
            }
            }
            
        return word;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
                int i = 0;
                HttpSession session = request.getSession(false);
                if(session.getAttribute("UserId")==null){                   // session Attribute Added
                    HashSet List=(HashSet)session.getAttribute("list");
                    session.setAttribute("ProductNo", List);
                   
                   }
                   else{                                                           //Login Attribute Added
                   	  int userID=(Integer)session.getAttribute("UserId");
                   		session.setAttribute("UserId", userID);
                   		
                   }
                
                
	String TextSearch = request.getParameter("textSearch");
	String[] word =  TextSearch.split(" ");
        String[] words = converter(word);
	Connection con =  null;
	ResultSet rs = null;
	for(String s : words){
		if(s.equalsIgnoreCase("under")){
			ArrayList<ProductDTO> a_under = SearchCategoryUnder.search_acc_price_under(words);
			for(ProductDTO pd : a_under){
				System.out.println(pd.getId() + pd.getName());
			}
                       if(a_under != null){
                           System.out.println("hii , i'm under set"); 
                           session.setAttribute("list2", a_under);
                            
                       }
                        i++;
                }
		else if(s.equalsIgnoreCase("above")){
			ArrayList<ProductDTO> a_above = SearchCategoryAbove.search_acc_price_above(words);
			for(ProductDTO pd : a_above){
				System.out.println(pd.getId() + pd.getName());
			}
                      if(a_above != null){
                          
                          System.out.println("hii , i'm above set");
                            session.setAttribute("list2", a_above);
                }
                        i++;
			//response.sendRedirect("trail.html");
		}
	}
        int flag = 0;
        if(i == 0){
	ArrayList<ProductDTO>  a = null;
        a = SearchCategory.search_cat(words);
	for(ProductDTO pd : a){
		System.out.println(pd.getId() + pd.getName());
	}
	if(a!= null){
            flag++;
            System.out.println("hii , i'm category set");
            session.setAttribute("list2", a);
        }
        if(flag == 0){
        ArrayList<ProductDTO> a2 = null;
	a2 = SearchProduct.search_pro(words);
	for(ProductDTO pd : a2){
		System.out.println(pd.getId() + pd.getName() + pd.getImg_path() + pd.getPrice());
	}
      if(a2 != null){
                System.out.println("hii , i'm product set");
            session.setAttribute("list2", a2);
      }
        }
        }
	response.sendRedirect("product.jsp");	
	}
	

}
