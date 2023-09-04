package com.thejobslk.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejobslk.model.Consultant;
import com.thejobslk.service.ConsultantService;

public class ConsultantController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  String message = "";

  private ConsultantService getConsultantService() {
    return ConsultantService.getConsultantService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionType = request.getParameter("actiontype");

    if (actionType.equals("logout-consultant")) {
      logoutConsultant(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionType = request.getParameter("actiontype");

    if (actionType.equals("login-consultant")) {
      loginConsultant(request, response);
    }
  }

//  private void addConsultant(HttpServletRequest request, HttpServletResponse response) {
//
//  }
//
//  private void editConsultant(HttpServletRequest request, HttpServletResponse response) {
//
//  }
//
//  private void deleteConsultant(HttpServletRequest request, HttpServletResponse response) {
//
//  }
//
//  private void getConsultant(HttpServletRequest request, HttpServletResponse response) {
//
//  }
//
//  private void getAllConsultants(HttpServletRequest request, HttpServletResponse response) {
//    clearMessage();
//
//  }

  private void loginConsultant(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    String username = request.getParameter("consultantUsername");
    String password = request.getParameter("consultantPassword");

    try {
      // Use the service to authenticate the user
      ConsultantService consultantService = getConsultantService();
      Consultant authenticatedConsultant = consultantService.authenticateConsultant(username, password);

      if (authenticatedConsultant != null) {
        // If credentials are valid
        // Store user information in session
        request.getSession().setAttribute("authenticatedConsultant", authenticatedConsultant);

        response.sendRedirect("getappointment?actiontype=get-all-accept-each");
      } else {
        // If credentials are incorrect
        message = "Authentication failed!</br>Please check your credentials.";

        request.setAttribute("errorFeedback", message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("consultant-login.jsp");
        requestDispatcher.forward(request, response);

      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
  }

  private void logoutConsultant(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Invalidate the user's session to log them out
    request.getSession().invalidate();

    // Redirect to login page
    response.sendRedirect("consultant-login.jsp");
  }

  // UTILITY
  private void clearMessage() {
    message = "";
  }

}
