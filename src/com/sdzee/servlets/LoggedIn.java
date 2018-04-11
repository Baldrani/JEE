package com.sdzee.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoggedIn", urlPatterns = {"/Jee/loggedin"} )
public class LoggedIn extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
    	if(session.getAttribute("name") == null) {
    		System.out.println("Not connected");
    		response.sendRedirect("/Jee/login");
    	}
		
		List<User> users = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/javabase", "root", "secret");
			// Do something with the Connection
			System.out.println("Connected");
			String query = ("SELECT * FROM User");
			try {
				ResultSet rs;
				java.sql.Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
					
		        while (rs.next()) {
		        	String id = rs.getString("id");
		            String name = rs.getString("name");
		            String password = rs.getString("password");
		            User user = new User(id, name, password);
		            users.add(user);
		            System.out.println(user.toString());
		        }
		        request.setAttribute("users", users);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/loggedin.jsp" ).forward( request, response );
	}
	
}
