package com.thejobslk.service;

import java.util.List;

import com.thejobslk.dao.JobseekerManager;
import com.thejobslk.dao.JobseekerManagerImpl;
import com.thejobslk.model.Jobseeker;

public class JobseekerService {

  private static JobseekerService getJobseekerServiceObj;

  private JobseekerService() {
    // TODO Auto-generated constructor stub
  }

  public static JobseekerService getJobseekerServiceObj() {
    if (getJobseekerServiceObj == null) {
      synchronized (JobseekerService.class) {
        if (getJobseekerServiceObj == null) {
          return new JobseekerService();
        }
      }
    }
    return getJobseekerServiceObj;
  }

  public JobseekerManager getJobseekerManager() {
    return new JobseekerManagerImpl();
  }

  public boolean addJobseeker(Jobseeker jobseeker) {
    return getJobseekerManager().addJobseeker(jobseeker);
  }

  public boolean editJobseeker(Jobseeker jobseeker) {
    return getJobseekerManager().editJobseeker(jobseeker);
  }

  public boolean deleteJobseeker(int jobseekerId) {
    return getJobseekerManager().deleteJobseeker(jobseekerId);
  }

  public Jobseeker getJobseeker(int jobseekerId) {
    return getJobseekerManager().getJobseeker(jobseekerId);
  }

  public List<Jobseeker> getAllJobseekers() {
    return getJobseekerManager().getAllJobseekers();
  }

}
