<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Booking</title>
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
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav myUl">

						<li><a id="acolor"
							href="/GameCafe/customerBookingInformation?id=${customerId}">Booking
								information</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">

						<li><a id="acolor" href="/GameCafe/"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					</ul>

				</div>
			</div>
			</nav>


			<div align="center">
				<br>
				<h1>New Booking</h1>
				<br>
				<div class="container-fluid text-center">
					<div class="row">
						<div class="col-sm-2 sidenav"></div>
						<div class="col-sm-8 text-center order" id="colback">


							<form:form action="createBooking" method="post"
								modelAttribute="newBooking" id="newBooking">
								<form:hidden path="customerId" />


								<label for="foodService">Would you like food service?</label>
								<br>
								<label for="Yes">Yes</label>
								<input type="radio" name="foodService" id="Yes" value="Y">
								<br>
								<label for="No">No</label>
								<input type="radio" name="foodService" id="No" value="N">
								<br>

								<br>

								<label for="date">Pick up a date:</label>
								<input type="date" id="date" name="date">
								<br>
								<label for="date">(Please,keep in mind that the Game
									Cafe is closed on Mondays!)</label>
								<br>


								<br>
								<label for="dayPeriod">Which period would like to book?</label>
								<br>
								<label for="Afternoon">Afternoon</label>
								<input type="radio" name="dayPeriod" id="Afternoon" value="A">
								<br>
								<label for="Night">Night</label>
								<input type="radio" name="dayPeriod" id="Night" value="N">
								<br>

								<label for="numPeople">How many people in your party?</label>
								<br>
								<label for="4">4 People</label>
								<input type="radio" name="numPeople" id="4" value="4">
								<br>
								<label for="6">6 People</label>
								<input type="radio" name="numPeople" id="6" value="6">
								<br>
								<label for="10">10 People</label>
								<input type="radio" name="numPeople" id="10" value="10">
								<br>




							</form:form>
							<br>
							<button type="submit" form="newBooking" value="Submit">Create
								Booking</button>
						</div>
					</div>
					<br>

					<div class="col-sm-2 sidenav"></div>
				</div>
			</div>

			<br>

		</div>

		<footer id="footer">
		<p class="text-center" id="p2">© Copyright 2020 GG Game Cafe</p>
		</footer>

	</div>
</body>
</html>
