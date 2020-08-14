<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booking information</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	<%@include file="/resources/style.css" %>
</style>

</head>

<body>
	<div id="page-container">
		<div id="content-wrap">

			<nav class="navbar navbar-inverse">
			<div class="container-fluid" id="surface">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<a id="acolor" class="navbar-brand" href="#">GG Game Cafe</a>

				</div>
				<div>

					<ul class="nav navbar-nav navbar-right">

						<li><a id="acolor" href="/GameCafe/"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					</ul>

				</div>
			</div>
			</nav>

			<div align="center">
				<br>
				<h1>${customerName}'sBookings</h1>
				<br>
			</div>

			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-sm-1 sidenav"></div>
					<div class="col-sm-10 text-center" id="colback">

						<!-- W3 school responsive table. Reference - https://www.w3schools.com/howto/howto_css_table_responsive.asp -->
						<div align="center" style="overflow-x: auto;">

							<div align="center">
								<button
									onclick="location.href='/GameCafe/newBooking?id=${customerId}';">New
									Booking</button>
							</div>
							<br>
							<table>
								<tr>

									<th>Date</th>
									<th>Day Period</th>
									<th>Booking Id</th>
									<th>Food Service</th>
									<th>Booking Fee</th>
									<th>Options</th>
								</tr>
								<c:forEach var="bookingInformation"
									items="${customerAllBookings}" varStatus="status">
									<tr>

										<td class="text-center">${bookingInformation.date}</td>
										<td class="text-center">${bookingInformation.period}</td>
										<td class="text-center">${bookingInformation.bookingId}</td>
										<td class="text-center">${bookingInformation.foodService}</td>
										<td class="text-center">${bookingInformation.bookingFee}</td>
										<td><a class="link"
											href="/GameCafe/deleteBooking?id=${bookingInformation.bookingId}&customerId=${customerId}">Delete
												Booking</a></td>

									</tr>
								</c:forEach>
							</table>
						</div>
						<br>
						<p>*Remember that Afternoon bookings are from 12h to 17h and
							Night bookings from 17h to 22h! :)</p>
					</div>

				</div>
				<div class="col-sm-1 sidenav"></div>
			</div>
			<br>
		</div>

		<footer id="footer">
		<p class="text-center" id="p2">© Copyright 2020 GG Game Cafe</p>
		</footer>

	</div>

</body>
</html>
