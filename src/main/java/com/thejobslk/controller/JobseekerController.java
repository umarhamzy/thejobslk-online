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

import com.thejobslk.model.Jobseeker;
import com.thejobslk.service.JobseekerService;

public class JobseekerController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  String message = "";

  private JobseekerService getJobseekerService() {
    return JobseekerService.getJobseekerService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String actionType = request.getParameter("actiontype");

    if (actionType.equals("search-jobseeker")) {
      getJobseeker(request, response);
    } else if (actionType.equals("logout-jobseeker")) {
      logoutJobseeker(request, response);
    } else {
      getAllJobseekers(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String actionType = request.getParameter("actiontype");

    if (actionType.equals("register-jobseeker")) {
      addJobseeker(request, response);
    } else if (actionType.equals("edit-jobseeker")) {
      editJobseeker(request, response);
    } else if (actionType.equals("delete-jobseeker")) {
      deleteJobseeker(request, response);
    } else if (actionType.equals("login-jobseeker")) {
      loginJobseeker(request, response);
    }
  }

  private void addJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();
    Jobseeker jobseeker = new Jobseeker();

    jobseeker.setJobseekerFirstName(request.getParameter("jobseekerFirstName"));
    jobseeker.setJobseekerLastName(request.getParameter("jobseekerLastName"));
    jobseeker.setJobseekerUsername(request.getParameter("jobseekerUsername"));
    jobseeker.setJobseekerEmail(request.getParameter("jobseekerEmail"));
    jobseeker.setJobseekerPassword(request.getParameter("jobseekerPassword"));

    try {
      if (getJobseekerService().addJobseeker(jobseeker)) {
        message = "Your account was successfully created!</br>Please click <kbd>Sign In</kbd> below, if you wish to Sign In";
      } else {
        message = "Something went wrong trying to Register your account";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobseeker-register.jsp");
    requestDispatcher.forward(request, response);

  }

  private void editJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    Jobseeker jobseeker = new Jobseeker();

    jobseeker.setJobseekerFirstName(request.getParameter("jobseekerFirstName"));
    jobseeker.setJobseekerLastName(request.getParameter("jobseekerLastName"));
    jobseeker.setJobseekerUsername(request.getParameter("jobseekerUsername"));
    jobseeker.setJobseekerEmail(request.getParameter("jobseekerEmail"));
    jobseeker.setJobseekerPassword(request.getParameter("jobseekerPassword"));

    try {
      if (getJobseekerService().editJobseeker(jobseeker)) {
        message = "Your account was successfully updated!";
      } else {
        message = "Something went wrong trying to Register your account";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobseeker-login.jsp");
    requestDispatcher.forward(request, response);

  }

  private void deleteJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    int jobseekerId = Integer.parseInt(request.getParameter("jobseekerId"));

    try {
      if (getJobseekerService().deleteJobseeker(jobseekerId)) {
        message = "Your account was deleted!</br> Redirecting you to Sign Up.";
      } else {
        message = "Something went wrong trying to remove your account!";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
    request.setAttribute("feedback", message);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobseeker-login.jsp");
    requestDispatcher.forward(request, response);

//    HttpSession session = request.getSession();
//    session.setAttribute("feedbackDelete", message);
//    response.sendRedirect("getjobseeker?actiontype=all");
  }

  private void getJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    int jobseekerId = Integer.parseInt(request.getParameter("jobseekerId"));

    try {
      Jobseeker jobseeker = getJobseekerService().getJobseeker(jobseekerId);
      if (jobseeker.getJobseekerId() > 0) {
        request.setAttribute("jobseeker", jobseeker);
      } else {
        message = "No such record found";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
    request.setAttribute("feedback", message);

//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
//    requestDispatcher.forward(request, response);
  }

  private void getAllJobseekers(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    List<Jobseeker> jobseekers = new ArrayList<Jobseeker>();

    try {
      jobseekers = getJobseekerService().getAllJobseekers();

      if (!(jobseekers.size() > 0)) {
        message = "No records exist";
      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }

    request.setAttribute("jobseekers", jobseekers);
    request.setAttribute("feedback", message);

    // Add relevant page to redirect
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
//    requestDispatcher.forward(request, response);

  }

  private void loginJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    clearMessage();

    String username = request.getParameter("jobseekerUsername");
    String password = request.getParameter("jobseekerPassword");

    try {
      // Use the service to authenticate the user
      JobseekerService jobseekerService = getJobseekerService();
      Jobseeker authenticatedJobseeker = jobseekerService.authenticateJobseeker(username, password);

      if (authenticatedJobseeker != null) {
        // If credentials are valid
        // Store user information in session
        request.getSession().setAttribute("authenticatedUser", authenticatedJobseeker);

        response.sendRedirect("add-appointment.jsp");
      } else {
        // If credentials are incorrect
        message = "Authentication failed!</br>Please check your credentials.";

        request.setAttribute("errorFeedback", message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobseeker-login.jsp");
        requestDispatcher.forward(request, response);

      }
    } catch (ClassNotFoundException | SQLException e) {
      message = e.getMessage();
    }
  }

  private void logoutJobseeker(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Invalidate the user's session to log them out
    request.getSession().invalidate();

    // Redirect to login page
    response.sendRedirect("jobseeker-login.jsp");
  }

  // UTILITY
  private void clearMessage() {
    message = "";
  }

}
