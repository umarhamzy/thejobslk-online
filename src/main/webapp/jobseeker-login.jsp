<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>The Jobs | Sign In</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
  <link rel="stylesheet" href="styles/style.css">
</head>
<body>
  <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">The Jobs</a>
    </div>
  </nav>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h3 class="text-center mb-5">Welcome to The Jobs!</h3>
        <div class="card">
          <div class="card-header">
            <h5 class="text-center my-3">Login to book your appointments</h5>
          </div>
          <div class="card-body">
            <form action="jobseekermanager" method="post">
              <p class="text-danger text-center mb-3" style="font-weight: 600">${errorFeedback}</p>
              <div class="mb-3">
                <label for="username" class="form-label">Username<span class="text-danger">&nbsp;*</span></label>
                <input type="text" class="form-control" id="username" name="jobseekerUsername" required>
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password<span class="text-danger">&nbsp;*</span></label>
                <input type="password" class="form-control" id="password" name="jobseekerPassword" required>
              </div>
              <div class="d-grid gap-2 col-6 mx-auto">
                <input type="hidden" name="actiontype" value="login-jobseeker">
                <button type="submit" class="btn btn-dark py-2">Sign In</button>
              </div>
            </form>
          </div>
          <div class="card-footer text-center">
            <p class="my-3">Don't have an account? <a href="jobseeker-register.jsp">Sign Up</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>