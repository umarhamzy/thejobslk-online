package com.thejobslk.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejobslk.model.Manager;
import com.thejobslk.service.ManagerService;

/**
 * Servlet implementation class ManagerController
 */
public class ManagerController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  String message = "";

  public ManagerService getManagerService() {
    return ManagerService.getManagerService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionType = request.getParameter("actiontype");

    if (actionType.equals("logout-manager")) {
      logoutManager(request, response);
    } else {
      try {
        displayReport(request, response);
      } catch (ClassNotFoundException | SQLException | IOException e) {
        message = e.getMessage();
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionType = request.getParameter("actiontype");

    if (actionType.equals("login-manager")) {
      loginManager(request, response);
    }
  }

  /*
   * private void addManager(HttpServletRequest request, HttpServletResponse
   * response) {
   * 
   * }
   * 
   * private void editManager(HttpServletRequest request, HttpServletResponse
   * response) {
   * 
   * }
   * 
   * private void deleteManager(HttpServletRequest request, HttpServletResponse
   * response) {
   * 
   * }
   * 
   * private void getManager(HttpServletRequest request, HttpServletResponse
   * response) {
   * 
   * }
   * 
   * private void getAllManagers(HttpServletRequest request, HttpServletResponse
   * response) {
   * 
   * }
   */

  private void loginManager(HttpServletRequest request, HttpServletResponse response) {
    clearMessage();

    String username = request.getParameter("managerUsername");
    String password = request.getParameter("managerPassword");

    try {
      ManagerService managerService = getManagerService();
      Manager authenticatedManager = managerService.authenticateManager(username, password);

      if (authenticatedManager != null) {
        request.getSession().setAttribute("authenticatedManager", authenticatedManager);

        response.sendRedirect("manager-dashboard.jsp");
      } else {
        message = "Authentication failed!</br>Please check your credentials.";

        request.setAttribute("errorFeedback", message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager-login.jsp");
        requestDispatcher.forward(request, response);
      }
    } catch (Exception e) {
      message = e.getMessage();
    }
  }

  private void logoutManager(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Invalidate the user's session to log them out
    request.getSession().invalidate();

    // Redirect to login page
    response.sendRedirect("manager-login.jsp");
  }

  private void displayReport(HttpServletRequest request, HttpServletResponse response)
      throws ClassNotFoundException, SQLException, IOException {
    ManagerService managerService = ManagerService.getManagerService();

    int numberOfAppointments = managerService.getNumberOfAppointments();
    int numberOfJobseekers = managerService.getNumberOfJobseekers();
    int numberOfConsultants = managerService.getNumberOfConsultants();

    request.setAttribute("numAppointments", numberOfAppointments);
    request.setAttribute("numJobseekers", numberOfJobseekers);
    request.setAttribute("numConsultants", numberOfConsultants);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager-dashboard.jsp");
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      // TODO Auto-generated catch block
      message = e.getMessage();
    }
  }

  private void clearMessage() {
    message = "";
  }

}
