<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel="stylesheet" href="resources/css/index.css">
<link rel='stylesheet'
	href='webjars/font-awesome/4.7.0/css/font-awesome.css'>
</head>






<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
	role="banner" style="width:auto; margin: auto;">
<div class="container">
	<div class="navbar-header">
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			data-target=".bs-navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="./" class="navbar-brand"><i class="fa fa-home"></i>Ecommocom</a>
	</div>
	<nav class="collapse navbar-collapse bs-navbar-collapse"
		role="navigation">
	<ul class="nav navbar-nav">
	
		<li class="dropdown mega-dropdown" style="width:auto">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nos produits en vente<span class="glyphicon glyphicon-chevron-down pull-right"></span></a>

          <ul class="dropdown-menu mega-dropdown-menu row" style="width:80%; margin:auto">               
                <li >ici les selecteurs </li>
                <li><a href="#">Voir tous les prouits <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
          </ul>

        </li>
	
		<li><a href="#">Nos produits en location</a></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown">Dropdown <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#">Action</a></li>
				<li><a href="#">Another action</a></li>
				<li><a href="#">Something else here</a></li>
				<li><a href="#">Separated link</a></li>
				<li><a href="#">One more separated link</a></li>
			</ul></li>
		<li><a href="#">Components</a></li>
		<sec:authorize access="isAnonymous()">
			<li><a href="/login">Connexion</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		<li>
		</li>
			<li ><a href="#" class="deconnexion">Déconnexion</a></li>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<li class="active"><a href="#">Inscription</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li>
		<form action="/users">
			<input type="submit" value="Liste des utilisateurs"
				class="btn btn-info"></input>
		</form>
		<form action="/user/create">
			<input type="submit" value="Nouvel utilisateur" class="btn btn-info"></input>
		</form>
		<form action="/produit/create">
			<input type="submit" value="Nouveau produit" class="btn btn-info"></input>
		</form>
		</li>

	</sec:authorize>
	</ul>
	</nav>
</div>
</header>
<body>





<%-- 
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
		<form action="/produit/create">
			<input type="submit" value="Nouveau produit" class="btn btn-info"></input>
		</form>

	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form id="logout-form" action="/logout" method="post">
			<input type="submit" class="btn btn-warning" value="Déconnexion">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</sec:authorize> --%>

	<script type="text/javascript" src="webjars/jquery/3.1.1/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	jQuery(document).on('click', '.mega-dropdown', function(e) {
		  e.stopPropagation()
		});
	
	$('.deconnexion').click(function(){
		console.log("deco");
		$('#logout-form').submit();
	});
		</script>
</body>
</html>