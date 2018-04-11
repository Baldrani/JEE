<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<%@ include file="header.jsp" %>
    <body>
    	<%@ include file="navbar.jsp" %>
    	<div class="container">
    		<div class="row">
    			<div class="col-xs-12">
					<table class="table">
		            <thead>
		                <tr>
		                    <th>Name</th>
		                    <th>Password</th>
		                    <th>Delete</th>
		                </tr>
		            </thead>
		            <tbody>
		            <c:forEach var="user" items="${users}">
		                <tr>
		                    <td><c:out value="${user.name}" /></td>
		                    <td><c:out value="${user.password}" /></td>
		                    <td><a href="/Jee/delete?id=<c:out value="${user.id}" />">Supprimer</a></td>
		                </tr>
		            </c:forEach>
		            </tbody>
		        </table>
    			</div>
    		</div>
    	</div>
    </body>
</html>