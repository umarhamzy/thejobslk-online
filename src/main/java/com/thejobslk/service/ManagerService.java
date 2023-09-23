package com.thejobslk.service;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.dao.ManagerManager;
import com.thejobslk.dao.ManagerManagerImpl;
import com.thejobslk.dao.ReportManager;
import com.thejobslk.model.Manager;

public class ManagerService {

  private static ManagerService managerServiceObj;
  private ReportManager reportManager;

  private ManagerService() {
    // TODO Auto-generated constructor stub
  }

  public static ManagerService getManagerService() {
    if (managerServiceObj == null) {
      synchronized (ManagerService.class) {
        if (managerServiceObj == null) {
          managerServiceObj = new ManagerService();
        }
      }
    }
    return managerServiceObj;
  }

  public ManagerManager getManagerManager() {
    return new ManagerManagerImpl();
  }

  public boolean addManager(Manager manager) {
    return getManagerManager().addManager(manager);
  }

  public boolean editManager(Manager manager) {
    return getManagerManager().editManager(manager);
  }

  public boolean deleteManager(int managerId) {
    return getManagerManager().deleteManager(managerId);
  }

  public int getManager(int managerId) {
    return getManagerManager().getManager(managerId);
  }

  public List<Manager> getAllManagers() {
    return getManagerManager().getAllManagers();
  }

  public Manager authenticateManager(String username, String password) throws ClassNotFoundException, SQLException {
    ManagerManager managerManager = getManagerManager();
    Manager manager = managerManager.getManagerByUsername(username);

    if (manager != null && manager.getManagerPassword().equals(password)) {
      return manager;
    } else {
      return null;
    }
  }

  public int getNumberOfAppointments() throws ClassNotFoundException, SQLException {
    return reportManager.getNumberOfAppointments();
  }

  public int getNumberOfJobseekers() throws ClassNotFoundException, SQLException {
    return reportManager.getNumberOfJobSeekers();
  }

  public int getNumberOfConsultants() throws ClassNotFoundException, SQLException {
    return reportManager.getNumberOfConsultants();
  }

}
