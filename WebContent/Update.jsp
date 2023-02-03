<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h3>${message}</h3> <br>
<form action = "update" method ="post">  
Email id :  <input type="text"  name="email" required/> <br> <br>
Name :<input type="text" name="name" required /> <br> <br>   
father's name :  <input type="text"  name="fathername"  required/> <br> <br>
Phone Number :<input type="text" name="phno" required /> <br> <br>  
Date Of Birth : <input type ="date" name= "dob" required/> <br>
hobbies : <input type = "text" name = "hobbies" required/><br> <br>
<input type="submit"/> </form>
</body>
</html>