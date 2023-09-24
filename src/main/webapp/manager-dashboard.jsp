<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1" />
    <title>The Jobs | Manager Dashboard</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="styles/style.css" />
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-dark mb-5 py-4" data-bs-theme="dark">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">The Jobs&trade;</a>
        <a
          class="btn btn-outline-light"
          href="getmanager?actiontype=logout-manager"
          >Logout</a
        >
      </div>
    </nav>
    <section id="statistics">
      <div class="container">
        <form action="getmanager">
          <h1>Statistics</h1>
          <p>Number of Appointments Made: 3 ${numAppointments}</p>
          <p>Number of Jobseekers Registered: 20 ${numJobseekers}</p>
          <p>Number of Consultants Available: 3 ${numConsultants}</p>
        </form>
      </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
