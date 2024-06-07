<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Models.Event"%>
<%@ page import="Models.User"%>
<!DOCTYPE html>
<html lang="en">
<head>

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
<style>
.member img {
	height: 200px !important;
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
	<!-- ======= Hero Section ======= -->
	<section id="hero" class="hero" style="height: 100%; border: 1px">
		<div class="container position-relative">
			<div class="row gy-5 p-3 my-3"
				style="border: 1px solid #efefef; border-radius: 10px"
				data-aos="fade-in">
				<h1>Book Your Ticket</h1>
				<form action="booking" method="post">
					<input type="hidden" name="eventId"
						value="<%= request.getParameter("eventId") %>" /> <label
						class="form-label" for="ticketType">Select Ticket Type:</label> <select
						class="form-select" name="ticketType" id="ticketType">
						<option value="Basic">Basic Ticket</option>
						<option value="VIP">VIP Ticket</option>
						<option value="Food">Meal Ticket</option>
						<option value="FullPackage">Full Package</option>
					</select> <br /> <input class="btn btn-success mb-3" type="submit"
						value="Book Ticket" />
				</form>
			</div>
		</div>
	</section>
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
	<!-- End Footer -->
	<!-- End Footer -->

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

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
</body>
</html>
