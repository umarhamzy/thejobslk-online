package com.thejobslk.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thejobslk.model.Appointment;
import com.thejobslk.service.AppointmentService;

public class AppointmentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  String message = "";

  private AppointmentService getAppointmentService() {
    return AppointmentService.getAppointmentService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-appointment.jsp");
// requestDispatcher.forward(request, response);

    // checking to see what actiontype is received from the .jsp- accordingly we use
    // the proper function to execute
    String actionType = request.getParameter("actiontype");

    if (actionType.equals("search-appointment")) {
      getAppointment(request, response);
    } else if (actionType.equals("get-all-delete-each")) {
      getAllAppointmentsForJobSeeker(request, response);
    } else if (actionType.equals("get-all-accept-each")) {
      getAllAppointmentsForConsultant(request, response);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String actionType = request.getParameter("actiontype");

    if (actionType.equals("add-appointment")) {
      addAppointment(request, response);
    } else if (actionType.equals("edit-appointment")) {
      editAppointment(request, response);
    } else if (actionType.equals("delete-appointment")) {
      deleteAppointment(request, response);
    }
  }

  private void addAppointment(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    Appointment appointment = new Appointment();

    // setting values received from .jsp to model class setters.
    // request.getParameter("value") where value should match the name attribute in
    // jsp input fields.
    appointment.setAppointmentCountry(request.getParameter("appointmentCountry"));
    appointment.setAppointmentJob(request.getParameter("appointmentJob"));
    appointment.setAppointmentDate(request.getParameter("appointmentDate"));
    appointment.setAppointmentTime(request.getParameter("appointmentTime"));
    appointment.setAppointmentDescription(request.getParameter("appointmentDescription"));

    try {
      if (getAppointmentService().addAppointment(appointment)) {
        message = "You have successfully booked an appointment!</br>You will receive an email confirming your appointment.";
      } else {
        message = "Something went wrong!";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();

    }
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-appointment.jsp");
    requestDispatcher.forward(request, response);
  }

  private void editAppointment(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    Appointment appointment = new Appointment();

    appointment.setAppointmentId(Integer.parseInt(request.getParameter("appointmentId")));
    appointment.setAppointmentCountry(request.getParameter("appointmentCountry"));
    appointment.setAppointmentJob(request.getParameter("appointmentJob"));
    appointment.setAppointmentDate(request.getParameter("appointmentDate"));
    appointment.setAppointmentTime(request.getParameter("appointmentTime"));
    appointment.setAppointmentDescription(request.getParameter("appointmentDescription"));

    try {
      if (getAppointmentService().editAppointment(appointment)) {
        message = "Your appointment is rescheduled to: " + appointment.getAppointmentDate() + " at "
            + appointment.getAppointmentTime();
      } else {
        message = "Something went wrong trying to edit your changes!";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();

    }

    request.setAttribute("feedback", message);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("search-and-update-appointment.jsp");
    requestDispatcher.forward(request, response);
  }

  private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    clearMessage();

    int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

    try {
      if (getAppointmentService().deleteAppointment(appointmentId)) {
        message = "Your scheduled appointment was cancelled!<br>You can book one anytime, we're ready to serve you!";
      } else {
        message = "Something went wrong trying to cancel your appointment!";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }

    HttpSession session = request.getSession();
    session.setAttribute("feedbackDelete", message);
    response.sendRedirect("getappointment?actiontype=all");
  }

  private void getAppointment(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

    try {
      Appointment appointment = getAppointmentService().getAppointment(appointmentId);
      if (appointment.getAppointmentId() > 0) {
        request.setAttribute("appointment", appointment);
      } else {
        message = "No such record found";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("search-and-update-appointment.jsp");
    requestDispatcher.forward(request, response);

  }

  private void getAllAppointmentsForJobSeeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    clearMessage();

    List<Appointment> appointments = new ArrayList<Appointment>();

    try {
      appointments = getAppointmentService().getAllAppointments();

      if (!(appointments.size() > 0)) {
        message = "No records exist";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }

    request.setAttribute("appointments", appointments);
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-all-and-delete-appointment.jsp");
    requestDispatcher.forward(request, response);

  }

  private void getAllAppointmentsForConsultant(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    clearMessage();

    List<Appointment> appointments = new ArrayList<Appointment>();

    try {
      appointments = getAppointmentService().getAllAppointments();

      if (!(appointments.size() > 0)) {
        message = "No records exist";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }

    request.setAttribute("appointments", appointments);
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-all-and-accept-appointment.jsp");
    requestDispatcher.forward(request, response);

  }

  // UTILITY
  private void clearMessage() {
    message = "";
  }
}
