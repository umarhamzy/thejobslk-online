package com.thejobslk.dao;

import java.util.List;

import com.thejobslk.model.Appointment;

public interface AppointmentManager {

  public boolean addAppointment(Appointment appointment);

  public boolean editAppointment(Appointment appointment);

  public boolean deleteAppointment(int appointmentId);

  public Appointment getAppointment(int appointmentId);

  public List<Appointment> getAllAppointments();
}
