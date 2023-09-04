package com.thejobslk.service;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.dao.ConsultantManager;
import com.thejobslk.dao.ConsultantManagerImpl;
import com.thejobslk.model.Consultant;

public class ConsultantService {

  private static ConsultantService consultantServiceObj;

  private ConsultantService() {
    // TODO Auto-generated constructor stub
  }

  public static ConsultantService getConsultantService() {
    if (consultantServiceObj == null) {
      synchronized (ConsultantService.class) {
        if (consultantServiceObj == null) {
          consultantServiceObj = new ConsultantService();
        }
      }
    }
    return consultantServiceObj;
  }

  public ConsultantManager getConsultantManager() {
    return new ConsultantManagerImpl();
  }

  public boolean addConsultant(Consultant consultant) {
    return getConsultantManager().addConsultant(consultant);
  }

  public boolean editConsultant(Consultant consultant) {
    return getConsultantManager().editConsultant(consultant);
  }

  public boolean deleteConsultant(int consultantId) {
    return getConsultantManager().deleteConsultant(consultantId);
  }

  public Consultant getConsultant(int consultantId) {
    return getConsultantManager().getConsultant(consultantId);
  }

  public List<Consultant> getAllConsultants() {
    return getConsultantManager().getAllConsultants();
  }

  public Consultant authenticateConsultant(String username, String password)
      throws ClassNotFoundException, SQLException {
    ConsultantManager consultantManager = getConsultantManager();
    Consultant consultant = consultantManager.getConsultantByUsername(username);

    if (consultant != null && consultant.getConsultantPassword().equals(password)) {
      // Authentication successful
      return consultant;
    } else {
      // Authentication failed
      return null;
    }
  }
}
