package com.theladders.solid.srp;

import java.util.Collections;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpSession;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.FailedApplication;
import com.theladders.solid.srp.job.application.JobApplicationRepository;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.ActiveResumeRepository;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.srp.resume.ResumeRepository;

import static org.junit.Assert.assertTrue;

public class ApplierTest
{


  private JobApplicationRepository jobApplicationRepository;
  private Applier                  applier;
  private HttpRequest              httpRequest;
  private Job                      job;
  private String                   filename;
  private Jobseeker jobseeker;


  @Before
  public void setup()
  {
    jobseeker = new Jobseeker(1, true);
    Map<String, String> map = Collections.emptyMap();
    httpRequest = new HttpRequest(new HttpSession(jobseeker), map);
    job = new Job(2);
    filename = "filename";

    ResumeRepository resumeRepository = new ResumeRepository();
    ActiveResumeRepository activeResumeRepository = new ActiveResumeRepository();
    ResumeManager resumeManager = new ResumeManager(resumeRepository);
    MyResumeManager myResumeManager = new MyResumeManager(activeResumeRepository);

    jobApplicationRepository = new JobApplicationRepository();
    JobApplicationSystem jobApplicationSystem = new JobApplicationSystem(jobApplicationRepository);
    applier = new Applier(jobApplicationSystem, resumeManager, myResumeManager);
  }

  @Test
  public void testApplyWithValidApplication()
  {
    applier.apply(httpRequest, job, filename);
    assertTrue(jobApplicationRepository.applicationExistsFor(jobseeker, job));
  }


  @Test(expected = ApplicationFailureException.class)
  public void testApplyWithValidApplicationAgain()
  {
    applier.apply(httpRequest, job, filename);
    assertTrue(jobApplicationRepository.applicationExistsFor(jobseeker, job));

    applier.apply(httpRequest, job, filename);
  }


}

