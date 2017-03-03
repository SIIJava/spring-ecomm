<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create a new product</title>
<link rel='stylesheet'
	href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

</head>
<body>
	<nav role="navigation">
		<ul>
			<li><a href="/">Home</a></li>
		</ul>
	</nav>
	<button type="button" class="btn btn-primary">Primary</button>

	<h1>Nouveau produit</h1>
	<form role="form" name="form" action="" method="post">
		<div class="form-group">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</div>
		<div class="form-group">
			<label for="nomproduit">Nom du produit</label> <input type="text"
				class="form-control" name="nomproduit" id="nomproduit"
				value="${form.nomproduit}" required autofocus />
		</div>
		<div class="form-group">
			<label for="libelle">Libellé</label> <input type="text"
				class="form-control" name="libelle" id="libelle" required />
		</div>
		<div class="form-group">
			<label for="description">Description du produit</label> <input
				class="form-control" type="text" name="description" id="description"
				required />
		</div>
		<div class="form-group">
			<label for="tarif">Tarif</label> <input name="tarif" id="tarif"
				class="form-control" type="number" step=0.01 required />
		</div>
		<div class="form-group">
			<label for="venteOuLocation">Vente ou Location</label>
			<label class="radio-inline"><input type="radio" name="venteOuLocation" value="1">Vente</label> 
			<label class="radio-inline"><input type="radio"	name="venteOuLocation" value="2">Location</label> 
		</div>
		<button type="submit" class="btn btn-primary">Save</button>
	</form>

	<spring:bind path="form">
		<c:forEach items="${status.errorMessages}" var="error">
        Error code: <c:out value="${error}" />
			<br>
		</c:forEach>
	</spring:bind>



	<sec:authorize access="isAuthenticated()">
		<form action="/logout" method="post">
			<input type="submit" class="btn btn-warning" value="Déconnexion">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</sec:authorize>

	<script type="text/javascript"
		src="../webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="../webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
