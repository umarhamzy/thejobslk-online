package com.thejobslk.dao;

import java.util.List;

import com.thejobslk.model.Jobseeker;

public interface JobseekerManager {

  public boolean addJobseeker(Jobseeker jobseeker);

  public boolean editJobseeker(Jobseeker jobseeker);

  public boolean deleteJobseeker(int jobseekerId);

  public Jobseeker getJobseeker(int jobseekerId);

  public List<Jobseeker> getAllJobseekers();

}
