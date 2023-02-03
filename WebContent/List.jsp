<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<h2>${message}</h2>
	<c:forEach items="${details}" var="listOfStudents">
		<p>Name: ${listOfStudents.name}, Phone: ${listOfStudents.phno},
			Email: ${listOfStudents.email}, DOB: ${listOfStudents.date_of_birth},
			father's name: ${listOfStudents.fathers_name} ,Hobbies :
			${listOfStudents.hobbies}</p>
	</c:forEach>
	<form action="getall" method="post">
		Get all data <input type="submit">
	</form>
</body>
</html>