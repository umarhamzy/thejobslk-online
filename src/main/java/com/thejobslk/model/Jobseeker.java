package com.thejobslk.model;

public class Jobseeker {

  private int jobseekerId;
  private String jobseekerFirstName;
  private String jobseekerLastName;
  private String jobseekerUsername;
  private String jobseekerEmail;
  private String jobseekerPassword;

  public Jobseeker() {
    // TODO Auto-generated constructor stub
  }

  public Jobseeker(int jobseekerId, String jobseekerFirstName, String jobseekerLastName, String jobseekerUsername,
      String jobseekerEmail, String jobseekerPassword) {
    this.jobseekerId = jobseekerId;
    this.jobseekerFirstName = jobseekerFirstName;
    this.jobseekerLastName = jobseekerLastName;
    this.jobseekerUsername = jobseekerUsername;
    this.jobseekerEmail = jobseekerEmail;
    this.jobseekerPassword = jobseekerPassword;
  }

  public int getJobseekerId() {
    return jobseekerId;
  }

  public void setJobseekerId(int jobseekerId) {
    this.jobseekerId = jobseekerId;
  }

  public String getJobseekerFirstName() {
    return jobseekerFirstName;
  }

  public void setJobseekerFirstName(String jobseekerFirstName) {
    this.jobseekerFirstName = jobseekerFirstName;
  }

  public String getJobseekerLastName() {
    return jobseekerLastName;
  }

  public void setJobseekerLastName(String jobseekerLastName) {
    this.jobseekerLastName = jobseekerLastName;
  }

  public String getJobseekerUsername() {
    return jobseekerUsername;
  }

  public void setJobseekerUsername(String jobseekerUsername) {
    this.jobseekerUsername = jobseekerUsername;
  }

  public String getJobseekerEmail() {
    return jobseekerEmail;
  }

  public void setJobseekerEmail(String jobseekerEmail) {
    this.jobseekerEmail = jobseekerEmail;
  }

  public String getJobseekerPassword() {
    return jobseekerPassword;
  }

  public void setJobseekerPassword(String jobseekerPassword) {
    this.jobseekerPassword = jobseekerPassword;
  }

}
