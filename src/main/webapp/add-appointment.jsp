<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <title>The Jobs | Add appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/appointment.css">
    <link rel="stylesheet" href="styles/style.css">
  </head>
  <body>
    <div class="container">
      <h2 class="text-center my-5">Your journey is our prime goal!</h2>
      <div class="card text-center">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link active" aria-current="true" href="#">Book Appointment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Search Appointment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">View all Appointments</a>
            </li>
          </ul>
        </div>
        <div class="card-body">
          <h5 class="card-title">Get expert advice from our range of consultants!</h5>
          <form action="appointmentmanager" method="post" class="mt-5" style="max-width: 600px; margin-inline: auto">
            <p class="text-success mb-5" style="font-weight: 600">${feedback}</p>
            
<!--             id is for Label, and name is what goes into the Controller (get parameter) -->
            <label for="prefered-country">Preferred Destination Country<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentCountry" id="prefered-country"
            class="form-control mb-3 center" placeholder="Where do you wish to go?" required></input>
            
            <label for="preferred-job">Preferred Job<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentJob" id="preferred-job" 
            class="form-control mb-3" placeholder="What Job are you looking for?" required></input>
            
            <label for="appointment-date">Your available Date<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentDate" id="appointment-date" 
            class="form-control mb-3" placeholder="YYYY/MM/DD" required></input>
            
            <label for="appointment-time">Your available Time<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentTime" id="appointment-time" 
            class="form-control mb-3" placeholder="6:30AM" required></input>
            
            <label for="appointment-desc">Description</label>
            <textarea name="appointmentDescription" id="appointment-desc" 
            class="form-control mb-3" placeholder="Is there anything you'd like to say? (Optional)"></textarea>
            
            <input type="hidden" name="actiontype" value="add-appointment"/>
            <button type="submit" class="btn btn-dark py-3">Create Appointment</button>
          </form>
        </div>
      </div> 
    </div>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  
  </body>
</html>