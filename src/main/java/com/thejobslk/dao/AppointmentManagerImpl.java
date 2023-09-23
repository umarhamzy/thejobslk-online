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
import com.thejobslk.model.Appointment;

public class AppointmentManagerImpl implements AppointmentManager {

  public AppointmentManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
    DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");

    return driverManager.getConnection();
  }

  @Override
  public boolean addAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
    // Establishing connection from getConnection() which has the implementation for
    // establishing connection
    Connection connection = getConnection();

    // Writing the query to execute
    String query = "INSERT INTO appointment (appointment_country, appointment_job, appointment_date, appointment_time, appointment_description, jobseeker_id) VALUES (?, ?, ?, ?, ?, ?)";

    // Using PreparedStatement instead of normal Statement to prevent SQL injection
    // !VERY IMPORTANT
    PreparedStatement preparedStatement = connection.prepareStatement(query);

    // Adding below entries to the database appointment table with data user
    // provides
    preparedStatement.setString(1, appointment.getAppointmentCountry());
    preparedStatement.setString(2, appointment.getAppointmentJob());
    preparedStatement.setString(3, appointment.getAppointmentDate());
    preparedStatement.setString(4, appointment.getAppointmentTime());
    preparedStatement.setString(5, appointment.getAppointmentDescription());
    preparedStatement.setInt(6, 4);
    // Above statement is hardcoded till concrete implementation - TO BE REMOVED
    // ONCE PROPER IMPLEMENTATION IN PLACE!
    // preparedStatement.setInt(6, appointment.getJobseekerId());

    // Checking if the query was executed. If 1, it is executed, if 0, not executed
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
  public boolean editAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "UPDATE appointment SET appointment_country=?, appointment_job=?, appointment_date=?, appointment_time=?, appointment_description=?, jobseeker_id=? WHERE appointment_id=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setString(1, appointment.getAppointmentCountry());
    preparedStatement.setString(2, appointment.getAppointmentJob());
    preparedStatement.setString(3, appointment.getAppointmentDate());
    preparedStatement.setString(4, appointment.getAppointmentTime());
    preparedStatement.setString(5, appointment.getAppointmentDescription());
    preparedStatement.setInt(6, 4);
    preparedStatement.setInt(7, appointment.getAppointmentId());

    boolean result = false;

    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public boolean deleteAppointment(int appointmentId) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "DELETE FROM appointment WHERE appointment_id=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setInt(1, appointmentId);

    boolean result = false;

    if (preparedStatement.executeUpdate() > 0) {
      result = true;
    }

    preparedStatement.close();
    connection.close();

    return result;
  }

  @Override
  public Appointment getAppointment(int appointmentId) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();

    String query = "SELECT * FROM appointment WHERE appointment_id=?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);

    preparedStatement.setInt(1, appointmentId);

    ResultSet resultSet = preparedStatement.executeQuery();

    Appointment appointment = new Appointment();

    while (resultSet.next()) {
      appointment.setAppointmentId(resultSet.getInt("appointment_id"));
      appointment.setAppointmentCountry(resultSet.getString("appointment_country"));
      appointment.setAppointmentJob(resultSet.getString("appointment_job"));
      appointment.setAppointmentDate(resultSet.getString("appointment_date"));
      appointment.setAppointmentTime(resultSet.getString("appointment_time"));
      appointment.setAppointmentDescription(resultSet.getString("appointment_description"));
      appointment.setJobseekerId(resultSet.getInt("jobseeker_id"));
      appointment.setConsultantId(resultSet.getInt("consultant_id"));
    }

    preparedStatement.close();
    connection.close();

    return appointment;
  }

  @Override
  public List<Appointment> getAllAppointments() throws SQLException, ClassNotFoundException {
    // Initializing the connection to Database from getConnection which has the
    // implementation to get connection
    Connection connection = getConnection();

    String query = "SELECT * FROM appointment";

    // Using normal Statement here as this query doesn't require any parameters.
    Statement statement = connection.createStatement();

    // Creating an arraylist to store all the rows in the table
    List<Appointment> appointments = new ArrayList<Appointment>();

    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      // Create new instance of Appointment
      Appointment appointment = new Appointment();

      // Setting relevent setters with data obtained from service layer, which gets
      // data from controller.
      appointment.setAppointmentId(resultSet.getInt("appointment_id"));
      appointment.setAppointmentCountry(resultSet.getString("appointment_country"));
      appointment.setAppointmentJob(resultSet.getString("appointment_job"));
      appointment.setAppointmentDate(resultSet.getString("appointment_date"));
      appointment.setAppointmentTime(resultSet.getString("appointment_time"));
      appointment.setAppointmentDescription(resultSet.getString("appointment_description"));
      appointment.setJobseekerId(resultSet.getInt("jobseeker_id"));
      // appointment.setConsultantId(resultSet.getInt(resultSet.getInt("consultant_id")));

      appointments.add(appointment);
    }

    // Closing the query and connection VERY IMPORTANT!
    statement.close();
    connection.close();

    return appointments;
  }

}
