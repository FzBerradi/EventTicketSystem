<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>User Profile</title>

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
.profile-card {
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Shadow */
	padding: 20px;
	max-width: 600px;
	margin: auto;
	display: block;
	background-color: #fff; /* Background color */
}

.profile-card p {
	margin-bottom: 10px;
	color: #333; /* Text color */
}

.profile-card h2 {
	color: #007bff; /* Header color */
}

.btn-get-started {
	background-color: #007bff; /* Button background color */
	color: #fff; /* Button text color */
	border: none;
	padding: 14px 20px;
	margin: 8px 0;
	cursor: pointer;
	width: 100%;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

.btn-get-started:hover {
	background-color: #17a366; /* Button hover background color */
}
</style>
</head>
<body>

	<header id="header" class="header d-flex align-items-center">
		<div
			class="container-fluid container-xl d-flex align-items-center justify-content-between">
			<a href="index.html" class="logo d-flex align-items-center">
				<h1>
					Tickets Management System🔖<span>.</span>
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
                	   <% String role = (String) user.getRole();
			 if (role.equals("Admin")) { %>
					<li><a href="/DecoratorProject/dashboard">Dashboard</a></li>
			<% } %>
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
        
      </nav><!-- .navbar -->
			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i> <i
				class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
		</div>
	</header>

		<section id="hero" class="hero" style="height: 98vh; border: 1px;">
		<div class="container position-relative">
			<div class="row gy-8 p-3 my-3"
				style="border: 1px solid #efefef; border-radius: 10px"
				data-aos="fade-in">
				<div
					class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center text-center text-lg-start profile-card">
					<h2 class="p-0 my-5 text-center" style="padding: 8px;">
					<% User user1 = (User) session.getAttribute("user");
                           if (user1 != null) {
                               String role = user1.getRole();
                               if (role.equals("Admin")) {
                        %>
                               Admin Profile
                        <% } else { %>
                               User Profile
                        <% } 
                           } else { %>
                               User Profile
                        <% } %>
                    </h2>
	        <% User user2 = (User) session.getAttribute("user");
                   if (user2 != null) { %>
               <div class="user-info">
                   <% String role = user2.getRole();
                  if (role.equals("Admin")) {
                 %>
                <p>
                  <span style="font-weight: bold; color: #343a40;">Admin Name:</span>
                <%= user2.getName() %>
                </p>
               <p>
                <span style="font-weight: bold; color: #343a40;">Admin Email:</span>
                 <%= user2.getEmail() %>
              </p>
            <% } else { %>
              <p>
             <span style="font-weight: bold; color: #343a40;">User Name:</span>
              <%= user2.getName() %>
             </p>
           <p>
        <span style="font-weight: bold; color: #343a40;">User Email:</span>
        <%= user2.getEmail() %>
    </p>
     <% } %>
     </div>
             <% } else { %>
        <p>No user data found!</p>
     <% } %>

				<div class="col-lg-6 order-1 order-lg-2">
					<img src="assets/img/2928727.webp" class="img-fluid w-100"
						alt="Admin Photo" data-aos="zoom-out" data-aos-delay="100">
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
