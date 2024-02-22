<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>TutorFinder</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Facebook Opengraph integration: https://developers.facebook.com/docs/sharing/opengraph -->
  <meta property="og:title" content="">
  <meta property="og:image" content="">
  <meta property="og:url" content="">
  <meta property="og:site_name" content="">
  <meta property="og:description" content="">

  <!-- Twitter Cards integration: https://dev.twitter.com/cards/  -->
  <meta name="twitter:card" content="summary">
  <meta name="twitter:site" content="">
  <meta name="twitter:title" content="">
  <meta name="twitter:description" content="">
  <meta name="twitter:image" content="">

  <!-- Favicons -->
   <link href="assets-welcome/img/logo-tfs-no-text.png" rel="icon">
  <link href="assets-welcome/img/logo-tfs-no-text.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets-welcome/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets-welcome/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets-welcome/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets-welcome/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets-welcome/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets-welcome/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Imperial - v5.7.0
  * Template URL: https://bootstrapmade.com/imperial-free-onepage-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>

    /**
* Template Name: Imperial - v5.7.0
* Template URL: https://bootstrapmade.com/imperial-free-onepage-bootstrap-theme/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/

/*--------------------------------------------------------------
# General
--------------------------------------------------------------*/
body {
  background: #fff;
  color: #AC20CD;
  font-family: "Open Sans", sans-serif;
}

a {
  text-decoration: none;
  color: #03C4EB;
  transition: 0.5s;
}

a:hover, a:active, a:focus {
  color: #03c5ec;
  outline: none;
  text-decoration: none;
}

p {
  padding: 0;
  margin: 0 0 30px 0;
}

h1, h2, h3, h4, h5, h6 {
  font-family: "Raleway", sans-serif;
  font-weight: 400;
  margin: 0 0 20px 0;
  padding: 0;
}

/* Prelaoder */
#preloader {
  position: fixed;
  left: 0;
  top: 0;
  z-index: 999;
  width: 100%;
  height: 100%;
  overflow: visible;
  background: #fff url("../img/preloader.svg") no-repeat center center;
}

/*--------------------------------------------------------------
# Welcome
--------------------------------------------------------------*/

@media (min-width: 1024px) {
  #hero {
    background-attachment: fixed;
  }
}
#hero .hero-logo {
  margin: 20px;
}
#hero .hero-logo img {
  max-width: 150px;
}
#hero .hero-container {
  background: rgba(98, 29, 138, 0.582);
  display: table-cell;
  margin: 0;
  padding-top: 80px;
  text-align: center;
  vertical-align: auto;
}
#hero h1 {
  margin: 30px 0 10px 0;
  font-weight: 700;
  line-height: 48px;
  letter-spacing: 6px;
  color: #fff;
}
@media (max-width: 768px) {
  #hero h1 {
    font-size: 28px;
    line-height: 36px;
  }
}
#hero h2 {
  color: #ccc;
  margin-bottom: 40px;
}
#hero h2 span {
  color: #fff;
  transition: 0.3s;
  border-bottom: 2px solid #03C4EB;
}
@media (max-width: 768px) {
  #hero h2 {
    font-size: 24px;
    line-height: 26px;
    margin-bottom: 30px;
  }
  #hero h2 .rotating {
    display: block;
  }
}
#hero .rotating > .animated {
  display: inline-block;
}
#hero .actions a {
  font-family: "Raleway", sans-serif;
  text-transform: uppercase;
  font-weight: 500;
  font-size: 16px;
  letter-spacing: 1px;
  display: inline-block;
  padding: 8px 20px;
  border-radius: 2px;
  transition: 0.5s;
  margin: 10px;
}
#hero .btn-welcome {
  background: #9b55c9c2;
  border: 2px solid rgba(255, 255, 255, 0.562);
  color: #fff;
  width:150px;
}
#hero .btn-welcome:hover {
  background: none;
  border: 2px solid #fff;
  color: #fff;
  width:150px;
}
  </style>
</head>

<body>

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <div data-aos="fade-in">
        <div class="hero-logo">
          <img class="" src="assets-welcome/img/logo-tfs-no-text.png" alt="TutorFinder">
        </div>

        <h1>TutorFinder</h1>
      <h2>We serve connection among Tutors and Students</h2>
      <div class="d-block m-0 text-white">
        <h4>Select Your Role</h4>
        <div class="actions">
          <a href="StuLoginPathFirst.do" class="btn-welcome">Student</a>
          <a href="loginPathFirst.do" class="btn-welcome">Tutor</a>
        </div>
      </div>
    </div>
  </section><!-- End Hero -->


  <!-- Vendor JS Files -->
  <script src="assets-welcome/vendor/aos/aos.js"></script>
  <script src="assets-welcome/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets-welcome/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets-welcome/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets-welcome/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets-welcome/vendor/typed.js/typed.min.js"></script>
  <script src="assets-welcome/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets-welcome/js/main.js"></script>

</body>

</html>