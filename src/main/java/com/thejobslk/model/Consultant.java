package com.thejobslk.model;

public class Consultant {

  private int consultantId;
  private String consultantFirstName;
  private String consultantLastName;
  private String consultantUsername;
  private String consultantEmail;
  private String consultantPassword;
  private String consultantCountry;
  private String consultantJobtype;

  public Consultant() {
    // TODO Auto-generated constructor stub
  }

  public Consultant(int consultantId, String consultantFirstName, String consultantLastName, String consultantUsername,
      String consultantEmail, String consultantPassword, String consultantCountry, String consultantJobtype) {
    this.consultantId = consultantId;
    this.consultantFirstName = consultantFirstName;
    this.consultantLastName = consultantLastName;
    this.consultantUsername = consultantUsername;
    this.consultantEmail = consultantEmail;
    this.consultantPassword = consultantPassword;
    this.consultantCountry = consultantCountry;
    this.consultantJobtype = consultantJobtype;
  }

  public int getConsultantId() {
    return consultantId;
  }

  public void setConsultantId(int consultantId) {
    this.consultantId = consultantId;
  }

  public String getConsultantFirstName() {
    return consultantFirstName;
  }

  public void setConsultantFirstName(String consultantFirstName) {
    this.consultantFirstName = consultantFirstName;
  }

  public String getConsultantLastName() {
    return consultantLastName;
  }

  public void setConsultantLastName(String consultantLastName) {
    this.consultantLastName = consultantLastName;
  }

  public String getConsultantUsername() {
    return consultantUsername;
  }

  public void setConsultantUsername(String consultantUsername) {
    this.consultantUsername = consultantUsername;
  }

  public String getConsultantEmail() {
    return consultantEmail;
  }

  public void setConsultantEmail(String consultantEmail) {
    this.consultantEmail = consultantEmail;
  }

  public String getConsultantPassword() {
    return consultantPassword;
  }

  public void setConsultantPassword(String consultantPassword) {
    this.consultantPassword = consultantPassword;
  }

  public String getConsultantCountry() {
    return consultantCountry;
  }

  public void setConsultantCountry(String consultantCountry) {
    this.consultantCountry = consultantCountry;
  }

  public String getConsultantJobtype() {
    return consultantJobtype;
  }

  public void setConsultantJobtype(String consultantJobtype) {
    this.consultantJobtype = consultantJobtype;
  }

}
