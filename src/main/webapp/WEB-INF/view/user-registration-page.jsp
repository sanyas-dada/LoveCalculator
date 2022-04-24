<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegPage</title>

<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

</head>
<body>
	<h1 align="center">Please register here</h1>
	<div align="center">
		<form:form action="registration-success" method="GET"
			modelAttribute="userReg">

			<label>Name:</label>
			<form:input path="name" />
			<form:errors path="name" cssClass="errors" />
			<br />

			<label>User Name: </label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="errors" />
			<br />

			<label>Password: </label>
			<form:password path="password" />
			<br />

			<label>Country:</label>
			<form:select path="countryName">
				<form:option value="Ind">India</form:option>
				<form:option value="Usa">United States</form:option>
				<form:option value="nep">Nepal</form:option>
				<form:option value="chi">China</form:option>

			</form:select>
			<br />
			<label>Hobbies :</label>
		Reading: <form:checkbox path="hobbies" value="reading" />
		Writing: <form:checkbox path="hobbies" value="writing" />
		Coding: <form:checkbox path="hobbies" value="coding" />
		Travel: <form:checkbox path="hobbies" value="travel" />
		Programming: <form:checkbox path="hobbies" value="programming" />

			<br />

			<label>Gender:</label>
			<form:radiobutton path="gender" value="male" />Male
		<form:radiobutton path="gender" value="female" />Female
		<br />
			<label>Age</label>
			<form:input path="age" />
			<form:errors path="age" cssClass="errors" />

			<div align="center">
				<h3>Communication</h3>
				<label>Email</label>
				<form:input path="communicationDTO.email" />
				<form:errors path="communicationDTO.email" cssClass="errors" />
				<br /> <label>Phone</label>
				<form:input path="communicationDTO.phone" />
			</div>


			<input type="submit" value="register">


		</form:form>
	</div>

</body>
</html>