package com.thejobslk.service;

import java.sql.SQLException;
import java.util.List;

import com.thejobslk.dao.JobseekerManager;
import com.thejobslk.dao.JobseekerManagerImpl;
import com.thejobslk.model.Jobseeker;

public class JobseekerService {

  private static JobseekerService jobseekerServiceObj;

  private JobseekerService() {
    // TODO Auto-generated constructor stub
  }

  public static JobseekerService getJobseekerService() {
    if (jobseekerServiceObj == null) {
      synchronized (JobseekerService.class) {
        if (jobseekerServiceObj == null) {
          jobseekerServiceObj = new JobseekerService();
        }
      }
    }
    return jobseekerServiceObj;
  }

  public JobseekerManager getJobseekerManager() {
    return new JobseekerManagerImpl();
  }

  public boolean addJobseeker(Jobseeker jobseeker) throws ClassNotFoundException, SQLException {
    return getJobseekerManager().addJobseeker(jobseeker);
  }

  public boolean editJobseeker(Jobseeker jobseeker) throws ClassNotFoundException, SQLException {
    return getJobseekerManager().editJobseeker(jobseeker);
  }

  public boolean deleteJobseeker(int jobseekerId) throws ClassNotFoundException, SQLException {
    return getJobseekerManager().deleteJobseeker(jobseekerId);
  }

  public Jobseeker getJobseeker(int jobseekerId) throws SQLException, ClassNotFoundException {
    return getJobseekerManager().getJobseeker(jobseekerId);
  }

  public List<Jobseeker> getAllJobseekers() throws ClassNotFoundException, SQLException {
    return getJobseekerManager().getAllJobseekers();
  }

  public Jobseeker authenticateJobseeker(String username, String password) throws ClassNotFoundException, SQLException {
    JobseekerManager jobseekerManager = getJobseekerManager();
    Jobseeker jobseeker = jobseekerManager.getJobseekerByUsername(username);

    if (jobseeker != null && jobseeker.getJobseekerPassword().equals(password)) {
      // Authentication successful
      return jobseeker;
    } else {
      // Authentication failed
      return null;
    }
  }

}
