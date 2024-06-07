<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Ticket Management System</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link
	href="https://cdn1.iconfinder.com/data/icons/business-startup-14/60/Air_Tickets-512.png"
	rel="icon">


<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/main.css" rel="stylesheet">
<title>Success Payment</title>
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
}

.card {
	width: 300px;
	height: 200px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	margin-right: 20px;
	position: relative;
	cursor: pointer;
	transition: transform 0.5s;
}

.card:hover {
	transform: rotateY(20deg);
}

.card .card-inner {
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 0.5s;
	transform-style: preserve-3d;
	backface-visibility: hidden;
	position: absolute;
	top: 0;
	left: 0;
}

.card:hover .card-inner {
	transform: rotateY(180deg);
}

.card .card-front, .card .card-back {
	width: 100%;
	height: 100%;
	backface-visibility: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 10px;
	position: absolute;
	top: 0;
	left: 0;
}

.card .card-front {
	background-color: #f0f0f0;
}

.card .card-back {
	background-color: #fff;
	transform: rotateY(180deg);
}

.card .card-image {
	width: 100%;
	height: auto;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}

.card .card-details {
	padding: 20px;
	text-align: left;
	font-family: 'Montserrat', sans-serif;
	font-weight: 400;
	font-size: 18px;
	color: #000;
}

.card .card-details strong {
	font-weight: bold;
}

.card .card-details p {
	font-style: italic;
	color: #000;
}

.card-face.back {
	background-color: #f0f0f0;
	border-radius: 20px;
	transform: rotateY(180deg);
}

.ticket-image {
	width: 100px;
	height: auto;
	margin-right: 20px;
}

.success-message {
	text-align: center;
	font-family: 'Montserrat', sans-serif;
	font-size: 24px;
	font-weight: bold;
	color: #28a745;
	margin-bottom: 20px;
}
</style>
</head>
<body>

	<header id="header" class="header d-flex align-items-center">

		<div
			class="container-fluid container-xl d-flex align-items-center justify-content-between">
			<a href="index.html" class="logo d-flex align-items-center"> <!-- Uncomment the line below if you also wish to use an image logo -->
				<!-- <img src="assets/img/logo.png" alt=""> -->
				<h1>
					Ticket Management System<span>.</span>
				</h1>
			</a>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a href="/DecoratorProject">Home</a></li>
					<li><a href="events">Events</a></li>
					<li><a href="tickets">Tickets</a></li>
					<% 
                User user = (User) session.getAttribute("user");
                if(user != null){ %>

					<li><a href="profile"><%= user.getName()%></a></li>
					<li><a href="logout">Log out</a></li>
					<% 
                }else{
                %>
					<li><a href="/DecoratorProject/register">Register</a></li>
					<li><a href="/DecoratorProject/LoginServlet">Login</a></li>
					<% 
                }
                %>
				</ul>
			</nav>
			<!-- .navbar -->

			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i> <i
				class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

		</div>
	</header>
	<section id="hero" class="hero" style="height: 98vh; border: 1px">
		<div class="container position-relative">
			<div class="row gy-5 p-3 my-3"
				style="border: 1px solid #efefef; border-radius: 10px"
				data-aos="fade-in">
				<div
					class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center text-center text-lg-start login-card">
					<h2 class="p-0 my-2 text-center">Congratulations! You've got
						your ticket🎫</h2>
					<div class="container">
						<div class="ticket-container"
							style="height: 60vh; overflow-y: auto;">
							<div class="row">
								<div class="card">
									<div class="card-inner">
										<div class="card-front">
											<div class="card-details">
												<h5 class="card-title">Ticket Details</h5>
												<p>
													<strong><span
														style="color: #000; font-style: italic;">Ticket ID:</span></strong><span
														style="color: #000; font-style: italic;"> <%= request.getParameter("ticketId") %></span><br>
													<strong><span
														style="color: #000; font-style: italic;">Amount
															Paid:</span></strong><span style="color: #000; font-style: italic;">
														<%= request.getParameter("amount") %></span><br>
													<!-- Add more ticket details here -->
												</p>
											</div>

										</div>
										<div class="card-face back">
											<img class="ticket-image" src="assets/img/ticket.webp"
												alt="Ticket Image">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 order-1 order-lg-2">
					<img src="assets/img/ticket.webp" class="img-fluid w-100 " alt=""
						data-aos="zoom-out" data-aos-delay="100">
				</div>
			</div>
		</div>
	</section>

</body>
<!-- ======= Footer ======= -->
<footer id="footer" class="footer">

	<div class="container">
		<div class="row gy-4">
			<div
				class="col-12 footer-info d-flex flex-direction-column justify-content-center align-items-center">
				<a href="index.html" class="logo d-flex align-items-center"> <span>Ticket
						Management System</span>
				</a>
			</div>

		</div>
	</div>

	<div class="container mt-4">
		<div class="copyright">
			&copy; Copyright <strong><span>2024</span></strong>. All Rights
			Reserved
		</div>
	</div>

</footer>
<!-- End Footer


  <!-- Vendor JS Files -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/aos/aos.js"></script>
<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
</html>
