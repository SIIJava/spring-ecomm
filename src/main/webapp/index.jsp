<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ecommocom Index</title>
</head>
<body>
	Bienvenue 

	<sec:authorize access="isAnonymous()">
		<form action="/login">
			<input type="submit" value="Connexion"></input>
		</form>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">Bonjour <sec:authentication property="principal.username" /></sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<form action="/users">
			<input type="submit" value="Liste des utilisateurs"></input>
		</form>
			<form action="/user/create">
			<input type="submit" value="Nouvel utilisateur"></input>
		</form>
			
	</sec:authorize>
</body>
</html>