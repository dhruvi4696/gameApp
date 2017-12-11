<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
		<form action="./BookGame">
			<h1>Booking Form</h1>
			<table>
				<tr>
					<td>Game Name :</td>
					<td><input type="text" name="txtGameName" value="${game.gameName}" required></td>
				</tr>
				<tr>
					<td>Price Per single Game :</td>
					<td><input type="text" name="txtPrice" value="${game.priceTicket}" required></td>
				</tr>
				<tr>
					<td>Gamer Name</td>
					<td><input type="text" name="txtCustName" required pattern="[A-Za-z]{3,20}"></td>
				</tr>
				<tr>
					<td>Mobile Number :</td>
					<td><input type="text" name="txtMobNo" required pattern="[7-9][0-9]{9}"></td>
				</tr>
				<tr>
					<td>Games Available :</td>
					<td><input type="text" name="txtGamesAvail" value="${game.avSeats}" required ></td>
				</tr>
				<tr>
					<td>No Of Games to Book : </td>
					<td><input type="text" name="txtGamesBook" required min="1" max="${game.avSeats}"></td>
				</tr>
				
				<tr>
					<td  colspan="2">
						<input type="submit" name="btnSubmit" value="book">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>