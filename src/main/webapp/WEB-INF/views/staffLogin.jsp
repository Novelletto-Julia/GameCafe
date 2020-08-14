<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
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

						<li><a id="acolor" href="/GameCafe/">Home</a></li>
						<li><a id="acolor" href="/GameCafe/itemsMenu">Menu</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">

						<li><a id="acolor" href="/GameCafe/register"><span
								class="glyphicon glyphicon-user"></span> Register</a></li>

						<li class="dropdown active"><a id="acolor"
							class="dropdown-toggle" data-toggle="dropdown" href="#"><span
								class="glyphicon glyphicon-log-in"></span> Login</a>
							<ul class="dropdown-menu">

								<li><a id="acolor" href="/GameCafe/customerLogin">Customer</a></li>
								<li><a id="acolor" href="/GameCafe/staffLogin">Staff</a></li>

							</ul></li>
					</ul>

				</div>
			</div>
			</nav>


			<div align="center">
				<br>
				<h1>STAFF AREA</h1>
				<br>
				<div class="container-fluid text-center">
					<div class="row">
						<div class="col-sm-2 sidenav"></div>
						<div class="col-sm-8 text-center login" id="colback">

							<h1>Login</h1>
							<br>

							<form:form action="loginStaff" method="post"
								modelAttribute="staffLogin" id="staffLogin">

								<label for="username">Username:</label>
								<input type="text" id="username" name="username">
								<br>
								<br>

								<label for="password">Password:</label>
								<input type="password" id="password" name="password">
								<br>
								<br>

							</form:form>

							<button type="submit" form="staffLogin" value="Login">Login</button>
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