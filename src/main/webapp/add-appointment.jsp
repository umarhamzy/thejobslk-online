<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <title>The Jobs | Add appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
    <div class="container">
      <h1 class="text-center">Create an Appointment</h1>
      <h2 class="text-center">Your journey is our prime goal!</h2>
      
      <form action="appointmentmanager" method="post" class="mt-5">
        <p>${feedback}</p>
      
        <label for="prefered-country">Preferred Country</label>
        <input type="text" name="appointmentCountry" id="prefered-country" class="form-control mb-3"></input>
        
        <label for="preferred-job">Preferred Job</label>
        <input type="text" name="appointmentJob" id="preferred-job" class="form-control mb-3"></input>
        
        <label for="appointment-date">Your available Date</label>
        <input type="text" name="appointmentDate" id="appointment-date" class="form-control mb-3"></input>
        
        <label for="appointmentTime">Your available Time</label>
        <input type="text" name="appointmentTime" id="appointment-time" class="form-control mb-3"></input>
        
        <label for="appointment-desc">Description</label>
        <textarea name="appointmentDescription" id="appointment-desc" class="form-control mb-3"></textarea>
        
        <input type="hidden" name="actiontype" value="add-appointment"/>
        <button type="submit" class="btn btn-dark">Create Appointment</button>
      </form>
    </div>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>