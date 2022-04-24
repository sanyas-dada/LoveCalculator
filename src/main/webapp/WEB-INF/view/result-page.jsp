<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Love calculator</h1>
	<hr />
	<h2>The love Calculator Predicts:</h2>
	<br /> ${userInfo.userName} and ${userInfo.crushName} are
	<br />
     ${userInfo.result}
	<br />
	<a href="/LoveCalculatorUsingSpring/sendEmail/">Send Result to Your Email</a>

</body>
</html>