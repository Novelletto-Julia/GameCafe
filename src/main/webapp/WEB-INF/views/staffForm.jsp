<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Staff</title>
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
							href="/GameCafe/staffBookingInformation?id=${staffId}">Booking
								List</a></li>
						<li><a id="acolor" href="/GameCafe/orders?id=${staffId}">Orders</a></li>
						<li class="active"><a id="acolor"
							href="/GameCafe/staffList?id=${staffId}">Staff List</a></li>

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
				<h1>Add new member to staff</h1>
				<br>
			</div>
			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-sm-2 sidenav">
					</div>
					<div class="col-sm-8 text-center" id="colback">


						<form:form action="saveStaff" method="post" modelAttribute="staff"
							id="registerForm">

							<form:hidden path="id" />

							<label for="firstName">First Name:</label>
							<input type="text" id="firstName" name="firstName">
							<br>
							<br>

							<label for="surname">Surname:</label>
							<input type="text" id="surname" name="surname">
							<br>
							<br>

							<label for="email">E-mail address:</label>
							<input type="email" id="email" name="email">
							<br>
							<br>

							<label for="phone">Phone Number:</label>
							<input type="number" id="phone" name="phone">
							<br>
							<br>

							<label for="jobTitle">Job Title:</label>
							<input type="text" id="jobTitle" name="jobTitle">
							<br>
							<br>

							<label for="username">Username:</label>
							<input type="text" id="username" name="username">
							<br>
							<br>

							<label for="password">Password:</label>
							<input type="password" id="password" name="password">
							<br>
							<br>

							<label for="birthDate">Birth Date:</label>
							<input type="date" id="birthDate" name="birthDate">
							<br>
							<br>

							<label for="hireDate">Hire date:</label>
							<input type="date" id="hireDate" name="hireDate">
							<br>
							<br>

							<label for="address">Address:</label>
							<input type="text" id="address" name="address">
							<br>
							<br>

							<label for="eircode">Eircode:</label>
							<input type="text" id="eircode" name="eircode">
							<br>
							<br>


						</form:form>
						<button type="submit" form="registerForm" value="Save">Register new staff</button>

					<div class="col-sm-2 sidenav"></div>
				</div>
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
