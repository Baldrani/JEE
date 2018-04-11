<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="header.jsp" %>
    <body>
    	<%@ include file="navbar.jsp" %>
    	<div class="container">
    		<div class="row">
    			<div class="col-xs-12">
    				<form method="post" action="login">
    					<div class="form-group">
    						<legend>Connexion</legend>
			
			                <label for="name">Nom d'utilisateur</label>
			                <input type="text" id="name" name="name" value="" size="20" maxlength="20" class="form-control"/>
			                <br />
			
			                <label for="password">Mot de passe <span class="requis">*</span></label>
			                <input type="password" id="password" name="password" value="" size="20" maxlength="60" class="form-control"/>
			                <br />
			
			                <input type="submit" value="Connexion" class="btn btn-primary"/>
			                <br />
    					</div>
			        </form>
    			</div>
    		</div>
    	</div>
    </body>
</html>