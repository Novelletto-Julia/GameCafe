<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Home</title>

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

						<li class="active"><a id="acolor" href="/GameCafe/">Home</a></li>
						<li><a id="acolor" href="/GameCafe/itemsMenu">Menu</a></li>

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
			<!-- W3Schools Bootstrap carousel tutorial - https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_marketing&stacked=h -->
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<!-- Photo Reference Game Haus Cafe- https://geekandsundry.com/table-top-day/retailers/game-haus-cafe/?utm_source=pinterest&utm_medium=social / https://gamehauscafe.com/ -->
						<img
							src="https://geekandsundry.com/wp-content/uploads/2016/02/unspecified-1191.jpg"
							alt="Image">
						<div class="carousel-caption"></div>
					</div>

					<div class="item">
						<!-- Photo Reference Game Haus Cafe - https://geekandsundry.com/table-top-day/retailers/game-haus-cafe/?utm_source=pinterest&utm_medium=social / https://gamehauscafe.com/ -->
						<img
							src="https://geekandsundry.com/wp-content/uploads/2016/02/unspecified191.jpg"
							alt="Image">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>


			<div class="container text-center">
				<h1>Welcome to GG Game Cafe</h1>
				<br>

				<div class="row">
					<div class="col-sm-12" id="colback">
						<h2>Who we are</h2>
						<p>Lorem ipsum dolor sit amet, saepe constituam te pri, eos ea
							homero voluptatum. Te vis nibh decore scaevola, id eam soluta
							recteque, veritus epicurei id qui. Et ius diam labore euismod,
							pro ne nusquam noluisse. Eu nam option labitur invidunt, ad
							homero tractatos sit. Vidisse praesent aliquando eam ut, modus
							antiopam te eum. An solet tantas eum, eos ne stet debitis, per ad
							diam quodsi. Fastidii deserunt ex sit. Quod aperiri percipitur ne
							mei, sit in aliquip aliquando persequeris, duo an inani saperet.
							Perfecto persecuti pri ei. Mea iudico ocurreret et, cu novum
							intellegam disputationi quo, ius ut consul vivendum. Dicit
							definitionem id his, ius bonorum accusamus id. Id nobis dicam
							consul vix, ex usu aeque aliquando consetetur. Nibh aliquam
							efficiantur qui ad, et dictas cetero convenire quo, iudicabit
							consectetuer usu at. At nam nulla inciderint. Et eum gubergren
							sadipscing, vide suscipit eum ne, sea doming diceret alienum eu.
							Detracto posidonium liberavisse usu no, vituperata definitiones
							sit ut, mea ne tantas exerci impedit. Alii mandamus pro ad. Eos
							graeci platonem ad, malorum scriptorem mea at. Cu sint option
							mei, sit at possim sapientem intellegat. Et nec cibo ornatus. Eu
							per postea diceret definiebas. Quodsi sensibus appellantur est
							at. Eum at omnis expetendis adversarium, et suscipit sapientem
							vim. Cum et suas voluptatibus, eos justo utinam urbanitas ut, an
							sed quod saepe. Quod vocent eam eu. Deserunt scriptorem cu vix.
							Pro ad iudicabit mnesarchum. Malis gloriatur eos ex, eu his
							tamquam referrentur, at ius sanctus erroribus conceptam. Id quo
							veri veniam expetendis.</p>
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
