package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

public class Delete  extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
    	if(session.getAttribute("name") == null) {
    		System.out.println("Not connected");
    		response.sendRedirect("/Jee/login");
    	} else {
    		Connection connection = null;
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			connection = DriverManager.getConnection("jdbc:mysql://localhost:1234/javabase", "root", "secret");
    		} catch (SQLException | ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            Statement statement = null;
            
    		try {
    			statement = connection.createStatement();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		String id = request.getParameter("id");
    		
            String query = "DELETE FROM User WHERE id = '" + id +"' ";
            try {
    			statement.executeUpdate(query); 
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
        	response.sendRedirect("/Jee/loggedin");	
    	}
    
	}
}