<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Game is Booked , below are the details :</h2>
		
		<table>
			<tr>
				<td>Game Name : </td>
				<td>${gamename}</td>
			</tr>
			<tr>
				<td>Gamer Name : </td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Mobile Number : </td>
				<td>${mobileNo}</td>
			</tr>
			<tr>
				<td>No Of Games :</td>
				<td>${noOfGames}</td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td>${totalPrice}</td>
			</tr>
		</table>
		
		<a href="index.jsp">Go Back To Home</a>
</body>
</html>