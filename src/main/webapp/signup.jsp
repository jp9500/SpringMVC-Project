<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
	
	<form:form >
	
		NAME<form:input path="employeeName"/>
		SALARY<form:input path="employeeSalary"/>
		CONTACT<form:input path="employeeContact"/>
		EMAIL<form:input path="employeeEmail"/>
		PASSWORD<form:input path="password"/>
		
		<input type="submit">
		
	</form:form>
	
</body>
</html>