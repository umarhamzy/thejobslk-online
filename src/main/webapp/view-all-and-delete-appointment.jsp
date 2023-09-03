<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Jobs | View All and Cancel Appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!--     <link rel="stylesheet" href="styles/appointment.css"> -->
    <link rel="stylesheet" href="styles/style.css">
  </head>
  <body>
    <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">The Jobs</a>
      </div>
    </nav>
    <div class="container">
      <h2 class="text-center my-5">Your journey is our prime vision!</h2>
      <div class="card mb-5" style="max-width: 1100px; margin-inline: auto">
        <!-- Nav bar header -->
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs justify-content-center">
              <li class="nav-item">
                <a class="nav-link" href="add-appointment.jsp">Book Appointment</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="search-and-update-appointment.jsp">Search Appointment</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="true" href="#">View all Appointments</a>
              </li>
            </ul>
          </div>
          <!-- End of Nav bar header -->
          <div class="card-body">
            <h5 class="card-title text-center mt-5 mb-2">Get expert advice from our range of consultants!</h5>
            <%
              String feedbackDelete = (String) session.getAttribute("feedbackDelete");
              
              // Check if feedbackDelete is not null and display it
              if (feedbackDelete != null) {
                out.println("<p class=\"text-success text-center mb-3\" style=\"font-weight: 600\">" + feedbackDelete + "</p>");
              
                // Remove the attribute from the session
                session.removeAttribute("feedbackDelete");
              }
            %> 
            <table class="mt-5 table table-striped-columns table-bordered table-hover" style="margin-inline: auto">
              <thead class="table-group-divider">
                <tr class="table-dark text-center">
                  <th>Appointment Index</th>
                  <th>Destination Country</th>
                  <th>Preferred Job</th>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Description</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="appointment" items="${appointments}">
                    <tr>
                      <td style="font-weight:bold;">${appointment.appointmentId}</td>
                      <td>${appointment.appointmentCountry}</td>
                      <td>${appointment.appointmentJob}</td>
                      <td class="text-nowrap">${appointment.appointmentDate}</td>
                      <td>${appointment.appointmentTime}</td>
                      <td>${appointment.appointmentDescription}</td>
                      <td>
                        <form action="appointmentmanager" method="post">
                          <input type="hidden" name="appointmentId" value="${appointment.appointmentId}"/>
                          <input type="hidden" name="actiontype" value="delete-appointment"/>
                          <button type="submit" class="btn btn-dark btn-sm">Cancel Appointment</button>
                        </form>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>