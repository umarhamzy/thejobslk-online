package com.thejobslk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.thejobslk.dao.dbutil.DbDriverManager;
import com.thejobslk.dao.dbutil.DbDriverManagerFactory;
import com.thejobslk.model.Consultant;

public class ConsultantManagerImpl implements ConsultantManager {

  public ConsultantManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
    DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");

    return driverManager.getConnection();
  }

  @Override
  public boolean addConsultant(Consultant consultant) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "INSERT INTO consultant (consultant_fname, consultant_lname, consultant_username, consultant_email, consultant_password, consultant_country, consultant_jobtype) VALUES (?, ?, ?, ?, ?, ?, ?)";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setString(1, consultant.getConsultantFirstName());
    preparedStatement.setString(2, consultant.getConsultantLastName());
    preparedStatement.setString(3, consultant.getConsultantUsername());
    preparedStatement.setString(4, consultant.getConsultantEmail());
    preparedStatement.setString(5, consultant.getConsultantPassword());
    preparedStatement.setString(6, consultant.getConsultantCountry());
    preparedStatement.setString(7, consultant.getConsultantJobtype());

    boolean result = false;
    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public boolean editConsultant(Consultant consultant) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteConsultant(int consultantId) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Consultant getConsultant(int consultantId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Consultant> getAllConsultants() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Consultant getConsultantByUsername(String username) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "SELECT * FROM consultant WHERE consultant_username = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, username);

    ResultSet resultSet = preparedStatement.executeQuery();

    Consultant consultant = null;

    if (resultSet.next()) {
      // Create a Consultant object and populate it with data from the result set
      consultant = new Consultant();
      consultant.setConsultantId(resultSet.getInt("consultant_id"));
      consultant.setConsultantFirstName(resultSet.getString("consultant_fname"));
      consultant.setConsultantLastName(resultSet.getString("consultant_lname"));
      consultant.setConsultantUsername(resultSet.getString("consultant_username"));
      consultant.setConsultantEmail(resultSet.getString("consultant_email"));
      consultant.setConsultantPassword(resultSet.getString("consultant_password"));
      consultant.setConsultantCountry(resultSet.getString("consultant_country"));
      consultant.setConsultantJobtype(resultSet.getString("consultant_jobtype"));
    }

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();

    return consultant;
  }

}
