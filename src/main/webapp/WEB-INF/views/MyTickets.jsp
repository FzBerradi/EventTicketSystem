<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.List"%>
<%@ page import="Models.Event"%>
<%@ page import="Models.User"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Tickets Management System</title>
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
body {
	font-family: 'Open Sans', sans-serif; /* Police de caractères */
	background-color: #198754; /* Couleur de fond du corps */
}

.ticket-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
	padding: 20px;
}

.ticket {
	border: 2px solid #17a366; /* Couleur des bordures */
	border-radius: 10px;
	padding: 20px;
	width: 300px;
	background-color: #198754; /* Couleur de fond des tickets */
	transition: transform 0.3s ease-in-out;
	/* Animation de transformation */
	cursor: pointer; /* Curseur indiquant que le ticket est cliquable */
	transform-style: preserve-3d;
	/* Utilisation de la 3D pour les transformations */
}

.ticket:hover {
	transform: translateY(-5px) rotateX(10deg); /* Effet 3D au survol */
}

.member img {
	height: 200px !important;
}

.ticket h2 {
	margin-top: 0;
	color: #bed1c9; /* Couleur du titre */
	font-size: 24px; /* Taille de police */
	text-align: center; /* Alignement centré */
	text-transform: uppercase; /* Mise en majuscules */
	letter-spacing: 2px; /* Espacement entre les lettres */
}

.ticket p {
	margin-bottom: 10px;
	text-align: center; /* Alignement centré */
	color: #fff; /* Couleur du texte */
}

.ticket-status {
	font-weight: bold;
	color: green; /* Couleur de l'état */
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
	<section id="hero" class="hero" style="height: 98vh;">
		<div class="container position-relative">
			<div class="row gy-5 p-3 my-3"
				style="border: 1px solid #efefef; border-radius: 10px;"
				data-aos="fade-in">
				<!--             <div style="display: flex; justify-content: center;"> -->
				<!--                 <div style="background-color: #17a366; padding: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.08); margin-top: 20px;"> -->
				<!--                     <h1 style="color: #fff; font-size: 36px; text-align: center;"> Tickets</h1> -->
				<!--                 </div> -->
				<!--             </div> -->

				<div class="ticket-container"
					style="height: 60vh; overflow-y: auto;">

					<% List<Models.Ticket> tickets = (List<Models.Ticket>) request.getAttribute("tickets"); %>
					<% if (tickets != null && !tickets.isEmpty()) { %>
					<% for (Models.Ticket ticket : tickets) { %>
					<% Models.Event event = ticket.getEvent(); %>
					<% if (event != null) { %>
					<div class="ticket"
						onclick="showTicketDetails(<%= ticket.getId() %>)">
						<h2>
							<span><%= event.getName() %></span>
						</h2>
						<!-- Utilisation du nom de l'événement comme titre -->
					<p>
							Ticket ID:
							<%= ticket.getId() %></p>
						<p>
							Price💵:
							<%= ticket.getPrice() %></p>
						<p>
							Event Location🗺:<%= event.getLocation() %></p>
						<p>
							Location Date🗓:<%= event.getDate() %></p>
						<p>
							Description: <span class="ticket-status"> <%= ticket.getDescription() %></span>
						</p>

					</div>
					<% } else { %>
					<div>
						<p style="color: #fff; text-align: center;">Error: Event not
							found for this ticket</p>
					</div>
					<% } %>
					<% } %>
					<% } else { %>
					<p style="color: #fff; text-align: center;">No tickets found.</p>
					<% } %>
				</div>
			</div>
		</div>
		</div>
	</section>
	<script>
    function showTicketDetails(ticketId) {
        console.log("Ticket ID: " + ticketId);
    }
</script>
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
