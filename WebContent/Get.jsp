<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<h2>${message}</h2>
<c:forEach items="${details}" var="studentDetails">
		<p>Name: ${studentDetails.name}, Phone: ${studentDetails.phno}, Email:
			${studentDetails.email}, DOB: ${studentDetails.date_of_birth},
			father's name: ${studentDetails.fathers_name} ,Hobbies : ${studentDetails.hobbies}</p>
	</c:forEach>

<form action = "getdata" method ="post">  
Email_id :<input type="text" name = "email" required/><br> <br>
<input type ="submit">
</form>

</body>
</html>