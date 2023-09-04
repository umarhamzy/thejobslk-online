package com.thejobslk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thejobslk.dao.dbutil.DbDriverManager;
import com.thejobslk.dao.dbutil.DbDriverManagerFactory;
import com.thejobslk.model.Jobseeker;

public class JobseekerManagerImpl implements JobseekerManager {

  public JobseekerManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
    DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");

    return driverManager.getConnection();
  }

  @Override
  public boolean addJobseeker(Jobseeker jobseeker) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    // Writing the query to execute
    String query = "INSERT INTO jobseeker (jobseeker_firstname, jobseeker_lastname, jobseeker_username, jobseeker_email, jobseeker_password) VALUES (?, ?, ?, ?, ?)";

    // Using PreparedStatement instead of normal Statement to prevent SQL injection
    // !VERY IMPORTANT
    PreparedStatement preparedStatement = connection.prepareStatement(query);

    // Adding below entries to the database jobseeker table with data user
    // provides
    preparedStatement.setString(1, jobseeker.getJobseekerFirstName());
    preparedStatement.setString(2, jobseeker.getJobseekerLastName());
    preparedStatement.setString(3, jobseeker.getJobseekerUsername());
    preparedStatement.setString(4, jobseeker.getJobseekerEmail());
    preparedStatement.setString(5, jobseeker.getJobseekerPassword());

    // Checking if the query was executed. If 1: it is executed, if 0: not executed
    boolean result = false;
    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    // Closing the query and connection VERY IMPORTANT!
    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public boolean editJobseeker(Jobseeker jobseeker) throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "UPDATE jobseeker SET jobseeker_firstname=?, jobseeker_lastname=?, jobseeker_username=?, jobseeker_email=?, jobseeker_password=? WHERE jobseeker_id=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setString(1, jobseeker.getJobseekerFirstName());
    preparedStatement.setString(2, jobseeker.getJobseekerLastName());
    preparedStatement.setString(3, jobseeker.getJobseekerUsername());
    preparedStatement.setString(4, jobseeker.getJobseekerEmail());
    preparedStatement.setString(5, jobseeker.getJobseekerPassword());
    preparedStatement.setInt(6, jobseeker.getJobseekerId());

    boolean result = false;

    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public boolean deleteJobseeker(int jobseekerId) throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "DELETE from jobseeker WHERE jobseeker_id=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setInt(1, jobseekerId);

    boolean result = false;

    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public Jobseeker getJobseeker(int jobseekerId) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "SELECT * FROM jobseeker WHERE jobseekerId=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setInt(1, jobseekerId);

    ResultSet resultSet = preparedStatement.executeQuery();

    Jobseeker jobseeker = new Jobseeker();

    while (resultSet.next()) {
      jobseeker.setJobseekerId(resultSet.getInt("jobseeker_id"));
      jobseeker.setJobseekerFirstName(resultSet.getString("jobseeker_firstname"));
      jobseeker.setJobseekerLastName(resultSet.getString("jobseeker_lastname"));
      jobseeker.setJobseekerUsername(resultSet.getString("jobseeker_username"));
      jobseeker.setJobseekerEmail(resultSet.getString("jobseeker_email"));
      jobseeker.setJobseekerPassword(resultSet.getString("jobseeker_password"));
    }

    preparedStatement.close();
    connection.close();

    return jobseeker;
  }

  @Override
  public List<Jobseeker> getAllJobseekers() throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();

    String query = "SELECT * FROM jobseeker";

    Statement statement = connection.createStatement();

    List<Jobseeker> jobseekers = new ArrayList<Jobseeker>();

    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      Jobseeker jobseeker = new Jobseeker();
      jobseeker.setJobseekerFirstName(resultSet.getString("jobseeker_firstname"));
      jobseeker.setJobseekerLastName(resultSet.getString("jobseeker_lastname"));
      jobseeker.setJobseekerUsername(resultSet.getString("jobseeker_username"));
      jobseeker.setJobseekerEmail(resultSet.getString("jobseeker_email"));
      jobseeker.setJobseekerPassword(resultSet.getString("jobseeker_password"));

      jobseekers.add(jobseeker);
    }
    statement.close();
    connection.close();

    return jobseekers;
  }

  @Override
  public Jobseeker getJobseekerByUsername(String username) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "SELECT * FROM jobseeker WHERE jobseeker_username = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, username);

    ResultSet resultSet = preparedStatement.executeQuery();

    Jobseeker jobseeker = null;

    if (resultSet.next()) {
      // Create a Jobseeker object and populate it with data from the result set
      jobseeker = new Jobseeker();
      jobseeker.setJobseekerId(resultSet.getInt("jobseeker_id"));
      jobseeker.setJobseekerFirstName(resultSet.getString("jobseeker_firstname"));
      jobseeker.setJobseekerLastName(resultSet.getString("jobseeker_lastname"));
      jobseeker.setJobseekerUsername(resultSet.getString("jobseeker_username"));
      jobseeker.setJobseekerEmail(resultSet.getString("jobseeker_email"));
      jobseeker.setJobseekerPassword(resultSet.getString("jobseeker_password"));
    }

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();

    return jobseeker;
  }

}
