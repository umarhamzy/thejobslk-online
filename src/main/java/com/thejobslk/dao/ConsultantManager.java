package com.thejobslk.dao;

import java.util.List;

import com.thejobslk.model.Consultant;

public interface ConsultantManager {

  public boolean addConsultant(Consultant consultant);

  public boolean editConsultant(Consultant consultant);

  public boolean deleteConsultant(int consultantId);

  public Consultant getConsultant(int consultantId);

  public List<Consultant> getAllConsultants();
}
