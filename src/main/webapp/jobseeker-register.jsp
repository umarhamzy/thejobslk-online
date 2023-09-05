<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>The Jobs | Sign Up</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
  <link rel="stylesheet" href="styles/style.css">
</head>
<body>
  <nav class="navbar navbar-expand-lg bg-dark mb-5 py-4" data-bs-theme="dark">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">The Jobs&trade;</a>
    </div>
  </nav>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6 mb-5">
        <h3 class="text-center mb-5">Welcome to The Jobs!</h3>
        <div class="card">
          <div class="card-header">
            <h5 class="text-center my-3">We are excited to have you!</h5>
          </div>
          <div class="card-body">
            <form action="jobseekermanager" method="post">
              <p class="text-success text-center mb-5" style="font-weight: 600">${feedback}</p>
              <div class="container">
                <div class="mb-3">
                  <label for="jobseeker-firstname" class="form-label">First Name<span class="text-danger">&nbsp;*</span></label>
                  <input type="text" class="form-control" id="jobseeker-firstname" name="jobseekerFirstName" required>
                </div>
                <div class="mb-3">
                  <label for="jobseeker-lastname" class="form-label">Last Name<span class="text-danger">&nbsp;*</span></label>
                  <input type="text" class="form-control" id="jobseeker-lastname" name="jobseekerLastName" required>
                </div>
                <div class="mb-3">
                  <label for="jobseeker-username" class="form-label">Username<span class="text-danger">&nbsp;*</span></label>
                  <input type="text" class="form-control" id="jobseeker-username" name="jobseekerUsername" required>
                </div>
                <div class="mb-3">
                  <label for="jobseeker-email" class="form-label">Email<span class="text-danger">&nbsp;*</span></label>
                  <input type="email" class="form-control" id="jobseeker-email" name="jobseekerEmail" required>
                </div>
                <div class="mb-3">
                  <label for="jobseeker-password" class="form-label">Password<span class="text-danger">&nbsp;*</span></label>
                  <input type="password" class="form-control" id="jobseeker-password" name="jobseekerPassword" required>
                </div>
                  <div class="d-grid gap-2 col-6 mx-auto">
                  <input type="hidden" name="actiontype" value="register-jobseeker">
                  <button type="submit" class="btn btn-dark btn-lg py-2">Sign Up</button>
              </div>
              </div>
            </form>
          </div>
          <div class="card-footer text-center">
            <p class="my-3">Already have an account? <a href="jobseeker-login.jsp">Sign In</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>