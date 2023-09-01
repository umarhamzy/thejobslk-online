package com.thejobslk.model;

public class Appointment {

  private int appointmentId;
  private String appointmentCountry;
  private String appointmentJob;
  private String appointmentDate;
  private String appointmentTime;
  private String appointmentDescription;
  private int jobseekerId;
  private int consultantId;

  public Appointment() {
    // TODO Auto-generated constructor stub
  }

  public Appointment(int appointmentId, String appointmentCountry, String appointmentJob, String appointmentDate,
      String appointmentTime, String appointmentDescription, int jobseekerId, int consultantId) {
    this.appointmentId = appointmentId;
    this.appointmentCountry = appointmentCountry;
    this.appointmentJob = appointmentJob;
    this.appointmentDate = appointmentDate;
    this.appointmentTime = appointmentTime;
    this.appointmentDescription = appointmentDescription;
    this.jobseekerId = jobseekerId;
    this.consultantId = consultantId;
  }

  public int getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(int appointmentId) {
    this.appointmentId = appointmentId;
  }

  public String getAppointmentCountry() {
    return appointmentCountry;
  }

  public void setAppointmentCountry(String appointmentCountry) {
    this.appointmentCountry = appointmentCountry;
  }

  public String getAppointmentJob() {
    return appointmentJob;
  }

  public void setAppointmentJob(String appointmentJob) {
    this.appointmentJob = appointmentJob;
  }

  public String getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(String appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public String getAppointmentDescription() {
    return appointmentDescription;
  }

  public void setAppointmentDescription(String appointmentDescription) {
    this.appointmentDescription = appointmentDescription;
  }

  public int getJobseekerId() {
    return jobseekerId;
  }

  public void setJobseekerId(int jobseekerId) {
    this.jobseekerId = jobseekerId;
  }

  public int getConsultantId() {
    return consultantId;
  }

  public void setConsultantId(int consultantId) {
    this.consultantId = consultantId;
  }

}
