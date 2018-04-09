package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

    public static final String VUE = "/WEB-INF/login.jsp";
    public static final String CHAMP_NAME = "name";
    public static final String CHAMP_PASS = "password";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        String nom = request.getParameter( CHAMP_NAME );
        String motDePasse = request.getParameter( CHAMP_PASS );
    }
}