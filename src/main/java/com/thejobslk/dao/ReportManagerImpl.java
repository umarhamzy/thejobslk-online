package com.thejobslk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thejobslk.dao.dbutil.DbDriverManager;
import com.thejobslk.dao.dbutil.DbDriverManagerFactory;

public class ReportManagerImpl implements ReportManager {

  public ReportManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
    DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");

    return driverManager.getConnection();
  }

  @Override
  public int getNumberOfAppointments() throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "SELECT COUNT(*) FROM appointment";

    int numberOfAppointments = 0;
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          numberOfAppointments = resultSet.getInt(1);
        }
      }
    }
    return numberOfAppointments;
  }

  @Override
  public int getNumberOfJobSeekers() throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "SELECT COUNT(*) FROM jobseeker";

    int numberOfJobseekers = 0;

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          numberOfJobseekers = resultSet.getInt(1);
        }
      }
    }
    return numberOfJobseekers;
  }

  @Override
  public int getNumberOfConsultants() throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "SELECT COUNT(*) FROM consultant";
    
    int numberOfConsultants = 0;

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          numberOfConsultants = resultSet.getInt(1);
        }
      }
    }
    return numberOfConsultants;
  }
}
