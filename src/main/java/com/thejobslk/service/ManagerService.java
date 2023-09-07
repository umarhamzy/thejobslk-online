package com.thejobslk.service;

import java.util.List;

import com.thejobslk.dao.ManagerManager;
import com.thejobslk.dao.ManagerManagerImpl;
import com.thejobslk.model.Manager;

public class ManagerService {

  private static ManagerService managerServiceObj;

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

}
