<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<!-- @author vaibhav kulkarni. reference (https://stackoverflow.com/questions/18191893/generate-pdf-from-html-in-div-using-javascript/33890644#33890644) -->
<script type="text/javascript">
        $("#btnPrint").live("click", function () {
            var divContents = $("#dvContainer").html();
            var printWindow = window.open('', '', 'height=400,width=800');
            printWindow.document.write('<html><head><title> Customer Invoice</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        });
    </script>

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
				<h1>Bill</h1>
				<br>

				<div class="container-fluid text-center">
					<div class="row">
						<div class="col-sm-2 sidenav"></div>

						<div class="col-sm-8 text-center" id="colback">
							<div id="dvContainer">
								<!-- W3 school responsive table. Reference - https://www.w3schools.com/howto/howto_css_table_responsive.asp -->
								<div align="center" style="overflow-x: auto;">
									<div align="center" class="order">
										<form id="form1">

											<table>
												<tr>
													<th>item id</th>
													<th>Name</th>
													<th>quantity</th>
													<th>Unitary price</th>

												</tr>
												<c:forEach var="bill" items="${printBill}"
													varStatus="status">
													<tr>

														<td class="text-center">${bill.itemId}</td>
														<td>${bill.name}</td>
														<td class="text-center">${bill.quantity}</td>
														<td class="text-center">${bill.price}&#8364;</td>

													</tr>
												</c:forEach>
											</table>

											<div align="center">
												<h2>Booking fee: 5.00 &#8364;</h2>
												<h1>Total price: ${totalPrice} &#8364;</h1>
												<br>

											</div>

										</form>

									</div>
								</div>
							</div>

							<button type="button" value="Print bill" id="btnPrint">Print
								bill</button>

						</div>
					</div>
					<div class="col-sm-2 sidenav "></div>
				</div>
				<br>
			</div>

			<footer id="footer">
			<p class="text-center" id="p2">© Copyright 2020 GG Game Cafe</p>
			</footer>

		</div>
</body>
</html>