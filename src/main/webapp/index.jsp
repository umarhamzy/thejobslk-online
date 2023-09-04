<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>The Jobs | Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="styles/style.css">
</head>
  <body>
    <!-- NAV BAR START -->
    <nav class="navbar navbar-expand-lg bg-dark mb-5 py-4" data-bs-theme="dark">
      <div class="container">
        <a class="navbar-brand" href="#">The Jobs&trade;</a>
        
        <!-- TODO: REMOVE WHERE APPROPRIATE -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="#services">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#testimonials">Testimonials</a>
            </li>
          </ul>
          <!-- TODO: Add logout button add-appointment pages and consultant related pages -->
        </div>
        <!-- TO DO: REMOVE UPTO HERE IN OTHER PAGES -->
      </div>
    </nav>
    <!-- NAV BAR END -->
    
    <!-- HEADER START -->
    <header class="text-center my-5">
      <div class="container">
        <h1>Welcome to The Jobs&trade;</h1>
        <p class="h4 my-5">Your pathway to a successful career starts here</p>
        <div class="d-grid col-3 mx-auto">
          <a class="btn btn-outline-dark btn-lg" href="jobseeker-register.jsp" role="button">Get Started</a>
        </div>    
      </div>
    </header>
    <!-- HEADER END -->

    <!-- SERVICES START -->
    <section id="services" class="bg-light py-5">
      <div class="container">
        <h2 class="text-center mb-5">Our Services</h2>
          <div class="row">
            <div class="col-md-4">
              <div class="card mb-4">
                <div class="card-body">
                  <h3 class="card-title">Resume Review</h3>
                  <p class="card-text">Get professional feedback on your resume.</p>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4">
                <div class="card-body">
                  <h3 class="card-title">Interview Coaching</h3>
                  <p class="card-text">Prepare for job interviews with our diverse range of expert consultants.</p>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4">
                <div class="card-body">
                  <h3 class="card-title">Job Placement</h3>
                  <p class="card-text">Let us help you find the perfect job match.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
    </section>
    <!-- SERVICES END -->
    
    <!-- TESTIMONIALS START -->
    <section id="testimonials" class="py-5">
      <div class="container">
        <h2 class="text-center mb-5">Testimonials</h2>
        <div class="row">
          <div class="col-md-4">
            <div class="card mb-4">
              <div class="card-body">
                <blockquote class="blockquote">
                  <p>I got my dream job with the help of The Jobs. Their interview coaching was invaluable!</p>
                  <footer class="blockquote-footer">Alvin the Chipmunk</footer>
                </blockquote>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card mb-4">
              <div class="card-body">
                <blockquote class="blockquote">
                  <p>The resume review service helped me create an outstanding resume! Highly recommend their services!</p>
                  <footer class="blockquote-footer">Kumar Sangakkara</footer>
                </blockquote>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card mb-4">
              <div class="card-body">
                <blockquote class="blockquote">
                  <p>The Jobs made my job search easier and more efficient in my desired country. Highly recommended!</p>
                  <footer class="blockquote-footer">Perera</footer>
                </blockquote>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- TESTIMONIALS END -->
    
    <!-- FOOTER -->
    <footer class="bg-dark text-white text-center py-3">
      <div class="container d-flex justify-content-between">
        <p class="my-auto">&copy; 2023 The Jobs&trade;</p>
        <div class="btn-group" role="group">
          <button type="button" class="btn btn-outline-light dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Staff Logins
          </button>
          <ul class="dropdown-menu text-center">
            <li><a class="dropdown-item" href="consultant-login.jsp">Consultant</a></li>
            <li><a class="dropdown-item" href="manager-login.jsp">Manager</a></li>
          </ul>
        </div>
      </div>
    </footer>    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>