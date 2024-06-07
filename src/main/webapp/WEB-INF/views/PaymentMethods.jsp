<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style type="text/css">
<
style>.form-container {
	max-width: 300px;
	margin: 20px auto;
	padding: 20px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.6);
}

.form-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
}

form label {
	margin-bottom: 5px;
}

form input[type="text"], form input[type="email"], form input[type="number"]
	{
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ddd;
	border-radius: 4px;
}

form input[type="submit"] {
	padding: 10px;
	border: none;
	border-radius: 4px;
	background-color: #5cb85c;
	color: white;
	cursor: pointer;
}

form input[type="submit"]:hover {
	background-color: #4cae4c;
}

li button.active {
	color: #000 !important;
}

li button {
	color: #fff !important;
}
</style>

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
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
							data-bs-target="#home-tab-pane" type="button" role="tab"
							aria-controls="home-tab-pane" aria-selected="true">Card
							Payment</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
							data-bs-target="#profile-tab-pane" type="button" role="tab"
							aria-controls="profile-tab-pane" aria-selected="false">Bank
							Transfer</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
							data-bs-target="#contact-tab-pane" type="button" role="tab"
							aria-controls="contact-tab-pane" aria-selected="false">PayPal
							Payment</button>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home-tab-pane"
						role="tabpanel" aria-labelledby="home-tab" tabindex="0">
						<!-- Card Payment Form -->
						<div class="form-container">
							<h2>Card Payment</h2>
							<form action="pay" method="post">
								<input type="hidden" name="paymentType" value="card" type="text">

								<input type="hidden" name="amount" value=${amount } required />
								<input type="hidden" name="ticketId" value=${ticketId} >
								<label for="cardNumber">Amount</label> <input type="text"
									id="cardNumber" readonly value="${amount} $" required>

								<label for="cardNumber">Card Number:</label> <input type="text"
									id="cardNumber" name="cardNumber"
									placeholder="1111 2222 3333 4444" required> <label
									for="cvv">CVV:</label> <input type="text" id="cvv" name="cvv"
									placeholder="123" required> <label for="expiryDate">Expiry
									Date:</label> <input type="text" id="expiryDate" name="expiryDate"
									placeholder="MM/YY" required> <input type="submit"
									value="Pay with Card">
							</form>
						</div>
					</div>
					<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
						aria-labelledby="profile-tab" tabindex="0">
						<!-- Bank Transfer Form -->
						<div class="form-container">
							<h2>Bank Transfer</h2>
							<form action="pay" method="post">
								<input type="hidden" name="paymentType" value="bankTransfer">
								<input type="hidden" name="amount" value=${amount } required />
								<input type="hidden" name="ticketId" value=${ticketId} >
								<label for="price">Amount</label> <input type="text" id="price"
									readonly value="${amount} $" required> <label
									for="accountNumber">Account Number:</label> <input type="text"
									id="accountNumber" name="accountNumber"
									placeholder="Account Number" required> <label
									for="routingNumber">Routing Number:</label> <input type="text"
									id="routingNumber" name="routingNumber"
									placeholder="Routing Number" required> <input
									type="submit" value="Pay via Bank Transfer">
							</form>
						</div>
					</div>
					<div class="tab-pane fade" id="contact-tab-pane" role="tabpanel"
						aria-labelledby="contact-tab" tabindex="0">
						<!-- PayPal Form -->
						<div class="form-container">
							<h2>PayPal Payment</h2>
							<form action="pay" method="post">
								<input type="hidden" name="paymentType" value="paypal">
								<input type="hidden" name="amount" value=${amount } required />
								<input type="hidden" name="ticketId" value=${ticketId} >
								<label for="price">Amount</label> <input type="text" id="price"
									readonly value="${amount} $" required> <label
									for="paypalEmail">PayPal Email:</label> <input type="email"
									id="paypalEmail" name="paypalEmail"
									placeholder="email@example.com" required> <input
									type="submit" value="Pay with PayPal">
							</form>
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
