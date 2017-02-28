<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<form action="/login">
			<input type="submit" value="Connexion" class="btn btn-success"></input>
		</form>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">Bonjour <sec:authentication
			property="principal.username" />
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<form action="/users">
			<input type="submit" value="Liste des utilisateurs"
				class="btn btn-info"></input>
		</form>
		<form action="/user/create">
			<input type="submit" value="Nouvel utilisateur" class="btn btn-info"></input>
		</form>

	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form action="/logout" method="post">
			<input type="submit" class="btn btn-warning" value="Déconnexion">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</sec:authorize>
</body>
</html>