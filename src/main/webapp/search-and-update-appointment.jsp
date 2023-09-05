<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Jobs | Search and Update Appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="styles/appointment.css"> -->
    <link rel="stylesheet" href="styles/style.css">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-dark mb-5 py-4" data-bs-theme="dark">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">The Jobs&trade;</a>
        <a class="btn btn-outline-light" href="getjobseeker?actiontype=logout-jobseeker">Logout</a>
      </div>
    </nav>
    <div class="container">
      <h2 class="text-center my-5">Your journey is our prime vision!</h2>
      <div class="card mb-5" style="max-width: 1100px; margin-inline: auto">
      <!--     Card header -->
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs justify-content-center">
              <li class="nav-item">
                <a class="nav-link" href="add-appointment.jsp">Book Appointment</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="true" href="#">Search Appointment</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="getappointment?actiontype=get-all-delete-each">View all Appointments</a>
              </li>
            </ul>
          </div>
          <!-- End of Card header -->
          <div class="card-body">
            <h5 class="card-title text-center mt-5 ">Get expert advice from our range of consultants!</h5>
            
            <!-- SEARCH -->
            <!-- Default method is get, therefore no need to explicitly mention -->
            <form action="getappointment" class="mt-5" style="max-width: 600px; margin-inline: auto">
              <label for="appointment-id">Appointment #</label>
              <input type="number" name="appointmentId" id="appointment-id"
              class="form-control mb-3 center"></input>
              
              <input type="hidden" name="actiontype" value="search-appointment"/>
              <button type="submit" class="btn btn-dark disabled" id="search-btn">Search</button>
            </form>
            <!-- END OF SEARCH -->
            
            <hr style="max-width: 600px; margin-inline: auto">
            
            <!-- UPDATE -->
            <p class="text-primary text-center mb-3" style="font-weight: 600">${feedback}</p>
            <form action="appointmentmanager" method="post" class="mt-5" style="max-width: 600px; margin-inline: auto">
              
              <label for="appointment-id-update">Appointment #</label>
              <input type="number" name="appointmentId" id="appointment-id-update"
              class="form-control mb-3 center" placeholder="1" value="${appointment.appointmentId}" readonly/></input>       
              
              <!--id is for Label, and name is what goes into the Controller (get parameter) -->
              <label for="preferred-country-update">Preferred Destination Country<span class="text-danger">&nbsp;*</span></label>
              <input type="text" name="appointmentCountry" id="preferred-country-update"
              class="form-control mb-3 center" placeholder="Where do you wish to go?" value="${appointment.appointmentCountry}" required></input>
              
              <label for="preferred-job-update">Preferred Job<span class="text-danger">&nbsp;*</span></label>
              <input type="text" name="appointmentJob" id="preferred-job-update" 
              class="form-control mb-3" placeholder="What Job are you looking for?" value="${appointment.appointmentJob}" required></input>
              
              <label for="appointment-date-update">Your available Date<span class="text-danger">&nbsp;*</span></label>
              <input type="date" name="appointmentDate" id="appointment-date-update" 
              class="form-control mb-3" value="${appointment.getAppointmentDate()}" required></input>
              
              <label for="appointment-time">Your available Time<span class="text-danger">&nbsp;*</span></label>
              <input type="time" name="appointmentTime" id="appointment-time" 
              class="form-control mb-3" value="${appointment.getAppointmentTime()}" required></input>
              
              <label for="appointment-desc-update">Description</label>
              <textarea name="appointmentDescription" id="appointment-desc-update" 
              class="form-control mb-3" placeholder="Is there anything you'd like to say? (Optional)"><c:out value="${appointment.getAppointmentDescription()}"></c:out></textarea>
              
              <input type="hidden" name="actiontype" value="edit-appointment"/>
              <button type="submit" id="submit-btn" class="btn btn-dark py-3">Save changes</button>
              <!-- END OF UPDATE -->
            </form>
          </div>
      </div>
    </div>
    <footer class="bg-dark text-white text-center py-3">
      <div class="container">
        <p class="my-auto">&copy; 2023 The Jobs&trade;</p>        
      </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <script>
      let appointmentIdField = document.getElementById('appointment-id');
      let searchButton = document.getElementById('search-btn');
      // Event listener to enable/disable the search button when there is no input
      appointmentIdField.addEventListener('input', function() {
          if (appointmentIdField.value.trim() === '') {
            searchButton.classList.add('disabled');
          } else {
          	searchButton.classList.remove('disabled');
          }
      });
    </script>
  </body>
</html>