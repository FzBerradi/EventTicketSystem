<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.Ticket"%>
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
.ticket-details {
	border: 2px solid #eaeaea;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin: 30px auto;
	max-width: 600px;
	background: white;
	position: relative;
}

.ticket-details h2 {
	color: #333;
	font-size: 24px;
	margin-bottom: 16px;
	text-align: center;
}

.ticket-details p {
	color: #555;
	font-size: 16px;
	line-height: 1.6;
	margin-bottom: 8px;
	border-bottom: 1px dashed #ddd;
	padding-bottom: 8px;
}

.ticket-details p  span {
	color: #E00;
	font-size: 18px;
	font-wieght: bold;
}

.ticket-details p:last-child {
	border-bottom: none;
}

/* Add a simulated tear-off effect */
.ticket-details:after {
	content: '';
	position: absolute;
	top: 0;
	left: 20px;
	right: 20px;
	border-top: 1px dashed #ddd;
}

/* Simulate a ticket stub on the right side */
.ticket-details:before {
	content: '';
	position: absolute;
	top: 20px;
	right: -10px;
	width: 40px;
	height: 80px;
	background: #f7f7f7;
	border-radius: 8px;
	box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1);
}

/* Style for the payment form */
form {
	text-align: center;
	margin-top: 20px;
}

form button {
	background-color: #4CAF50;
	/* A green color to indicate a positive action */
	color: white;
	padding: 10px 20px;
	margin: 20px 0;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 18px;
	transition: background-color 0.3s;
}

form button:hover {
	background-color: #45a049; /* Darken the button color on hover */
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
					Tickets Management System<span>.</span>
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
					<li><a href="/DecoratorProject/Register">Register</a></li>
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
				<main class="main-content">
					<div class="container">
						<h1 class="text-center">Ticket Confirmation</h1>
						<div class="ticket-details">
							<%
				    Ticket ticket = (Ticket) request.getAttribute("ticket");
				    if (ticket != null) {
				%>
							<h2>Your Ticket</h2>
							<p>
								Event:
								<%= ticket.getEvent().getName() %></p>
							<p>
								Location:
								<%= ticket.getEvent().getLocation() %></p>
							<p>
								Date:
								<%= ticket.getEvent().getDate() %></p>
							<p>
								Type:
								<%= ticket.getDescription() %></p>
							<p>
								Price:
								<%= ticket.getPrice() %>
								USD
							</p>
							<p>
								Status: <span> <%= ticket.getStatus() %>
								</span>
							</p>
							<%
				    }
				%>
						</div>

						<form action="payment" method="post">
							<input type="hidden" name="ticketId"
								value="<%= ticket.getId() %>" /> <input type="hidden"
								name="amount" value="<%= ticket.getPrice() %>" />
							<button type="submit">Choose your payment method</button>
						</form>



						<a style="color: white" href="/DecoratorProject/events">Back
							to Events</a>
					</div>
				</main>
			</div>
		</div>
	</section>

	<footer id="footer" class="footer">

		<div class="container">
			<div class="row gy-4">
				<div
					class="col-12 footer-info d-flex flex-direction-column justify-content-center align-items-center">
					<a href="index.html" class="logo d-flex align-items-center"> <span>Booking
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
</body>
</html>
