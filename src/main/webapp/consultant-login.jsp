<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>The Jobs | Consultant Sign In</title>
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
  <div class="container mt-5 py-5 my-auto ">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h3 class="text-center mb-5"></h3>
        <div class="card">
          <div class="card-header">
            <h5 class="text-center my-3">Login as Consultant</h5>
          </div>
          <div class="card-body">
            <form action="consultantmanager" method="post">
              <p class="text-danger text-center mb-3" style="font-weight: 600">${errorFeedback}</p>
                <div class="container">
                <div class="mb-3">
                  <label for="username" class="form-label">Username<span class="text-danger">&nbsp;*</span></label>
                  <input type="text" class="form-control" id="username" name="consultantUsername" required>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password<span class="text-danger">&nbsp;*</span></label>
                  <input type="password" class="form-control" id="password" name="consultantPassword" required>
                </div>
                <div class="d-grid gap-2 col-6 mx-auto">
                  <input type="hidden" name="actiontype" value="login-consultant">
                  <button type="submit" class="btn btn-dark btn-lg py-2">Sign In</button>
                </div>
              </div>
            </form>
          </div>
          <div class="card-footer text-center">
            <p class="my-3"><small>Please use the Login credentials provided to you by System Admin</small></p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>