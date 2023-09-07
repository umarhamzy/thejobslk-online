package com.thejobslk.model;

public class Manager {
  private int managerId;
  private String managerUsername;
  private String managerPassword;

  public Manager() {
    // TODO Auto-generated constructor stub
  }

  public Manager(int managerId, String managerUsername, String managerPassword) {
    super();
    this.managerId = managerId;
    this.managerUsername = managerUsername;
    this.managerPassword = managerPassword;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public String getManagerUsername() {
    return managerUsername;
  }

  public void setManagerUsername(String managerUsername) {
    this.managerUsername = managerUsername;
  }

  public String getManagerPassword() {
    return managerPassword;
  }

  public void setManagerPassword(String managerPassword) {
    this.managerPassword = managerPassword;
  }

}
