package com.thejobslk.dao;

import java.sql.SQLException;

public interface ReportManager {

  int getNumberOfAppointments() throws ClassNotFoundException, SQLException;

  int getNumberOfJobSeekers() throws ClassNotFoundException, SQLException;

  int getNumberOfConsultants() throws ClassNotFoundException, SQLException;

}
