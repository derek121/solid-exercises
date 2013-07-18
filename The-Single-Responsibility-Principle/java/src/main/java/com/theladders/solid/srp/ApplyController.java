package com.theladders.solid.srp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.jobseeker.ProfileStatus;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class ApplyController
{
  private static final String JOB_ID = "jobId";
  private static final String JOB_TITLE = "jobTitle";

  private final JobseekerProfileManager jobseekerProfileManager;
  private final JobSearchService        jobSearchService;
  private final JobApplicationSystem    jobApplicationSystem;
  private final ResumeManager           resumeManager;
  private final MyResumeManager         myResumeManager;


  public ApplyController(JobseekerProfileManager jobseekerProfileManager,
                         JobSearchService jobSearchService,
                         JobApplicationSystem jobApplicationSystem,
                         ResumeManager resumeManager,
                         MyResumeManager myResumeManager)
  {
    this.jobseekerProfileManager = jobseekerProfileManager;
    this.jobSearchService = jobSearchService;
    this.jobApplicationSystem = jobApplicationSystem;
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }


  public HttpResponse handle(HttpRequest request,
                             HttpResponse response,
                             String origFileName)
  {
    int jobId = getJobId(request);
    if (!validateJobId(jobId))
    {
      provideInvalidJobView(response, jobId);
      return response;
    }

    Jobseeker jobseeker = request.getSession().getJobseeker();
    Job job = getJob(jobId);
    try
    {
      apply(request, jobseeker, job, origFileName);
    }
    catch (Exception e)
    {
      provideErrorView(response, Arrays.asList("We could not process your application."));
      return response;
    }

    provideResponseView(response, jobId, jobseeker, job);
    return response;
  }


  private void provideResponseView(HttpResponse response,
                                      int jobId,
                                      Jobseeker jobseeker,
                                      Job job)
  {
    Map<String, Object> model = new HashMap<>();
    model.put(JOB_ID, jobId);
    model.put(JOB_TITLE, job.getTitle());

    // TODO: refactor the if/else
    JobseekerProfile profile = jobseekerProfileManager.getJobSeekerProfile(jobseeker);
    if (!jobseeker.isPremium() && (profile.getStatus().equals(ProfileStatus.INCOMPLETE) ||
                                   profile.getStatus().equals(ProfileStatus.NO_PROFILE) ||
                                   profile.getStatus().equals(ProfileStatus.REMOVED)))
    {
      provideResumeCompletionView(response, model);
    }
    else
    {
      provideApplySuccessView(response, model);
    }
  }


  private boolean validateJobId(int jobId)
  {
    return (jobSearchService.getJob(jobId) != null);
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


  private static void provideApplySuccessView(HttpResponse response, Map<String, Object> model)
  {
    Result result = new Result(Result.Type.SUCCESS, model);
    response.setResult(result);
  }

  private static void provideResumeCompletionView(HttpResponse response, Map<String, Object> model)
  {
    Result result = new Result(Result.Type.COMPLETE_RESUME_PLEASE, model);
    response.setResult(result);
  }

  private static void provideErrorView(HttpResponse response, List<String> errList)
  {
   Result result = new Result(Result.Type.ERROR, new HashMap<String, Object>(), errList);
   response.setResult(result);
  }

  private void apply(HttpRequest request,
                     Jobseeker jobseeker,
                     Job job,
                     String fileName)
  {
    Resume resume = saveNewOrRetrieveExistingResume(fileName,jobseeker, request);
    UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume);
    JobApplicationResult applicationResult = jobApplicationSystem.apply(application);

    if (applicationResult.failure())
    {
      throw new ApplicationFailureException(applicationResult.toString());
    }
  }

  private Resume saveNewOrRetrieveExistingResume(String newResumeFileName,
                                                 Jobseeker jobseeker,
                                                 HttpRequest request)
  {
    Resume resume;

    if (!"existing".equals(request.getParameter(HttpRequest.WHICH_RESUME)))
    {
      resume = resumeManager.saveResume(jobseeker, newResumeFileName);

      if (resume != null && "yes".equals(request.getParameter(HttpRequest.MAKE_RESUME_ACTIVE)))
      {
        myResumeManager.saveAsActive(jobseeker, resume);
      }
    }
    else
    {
      resume = myResumeManager.getActiveResume(jobseeker.getId());
    }

    return resume;
  }

  private static void provideInvalidJobView(HttpResponse response, int jobId)
  {
    Map<String, Object> model = new HashMap<>();
    model.put(HttpRequest.JOB_ID, jobId);

    Result result = new Result(Result.Type.INVALID_JOB, model);
    response.setResult(result);
  }
}
