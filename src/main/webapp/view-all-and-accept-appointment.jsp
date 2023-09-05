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
    <nav class="navbar navbar-expand-lg bg-dark mb-5 py-4" data-bs-theme="dark">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">The Jobs&trade;</a>
        <a class="btn btn-outline-light" href="getconsultant?actiontype=logout-consultant">Logout</a>
      </div>
    </nav>
    <div class="container">
      <h2 class="text-center my-5">Consultant Dashboard</h2>
      <div class="card mb-5" style="max-width: 1100px; margin-inline: auto">
        <!-- Nav bar header -->
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs justify-content-center">
              <li class="nav-item">
                <a class="nav-link active" aria-current="true" href="#">View all Appointments</a>
              </li>
            </ul>
          </div>
          <!-- End of Nav bar header -->
          <div class="card-body">
            <%
              String feedbackAccept = (String) session.getAttribute("feedbackAccept");
              
              // Check if feedbackAccept is not null and display it
              if (feedbackAccept != null) {
                out.println("<p class=\"text-success text-center mt-4 fw-bolder\">" + feedbackAccept + "</p>");
                    
                // Remove the attribute from the session
                session.removeAttribute("feedbackAccept");
              }
            %> 
            <table class="mt-5 table table-striped-columns table-bordered table-hover" style="margin-inline: auto">
              <thead class="table-group-divider">
                <tr class="table-dark text-center">
                  <th>Appointment #</th>
                  <th>Destination Country</th>
                  <th>Preferred Job</th>
                  <th class="text-nowrap">Date <br><small>(DD-MM-YYYY)</small></th>
                  <th class="text-nowrap">Time <small>(24H)</small></th>
                  <th>Description</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="appointment" items="${appointments}">
                    <tr class="text-center">
                      <td>${appointment.appointmentId}</td>
                      <td>${appointment.appointmentCountry}</td>
                      <td>${appointment.appointmentJob}</td>
                      <td class="text-nowrap">${appointment.appointmentDate}</td>
                      <td>${appointment.appointmentTime}</td>
                      <td class="text-start">${appointment.appointmentDescription}</td>
                      <td>
                        <form action="appointmentmanager" method="post">
                          <input type="hidden" name="appointmentId" value="${appointment.appointmentId}"/>
                          <input type="hidden" name="actiontype" value="accept-appointment"/>
                          <button type="submit" class="btn btn-dark btn-sm">Accept Appointment</button>
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