<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
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
.stats-container {
	display: flex;
	justify-content: center;
	margin-top: 50px;
}

.stat-box {
	width: 30%;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s ease;
	margin: 0 10px;
	flex: 1;
}

.stat-box:hover {
	transform: translateY(-10px);
}

.stat-content {
	text-align: center;
}

.stat-content h2 {
	font-size: 24px;
	margin-bottom: 10px;
	color: #333;
}

.stat-content p {
	font-size: 18px;
	color: #666;
}

.stats-container-centered {
	display: flex;
	justify-content: center;
	margin-top: 50px;
}
</style>
<title>Dashboard</title>
</head>
<body>
	<header id="header" class="header d-flex align-items-center">

		<div
			class="container-fluid container-xl d-flex align-items-center justify-content-between">
			<a href="index.html" class="logo d-flex align-items-center"> <!-- Uncomment the line below if you also wish to use an image logo -->
				<!-- <img src="assets/img/logo.png" alt=""> -->
				<h1>
					<span>ϟ</span>Admin System- Tickets<span>.</span>
				</h1>
		</a>
<nav id="navbar" class="navbar">
    <ul>
        <li><a href="/DecoratorProject">Home</a></li>
        <li><a href="events">Events</a></li>
        <% 
            User user = (User) session.getAttribute("user");
            if(user != null){
                String role = (String) user.getRole();
                if (role.equals("Admin")) { 
        %>
        <li><a href="profile"><%= user.getEmail()%></a></li>
        <li><a href="logout">Log out</a></li>
        <% 
                } 
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
				<div class="stat-content">
					<h1 class="p-0 my-4 text-center">Dashboard📈</h1>
				</div>
				<div class="stats-container">
					<div class="stat-box">
						<div class="stat-content">
							<h2>Number of Users</h2>
							<p><%= request.getAttribute("numberOfUsers") %></p>
						</div>
					</div>
					<div class="stat-box">
						<div class="stat-content">
							<h2>Number of Events</h2>
							<p><%= request.getAttribute("numberOfEvents") %></p>
						</div>
					</div>
					<div class="stat-box">
						<div class="stat-content">
							<h2>Pending Tickets</h2>
							<p><%= request.getAttribute("numberOfPendingTickets") %></p>
						</div>
					</div>
					<div class="stat-box">
						<div class="stat-content">
							<h2>Booked Tickets</h2>
							<p><%= request.getAttribute("numberOfBookedTickets") %></p>
						</div>
					</div>
				</div>

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
