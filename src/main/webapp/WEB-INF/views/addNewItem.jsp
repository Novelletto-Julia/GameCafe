<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit order line</title>
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
						<li class="active"><a id="acolor"
							href="/GameCafe/orders?id=${staffId}">Orders</a></li>
						<li><a id="acolor" href="/GameCafe/staffList?id=${staffId}">Staff
								List</a></li>

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
				<h1>Add a new item to the Order</h1>
				<br>
				<div class="container-fluid text-center">
					<div class="row">
						<div class="col-sm-2 sidenav"></div>
						<div class="col-sm-8 text-center order" id="colback">

							<form:form action="saveOrderLine" method="post"
								modelAttribute="orderLine" id="newItem">

								<form:hidden path="orderId" />
								<form:hidden path="staffId" />

								<label for="items">Items:</label>
								<!-- Name is the java variable for the database attribute -->
								<select name="itemId" id="items">
									<option><b>ITEMS</b></option>
									<option></option>

									<option><b>Food</b></option>
									<option value="4" selected>Cheese Cake</option>
									<option value="9">Cake</option>
									<option value="10">French Toast</option>
									<option value="11">Cookie</option>
									<option></option>

									<option><b>Drink</b></option>
									<option value="1">Tea</option>
									<option value="3">Coke</option>
									<option value="6">Cappuccino</option>
									<option value="7">Latte</option>
									<option value="8">Mocca</option>
									<option></option>

									<option><b>GAMES</b></option>
									<option value="5">DOOM</option>
									<option value="12">Chess</option>
									<option value="13">Cards Against Humanity</option>
									<option value="14">Pandemic</option>
									<option value="15">SCYTHE</option>
									<option value="16">Dark Souls</option>
									<option value="17">DIXIT</option>
									<option value="18">Catan</option>
									<option value="19">Arkham Horror</option>
									<option value="20">Elder Sign</option>
									<option value="21">Eldritch Horror</option>

								</select>
								<br>
								<br>

								<label for="quantity">Quantity:</label>
								<input type="number" id="quantity" name="quantity">


							</form:form>
							<br>
							<button type="submit" form="newItem" value="Submit">Add
								new item</button>
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
