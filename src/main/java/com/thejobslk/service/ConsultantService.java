package com.thejobslk.service;

import java.util.List;

import com.thejobslk.dao.ConsultantManager;
import com.thejobslk.dao.ConsultantManagerImpl;
import com.thejobslk.model.Consultant;

public class ConsultantService {

  private static ConsultantService consultantServiceObj;

  private ConsultantService() {
    // TODO Auto-generated constructor stub
  }

  public static ConsultantService getConsultantServiceObj() {
    if (consultantServiceObj == null) {
      synchronized (ConsultantService.class) {
        if (consultantServiceObj == null) {
          return new ConsultantService();
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
}
