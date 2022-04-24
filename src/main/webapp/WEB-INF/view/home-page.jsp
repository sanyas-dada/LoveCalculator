
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>

<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>




<script type="text/javascript">
	function validateUserName() {
		var userName = document.getElementById("yn").value;
		if (userName.length < 3) {
			alert("Your name should be at least one character");
			return false;
		} else {
			return true;
		}

	}
</script>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr />
	<form:form action="process-homepage" method="get"
		modelAttribute="userInfo" onsubmit="return validateUserName()">
		<div align="center">
			<p>
				<label for="yn">Your name:</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="errors" />
			</p>
			<p>
				<label for="cn">Crush name:</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="errors" />

			</p>
			<p>
			  <form:checkbox path="termAndCondition" id="check"/>
			  <label>I am agreeing that this is for fun </label>
			  <form:errors path="termAndCondition" cssClass="errors"/>
			
			</p>

			<p>
				<input type="submit" value="calculate">
			</p>
		</div>
	</form:form>




</body>
</html>