<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Welcome</title>
</head>
<body>
	<h1>[${customer.name}] registered successfully</h1>
	<ul>
		<li>ID: ${customer.id}</li>
		<li>password: ${customer.password}</li>
		<li>gender: ${customer.gender}</li>
		<li>Name: ${customer.name}</li>
		<li>Email: ${customer.email}</li>
	</ul>
	<p>
		<a href="/helloMVC/index.jsp"> go to homepage</a>
	</p>
</body>
</html>