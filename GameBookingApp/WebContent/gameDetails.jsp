<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game app</title>
</head>
<body>
		<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
		<h2>List Of Games</h2>
		<table border="1">
			<tr>
				<td>Game Name</td>
				<td>Location</td>
				<td>Date</td>
				<td>Price</td>
				<td>Available no of games</td>
				<td>Book</td>
			</tr>
			
			<s:forEach var="game" items="${gameList}">
				<tr>
					<td>${game.gameName}</td>
					<td>${game.location}</td>
					<td>${game.gameDate}</td>
					<td>${game.priceTicket}</td>
					<td>${game.avSeats}</td>
					<s:choose>
						<s:when test="${game.avSeats > 0}">
							<td><a href="./getGameDetails?gameId=${game.gameId}">Book</a></td>
						</s:when>
						<s:when test="${game.avSeats == 0}">
							<td><b>Sold</b></td>
						</s:when>
					</s:choose>
				</tr>
			</s:forEach>
		</table>
</body>
</html>