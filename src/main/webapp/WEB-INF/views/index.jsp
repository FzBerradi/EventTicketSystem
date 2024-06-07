<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Ticket Management System</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="https://cdn1.iconfinder.com/data/icons/business-startup-14/60/Air_Tickets-512.png" rel="icon">


  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
  <style>
    .member img{
      height: 200px !important;
    }
  </style>   
</head>
<body>


 <header id="header" class="header d-flex align-items-center">

    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1>Ticket Management System<span>.</span></h1>
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

      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header>

<!-- ======= Hero Section ======= -->
  <section id="hero" class="hero">
    <div class="container position-relative">
      <div class="row gy-5" data-aos="fade-in">
        <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center text-center text-lg-start">
          <h2>Ticket MANAGEMENT <span>SYSTEM</span></h2>
          <p>Explore our Ticket Management System! Your online ally for managing your booking needs effortlessly. 
          With intuitive navigation and quick access to key features, discover how to streamline your booking process 
          and enhance customer satisfaction.</p>
          <div class="d-flex justify-content-center justify-content-lg-start">
            <a href="#about" class="btn-get-started">Get Started</a>
          </div>
        </div>
        <% 
           String role = (String) user.getRole();
       if (role.equals("Admin")) { 
            %>
         <div class="col-lg-6 order-1 order-lg-2 d-flex justify-content-end">
          <img src="assets/img/ticketss.webp" class="img-fluid w-75" alt="" data-aos="zoom-out" data-aos-delay="100">
            </div>
      <% } else { %>
           <div class="col-lg-6 order-1 order-lg-2 d-flex justify-content-end">
    <img src="https://cdn3d.iconscout.com/3d/premium/thumb/online-ticket-booking-9344266-7656012.png" class="img-fluid w-75" alt="" data-aos="zoom-out" data-aos-delay="100">
     </div> 
      <% } %>

      </div>
    </div>

    <div class="icon-boxes position-relative">
      <div class="container position-relative">
        <div class="row gy-4 mt-5">

          <div class="col-xl-3 col-md-6" data-aos="fade-up" data-aos-delay="100">
          <div class="icon-box">
            <div class="icon"><i class="bi bi-calendar-check"></i></div>
            <h4 class="title"><a href="" class="stretched-link">Book Appointments</a></h4>
          </div>
        </div><!--End Icon Box -->

        <div class="col-xl-3 col-md-6" data-aos="fade-up" data-aos-delay="200">
          <div class="icon-box">
            <div class="icon"><i class="bi bi-person-lines-fill"></i></div>
            <h4 class="title"><a href="" class="stretched-link">Manage Customers</a></h4>
          </div>
        </div><!--End Icon Box -->

        <div class="col-xl-3 col-md-6" data-aos="fade-up" data-aos-delay="300">
          <div class="icon-box">
            <div class="icon"><i class="bi bi-gear"></i></div>
            <h4 class="title"><a href="" class="stretched-link">Customize Settings</a></h4>
          </div>
        </div><!--End Icon Box -->

        <div class="col-xl-3 col-md-6" data-aos="fade-up" data-aos-delay="500">
          <div class="icon-box">
            <div class="icon"><i class="bi bi-graph-up"></i></div>
            <h4 class="title"><a href="" class="stretched-link">Analytics & Reports</a></h4>
          </div>
        </div><!--End Icon Box -->

        </div>
      </div>
    </div>

    </div>
  </section>
  <!-- End Hero Section -->


  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">

    <div class="container">
      <div class="row gy-4">
        <div class="col-12 footer-info d-flex flex-direction-column justify-content-center align-items-center">
          <a href="index.html" class="logo d-flex align-items-center">
            <span>Ticket Management System</span>
          </a>
        </div>

      </div>
    </div>

    <div class="container mt-4">
      <div class="copyright">
        &copy; Copyright <strong><span>2024</span></strong>. All Rights Reserved
      </div>
    </div>

  </footer><!-- End Footer -->
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
