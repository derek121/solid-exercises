package com.theladders.solid.srp;

import java.util.Arrays;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;

public class ApplyController
{
  public static final String JOB_ID    = "jobId";
  public static final String JOB_TITLE = "jobTitle";

  private final JobseekerProfileManager jobseekerProfileManager;

  private final Applier          applier;
  private final JobSearchService jobSearchService;


  public ApplyController(JobseekerProfileManager jobseekerProfileManager,
                         JobSearchService jobSearchService,
                         JobApplicationSystem jobApplicationSystem,
                         ResumeManager resumeManager,
                         MyResumeManager myResumeManager)
  {
    this.jobseekerProfileManager = jobseekerProfileManager;
    this.jobSearchService = jobSearchService;

    this.applier = new Applier(jobApplicationSystem, resumeManager, myResumeManager);
  }


  public HttpResponse handle(HttpRequest request,
                             HttpResponse response,
                             String origFileName)
  {
    int jobId = getJobId(request);
    if (!jobSearchService.validateJobId(jobId))
    {
      new ResponseViewInvalidJob(jobId).computeResponse(response);
      return response;
    }

    return apply(request,
                 response,
                 origFileName,
                 request.getSession().getJobseeker(),
                 getJob(jobId));
  }


  private HttpResponse apply(HttpRequest request,
                             HttpResponse response,
                             String origFileName,
                             Jobseeker jobseeker,
                             Job job)
  {
    String whichResume = request.getParameter(HttpRequest.WHICH_RESUME);
    String makeResumeActive = request.getParameter(HttpRequest.MAKE_RESUME_ACTIVE);

    try
    {
      applier.apply(jobseeker, job, origFileName, whichResume, makeResumeActive);
    }
    catch (Exception e)
    {
      new ResponseViewError(Arrays.asList("We could not process your application.")).computeResponse(response);
      return response;
    }

    ResponseView responseView = ResponseView.create(
            jobseeker, jobseekerProfileManager.getJobSeekerProfile(jobseeker).getStatus());
    responseView.computeResponse(response);
    return response;
  }


  private int getJobId(HttpRequest request)
  {
    String jobIdString = request.getParameter(HttpRequest.JOB_ID);
    return Integer.parseInt(jobIdString);
  }


  private Job getJob(int jobId)
  {
    Job job = jobSearchService.getJob(jobId);
    return job;
  }

}

