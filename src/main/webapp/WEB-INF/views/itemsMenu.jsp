<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Menu</title>

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
						<li class="active"><a id="acolor" href="/GameCafe/itemsMenu">Menu</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">

						<li><a id="acolor" href="/GameCafe/register"><span
								class="glyphicon glyphicon-user"></span> Register</a></li>

						<li class="dropdown"><a id="acolor" class="dropdown-toggle"
							data-toggle="dropdown" href="#"><span
								class="glyphicon glyphicon-log-in"></span> Login</a>
							<ul class="dropdown-menu">

								<li><a id="acolor" href="/GameCafe/customerLogin">Customer</a></li>
								<li><a id="acolor" href="/GameCafe/staffLogin">Staff</a></li>

							</ul></li>
					</ul>

				</div>
			</div>
			</nav>

			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-sm-2 sidenav"></div>
					<div class="col-sm-8 text-center" id="colback">

						<h1>Items Menu</h1>
						<br>
						<!-- Image from Geek for the Win. Reference - https://geekforthewin.com/horror-board-games/  -->
						<img id="img"
							src="https://geekforthewin.com/wp-content/uploads/2019/10/machina-arcana-game.webp"
							class="img-responsive text-center" style="width: 100%"
							alt="Board game image">

					</div>
					<div class="col-sm-2 sidenav"></div>
				</div>
			</div>

			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-sm-2 sidenav"></div>
					<div class="col-sm-8 text-center" id="colback">

						<div align="center">
							<h1>Food</h1>
							<table>
								<tr>
									<th>Name</th>
									<th>Price</th>
									<th>Avaliability</th>


								</tr>
								<c:forEach var="item" items="${listFood}" varStatus="status">
									<tr>
										<td>${item.name}</td>
										<td>${item.price}&#8364;</td>
										<td class="text-center">${item.avaliability}</td>


									</tr>
								</c:forEach>
							</table>
						</div>

						<div align="center">
							<h1>Drinks</h1>
							<table>
								<tr>

									<th>Name</th>
									<th>Price</th>
									<th>Avaliability</th>

								</tr>
								<c:forEach var="item" items="${listDrinks}" varStatus="status">
									<tr>

										<td>${item.name}</td>
										<td>${item.price}&#8364;</td>
										<td class="text-center">${item.avaliability}</td>

									</tr>
								</c:forEach>
							</table>
						</div>

						<div align="center">
							<h1>Games</h1>
							<table>
								<tr>
									<th>Name</th>
									<th>Price</th>
									<th>Avaliability</th>


								</tr>
								<c:forEach var="item" items="${listGames}" varStatus="status">
									<tr>

										<td>${item.name}</td>
										<td>${item.price}&#8364;</td>
										<td class="text-center">${item.avaliability}</td>

									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				<div class="col-sm-2 sidenav"></div>
			</div>
			<br>

		</div>

		<footer id="footer">
		<p class="text-center" id="p2">© Copyright 2020 GG Game Cafe</p>
		</footer>

	</div>
</body>
</html>
