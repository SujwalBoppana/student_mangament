<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<h2>${message}</h2>
<form action = "delete" method ="post">  
Email id :<input type="text" name = "email" required/><br> <br>
<input type="hidden" name = "type" value ="delete">
<input type ="submit">
</form>
</body>
</html>