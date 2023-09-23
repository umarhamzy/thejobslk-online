package com.thejobslk.dao;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.model.Manager;

public interface ManagerManager {

  public boolean addManager(Manager manager);

  public boolean editManager(Manager manager);

  public boolean deleteManager(int managerId);

  public int getManager(int managerId);

  public List<Manager> getAllManagers();

  public Manager getManagerByUsername(String username) throws ClassNotFoundException, SQLException;

}
