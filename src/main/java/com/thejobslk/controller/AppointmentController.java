package com.thejobslk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppointmentController
 */
public class AppointmentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionType = "";

    if (actionType.equals("add")) {

    }
  }

  private void addAppointment(HttpServletRequest request, HttpServletResponse response) {

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
