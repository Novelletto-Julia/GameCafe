<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Manager Home</title>
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
				<h1>Staff List</h1>
				<br>
			</div>
			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-sm-1 sidenav"></div>
					<div class="col-sm-10 text-center" id="colback">

						<!-- W3 school responsive table. Reference - https://www.w3schools.com/howto/howto_css_table_responsive.asp -->
						<div align="center" style="overflow-x: auto;">
							<div align="center" class="order">

								<h3>
									<a class="link" href="/GameCafe/newStaff?staffId=${staffId}">New
										Staff</a>
								</h3>
								<table>
									<tr>
										<th>Staff Id</th>
										<th>Name</th>
										<th>Surname</th>
										<th>Email</th>
										<th>Phone</th>
										<th>Job Title</th>
										<th>Username</th>
										<th>Password</th>
										<th>Birth Date</th>
										<th>Hire Date</th>
										<th>Address</th>
										<th>Administrate</th>
									</tr>
									<c:forEach var="staff" items="${listStaff}" varStatus="status">
										<tr>
											<td>${staff.id}</td>
											<td>${staff.firstName}</td>
											<td>${staff.surname}</td>
											<td>${staff.email}</td>
											<td>${staff.phone}</td>
											<td>${staff.jobTitle}</td>
											<td>${staff.username}</td>
											<td>${staff.password}</td>
											<td>${staff.birthDate}</td>
											<td>${staff.hireDate}</td>
											<td>${staff.addressId}</td>
											<td><a class="link"
												href="/GameCafe/editStaff?id=${staff.id}">Edit</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a class="link"
												href="/GameCafe/deleteStaff?id=${staff.id}">Delete</a></td>

										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-1 sidenav "></div>
			</div>
			<br>

		</div>

		<footer id="footer">
		<p class="text-center" id="p2">© Copyright 2020 GG Game Cafe</p>
		</footer>

	</div>

</body>
</html>
