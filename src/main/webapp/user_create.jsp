<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create a new user</title>
<link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel="stylesheet" href="../resources/css/index.css">
</head>
<body>
	<nav role="navigation">
		<ul>
			<li><a href="/">Home</a></li>
		</ul>
	</nav>

	<h1>Create a new user</h1>
	<form role="form" name="form" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		<div>
			<label for="username">Email address</label> <input type="text"
				name="username" id="username" value="${form.username}" required autofocus />
		</div>
		<div>
			<label for="password">Password</label> <input type="password"
				name="password" id="password" required />
		</div>
		<div>
			<label for="passwordRepeated">Repeat</label> <input type="password"
				name="passwordRepeated" id="passwordRepeated" required />
		</div>
		<div>
			<label for="role">Role</label> <select name="role" id="role" required>
					<option value="ROLE_USER">USER</option>
					<option value="ROLE_ADMIN">ADMIN</option>
			
			</select>
		</div>
		<button type="submit">Save</button>
	</form>

	<spring:bind path="form">
		<c:forEach items="${status.errorMessages}" var="error">
        Error code: <c:out value="${error}" />
			<br>
		</c:forEach>
	</spring:bind>

	<script type="text/javascript" src="../webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="../webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>