package com.sdzee.servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

public class Login extends HttpServlet {

    public static final String VUE = "/WEB-INF/login.jsp";
    public static final String CHAMP_NAME = "name";
    public static final String CHAMP_PASS = "password";
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		HttpSession session = request.getSession();
    	if(session.getAttribute("name") != null) {
    		//If not null
    		String name = session.getAttribute("name").toString();
    		request.setAttribute( "name", name );
    		response.sendRedirect("/Jee/loggedin");
    	} else {
    		System.out.println("Not connected");
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
    	}
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
        String DBHOST = null;
        String DBPORT = null;
        String DBNAME = null;
        String DBUSER = null;
        String DBPWD = null;
    	
    	Context env;
		try {
			env = (Context)new InitialContext().lookup("java:comp/env");
			try {
		        DBHOST = (String)env.lookup("BDD-HOST");
		        DBPORT = (String)env.lookup("BDD-PORT");
		        DBNAME = (String)env.lookup("BDD-NAME");
		        DBUSER = (String)env.lookup("BDD-USER");
		        DBPWD = (String)env.lookup("BDD-PWD");
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	System.out.println();
    	
		HttpSession session = request.getSession();
		
        String name = request.getParameter( CHAMP_NAME );
        String password = request.getParameter( CHAMP_PASS );
        
		Connection connection = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+DBHOST+":"+DBPORT+"/"+DBNAME+"", DBUSER, DBPWD);
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
		
        String query = "SELECT * FROM User WHERE name = '" + name +"' ";
        try {
			ResultSet resultat = statement.executeQuery(query);
			resultat = statement.executeQuery(query); 
			while (resultat.next()) {
				if( resultat.getString("password").equals(password.toString()) ) {
					session.setAttribute("connected", true);
					session.setAttribute("name", resultat.getString("name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	if(session.getAttribute("name") != null) {
    		request.setAttribute( "name", name );
    		response.sendRedirect("/Jee/loggedin");
    	} else {
    	    response.sendRedirect("/Jee/login");
    	}
        
    }
}