package com.thejobslk.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejobslk.model.Appointment;
import com.thejobslk.service.AppointmentService;

/**
 * Servlet implementation class AppointmentController
 */
public class AppointmentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  String message = "";

  private AppointmentService getAppointmentService() {
    return AppointmentService.getAppointmentService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-appointment.jsp");
    requestDispatcher.forward(request, response);
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

    Appointment appointment = new Appointment();
    appointment.setAppointmentCountry(request.getParameter("appointmentCountry"));
    appointment.setAppointmentJob(request.getParameter("appointmentJob"));
    appointment.setAppointmentDate(request.getParameter("appointmentDate"));
    appointment.setAppointmentTime(request.getParameter("appointmentTime"));
    appointment.setAppointmentDescription(request.getParameter("appointmentDescription"));

    try {
      if (getAppointmentService().addAppointment(appointment)) {
        message = "You have successfully booked an appointment!";
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

  private void editAppointment(HttpServletRequest request, HttpServletResponse response) {

  }

  private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) {

  }

  private void getAppointment(HttpServletRequest request, HttpServletResponse response) {

  }

  private void getAllAppointments(HttpServletRequest request, HttpServletResponse response) {

  }
}
