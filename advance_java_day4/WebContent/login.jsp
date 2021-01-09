<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Employee Login Form</h2>
<form action="login" action="post">
<input type="hidden" name="requestAction" value="login" />
<table>
<tr>
	<td>Username</td>
	<td><input type="text" name="user_name" /></td>
</tr>

<tr>
	<td>Password</td>
	<td><input type="text" name="password" /></td>
</tr>
</table>
<input type="submit" value="submit" />
</form>
<h2 style="color:red">
	<%	
		if (null != request.getAttribute("errorMessage")) {
	%>
	<%=request.getAttribute("errorMessage")%>
	<%
		}
	%>
	
</center>
</body>
</html>