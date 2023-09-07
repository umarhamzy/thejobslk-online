package com.thejobslk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejobslk.service.ManagerService;

/**
 * Servlet implementation class ManagerController
 */
public class ManagerController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ManagerService getManagerService() {
    return ManagerService.getManagerService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  private void addManager(HttpServletRequest request, HttpServletResponse response) {

  }

  private void editManager(HttpServletRequest request, HttpServletResponse response) {

  }

  private void deleteManager(HttpServletRequest request, HttpServletResponse response) {

  }

  private void getManager(HttpServletRequest request, HttpServletResponse response) {

  }

  private void getAllManagers(HttpServletRequest request, HttpServletResponse response) {

  }

}
