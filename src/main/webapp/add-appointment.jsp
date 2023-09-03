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
      <h2 class="text-center my-5">Your journey is our prime vision!</h2>
      <div class="card mb-5" style="max-width: 1100px; margin-inline: auto">
      <!-- Nav bar header -->
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs justify-content-center">
            <li class="nav-item">
              <a class="nav-link active" aria-current="true" href="#">Book Appointment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="search-and-update-appointment.jsp">Search Appointment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="getappointment?actiontype=getall">View all Appointments</a>
            </li>
          </ul>
        </div>
        <!-- End of Nav bar header -->
        <div class="card-body">
          <h5 class="card-title text-center mt-5">Get expert advice from our range of consultants!</h5>
          
          <!-- ADD AN APPOINTMENT -->
          <form action="appointmentmanager" method="post" class="mt-5" style="max-width: 600px; margin-inline: auto">
            <p class="text-success text-center mb-5" style="font-weight: 600">${feedback}</p>
            
<!--             id is for Label, and name is what goes into the Controller (get parameter) -->
            <label for="preferred-country">Preferred Destination Country<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentCountry" id="preferred-country"
            class="form-control mb-3 center" placeholder="Where do you wish to go?" required></input>
            
            <label for="preferred-job">Preferred Job<span class="text-danger">&nbsp;*</span></label>
            <input type="text" name="appointmentJob" id="preferred-job" 
            class="form-control mb-3" placeholder="What Job are you looking for?" required></input>
            
            <label for="appointment-date">Your available Date<span class="text-danger">&nbsp;*</span></label>
            <input type="date" name="appointmentDate" id="appointment-date" 
            class="form-control mb-3" required></input>
            
            <label for="appointment-time">Your available Time<span class="text-danger">&nbsp;*</span></label>
            <input type="time" name="appointmentTime" id="appointment-time" 
            class="form-control mb-3" required></input>
            
            <label for="appointment-desc">Description</label>
            <textarea name="appointmentDescription" id="appointment-desc" 
            class="form-control mb-3" placeholder="Is there anything you'd like to say? (Optional)"></textarea>
            
            <input type="hidden" name="actiontype" value="add-appointment"/>
            <button type="submit" class="btn btn-dark py-3">Create Appointment</button>
          </form>
          <!-- END OF ADD AN APPOINTMENT -->
        </div>
      </div> 
    </div>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    $(document).ready(function() {
  	    // Initialize the Datepicker
  	    $('#appointment-date').datepicker({
  	        format: 'yyyy-mm-dd', // Specify the date format
  	        autoclose: true
  	    });
  
  	    // Initialize the Timepicker
  	    $('#appointment-time').timepicker({
  	        showMeridian: false, // Use 24-hour format
  	        minuteStep: 1
  	    });
  	});
  </script>
  </body>
</html>