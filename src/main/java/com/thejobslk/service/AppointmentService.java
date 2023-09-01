package com.thejobslk.service;

import java.util.List;

import com.thejobslk.dao.AppointmentManager;
import com.thejobslk.dao.AppointmentManagerImpl;
import com.thejobslk.model.Appointment;

public class AppointmentService {

  // Singleton - Thread safe Singleton with double-checked locking
  private static AppointmentService appointmentServiceObj;

  private AppointmentService() {
    // TODO Auto-generated constructor stub
  }

  public static AppointmentService getAppointmentService() {
    if (appointmentServiceObj == null) {
      synchronized (AppointmentService.class) {
        if (appointmentServiceObj == null) {
          appointmentServiceObj = new AppointmentService();
        }
      }
    }
    return appointmentServiceObj;
  }

  public AppointmentManager getAppointmentManager() {
    return new AppointmentManagerImpl();
  }

  public boolean addAppointment(Appointment appointment) {
    return getAppointmentManager().addAppointment(appointment);
  }

  public boolean editAppointment(Appointment appointment) {
    return getAppointmentManager().editAppointment(appointment);
  }

  public boolean deleteAppointment(int appointmentId) {
    return getAppointmentManager().deleteAppointment(appointmentId);
  }

  public Appointment getAppointment(int appointmentId) {
    return getAppointmentManager().getAppointment(appointmentId);
  }

  public List<Appointment> getAllAppointments() {
    return getAppointmentManager().getAllAppointments();
  }

}
