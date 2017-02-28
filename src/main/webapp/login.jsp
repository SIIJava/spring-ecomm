<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form role="form" action="/login" method="post">
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
    <div>
        <label for="username">Username</label>
        <input type="username" name="username" id="username" required autofocus>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me">
    </div>
    <button type="submit">Sign in</button>
</form>


</body>
</html>