package com.thejobslk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.thejobslk.dao.dbutil.DbDriverManager;
import com.thejobslk.dao.dbutil.DbDriverManagerFactory;
import com.thejobslk.model.Manager;

public class ManagerManagerImpl implements ManagerManager {

  public ManagerManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
    DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");

    return driverManager.getConnection();
  }

  @Override
  public boolean addManager(Manager manager) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean editManager(Manager manager) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteManager(int managerId) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getManager(int managerId) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Manager> getAllManagers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Manager getManagerByUsername(String username) throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "SELECT * FROM manager WHERE manager_username=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, username);

    ResultSet resultSet = preparedStatement.executeQuery();

    Manager manager = null;

    if (resultSet.next()) {
      // Create a Jobseeker object and populate it with data from the result set
      manager = new Manager();
      manager.setManagerId(resultSet.getInt("manager_id"));
      manager.setManagerUsername(resultSet.getString("manager_username"));
      manager.setManagerPassword(resultSet.getString("manager_password"));
    }

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();

    return manager;
  }

}
