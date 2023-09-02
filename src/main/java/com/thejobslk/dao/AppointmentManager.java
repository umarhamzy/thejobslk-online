package com.thejobslk.dao;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.model.Appointment;

public interface AppointmentManager {

  public boolean addAppointment(Appointment appointment) throws SQLException, ClassNotFoundException;

  public boolean editAppointment(Appointment appointment) throws SQLException, ClassNotFoundException;

  public boolean deleteAppointment(int appointmentId) throws SQLException, ClassNotFoundException;

  public Appointment getAppointment(int appointmentId) throws SQLException, ClassNotFoundException;

  public List<Appointment> getAllAppointments() throws SQLException, ClassNotFoundException;
}
