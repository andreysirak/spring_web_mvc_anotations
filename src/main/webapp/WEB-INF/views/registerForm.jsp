<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Register</h1>

<%--	<form method="POST" >
		First Name: <input type="text" name="firstName" /><br /> 
		Last Name: <input  type="text" name="lastName" /><br /> 
		Username: <input type="text" name="username" /><br /> 
		Password: <input type="password" name="password" /><br /> 
<label>Profile Picture</label>:
<input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
		<input type="submit" value="Register" />
	</form>
--%>
	
<form:form method="POST" commandName="spitter" enctype="multipart/form-data">
First Name: <form:input path="firstName" /> <form:errors path="firstName" cssClass="error" /><br/>
Last Name: <form:input path="lastName" /> <br />
<%-- Email: < form:input path="email" />	<br /> --%>
Username: <form:input path="username" /> <br />
Password: <form:password path="password" />	<br />
<label>Profile Picture</label>:
<input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
<input type="submit" value="Register" />
</form:form>


</body>
</html>