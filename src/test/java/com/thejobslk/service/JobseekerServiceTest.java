package com.thejobslk.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.thejobslk.model.Jobseeker;

class JobseekerServiceTest {

  private JobseekerService jobseekerService;

  @BeforeEach
  void setUp() {
    jobseekerService = JobseekerService.getJobseekerService();
  }

  /*
   * TODO FOLLOW THE AAA PATTERN [Arrange Act Assert]
   */

  @Test
  @DisplayName(value = "Testing Jobseeker Register")
  @Disabled
  void testAddJobseeker() {
    // arrange: creating object with test data
    Jobseeker jobseeker = new Jobseeker();
    jobseeker.setJobseekerFirstName("Sherlock");
    jobseeker.setJobseekerLastName("Holmes");
    jobseeker.setJobseekerUsername("sherlockholmes");
    jobseeker.setJobseekerEmail("sherlock@holmes.com");
    jobseeker.setJobseekerPassword("sherlockpass");

    try {
      // act: calling the method to test
      boolean result = jobseekerService.addJobseeker(jobseeker);

      // assert: checking the expected outcome, if not return the message.
      assertTrue(result, "Register Jobseeker returned false. Unexpect function behaviour!");
    } catch (Exception e) {
      fail("Exception occurred: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing Jobseeker Edit")
  @Disabled
  void testEditJobseeker() {

    // arrange: creating object with test data
    Jobseeker jobseeker = new Jobseeker();
    jobseeker.setJobseekerId(11);
    jobseeker.setJobseekerFirstName("Ron");
    jobseeker.setJobseekerLastName("Weasley");
    jobseeker.setJobseekerUsername("ronweasley");
    jobseeker.setJobseekerEmail("ron@weasley.com");
    jobseeker.setJobseekerPassword("ronpass");

    try {
      // act: calling the method to test
      boolean result = jobseekerService.editJobseeker(jobseeker);

      // assert: checking the expected outcome, if not return the message.
      assertTrue(result, "Edit Jobseeker returned false. Unexpect function behaviour!");
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing Jobseeker Delete")
  @Disabled
  void testDeleteJobseeker() {
    int jobseekerIdToDelete = 16;

    try {
      boolean result = jobseekerService.deleteJobseeker(jobseekerIdToDelete);
      assertTrue(result);
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing Jobseeker Search")
  @Disabled
  void testGetJobseeker() {
    int jobseekerIdToGet = 13;

    try {
      // Act: Retrieve the job seeker with the known ID
      Jobseeker jobseeker = jobseekerService.getJobseeker(jobseekerIdToGet);

      // Assert: Check if the retrieved job seeker is not null
      assertNotNull(jobseeker);
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing Jobseeker Fetch All")
//  @Disabled
  void testGetAllJobseekers() {
    try {
      // assuming there are jobseekers available in the db
      assertNotNull(jobseekerService.getAllJobseekers(), "No jobseekers found");
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing with Valid Login")
  void testValidJobseeker() {

    // these entries exist in DB
    String expectedUsername = "testuser";
    String expectedPassword = "testpass";

    try {

      Jobseeker authenticatedJobseeker = jobseekerService.authenticateJobseeker(expectedUsername, expectedPassword);

      // check if the returned Jobseeker is not null -authentication
      // success
      assertNotNull(authenticatedJobseeker, "Authentication should succeed with valid credentials");
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }

  @Test
  @DisplayName(value = "Testing with Invalid Login")
  void testInvalidJobseeker() {

    // these entries exist do not exist in DB
    String testUsername = "fakeuser";
    String testPassword = "fakepass";

    try {

      Jobseeker authenticatedJobseeker = jobseekerService.authenticateJobseeker(testUsername, testPassword);

      // check if the return type is null - restrict access
      assertNull(authenticatedJobseeker);
    } catch (Exception e) {
      fail("Error: " + e.getMessage());
    }
  }
}
