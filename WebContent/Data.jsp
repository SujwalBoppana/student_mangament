<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>
<body>
<%@ page import="de.zeroco.pojo.Student"%>
<% Student student = (Student)request.getAttribute("data");
System.out.println(student.toString());
String hobbies = "";
for (String hobbi : student.getHobbies()) {
	hobbies += "," + hobbi;
}
%>
<h3>${message}</h3> <br>
<form action="update" method="post">
Email id :  <input type="text" value ="<%=student.getEmail() %>" name="email" /> <br> <br>
Name : <input type = "text" value = "<%=student.getName() %>" name = "name">
father's name :  <input type="text"  value = "<%=student.getFatherName()%>"name="fathername"  > <br> <br>
Phone Number :<input type="text" value = "<%=student.getPhno() %>" name="phno"  /> <br> <br>  
Date Of Birth : <input type ="date" value = "<%=student.getDob() %>" name= "dob" /> <br>
hobbies : <input type = "text" value = "<%=hobbies.substring(1) %> " name = "hobbies" /><br> <br>
<input type="submit">
</form>

</body>
</html>