<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List of Users</title>
</head>
<body>

	<h1>Liste des produits</h1>

	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Libellé</th>
				<th>Description</th>
				<th>Tarif</th>
				<th>Vente Ou Location</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produits}" var="produit">
				<tr>
					<td>${produit.nomproduit}</td>
					<td>${produit.libelle}</td>
					<td>${produit.description}</td>
					<td>${produit.tarif}</td>
					<td>${produit.venteOuLocation.libelle}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Log out" />
	</form>
</body>
</html>
