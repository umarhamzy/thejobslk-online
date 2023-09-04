package com.thejobslk.dao;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.model.Jobseeker;

public interface JobseekerManager {

  public boolean addJobseeker(Jobseeker jobseeker) throws SQLException, ClassNotFoundException;

  public boolean editJobseeker(Jobseeker jobseeker) throws ClassNotFoundException, SQLException;

  public boolean deleteJobseeker(int jobseekerId) throws ClassNotFoundException, SQLException;

  public Jobseeker getJobseeker(int jobseekerId) throws SQLException, ClassNotFoundException;

  public List<Jobseeker> getAllJobseekers() throws ClassNotFoundException, SQLException;

  public Jobseeker getJobseekerByUsername(String username) throws SQLException, ClassNotFoundException;

}
