package com.sdzee.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

public class Logout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/javabase", "root", "secret");
			// Do something with the Connection
			System.out.println("Connected");
			String query = ("SELECT * FROM User");
			try {
				ResultSet rs;
				java.sql.Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println("Username : " + rs.getString("nom"));
					System.out.println("Password : " + rs.getString("password"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ResultSet rs = stmt.executeQuery(query);
			// System.out.println(rs);

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String paramAuteur = request.getParameter("auteur");
		String message = "Transmission de variables : OK ! " + paramAuteur;
		request.setAttribute("test", message);
		request.setAttribute("test", message);

		this.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
	}

}