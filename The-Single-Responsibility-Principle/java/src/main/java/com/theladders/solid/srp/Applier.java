package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class Applier
{
  private       JobApplicationSystem jobApplicationSystem;
  private final ResumeManager        resumeManager;
  private final MyResumeManager      myResumeManager;


  public Applier(JobApplicationSystem jobApplicationSystem,
                 ResumeManager resumeManager,
                 MyResumeManager myResumeManager)
  {
    this.jobApplicationSystem = jobApplicationSystem;
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }


  public void apply(HttpRequest httpRequest,
                    Job job,
                    String filename)
  {
    Jobseeker jobseeker = httpRequest.getSession().getJobseeker();
    Resume resume = saveNewOrRetrieveExistingResume(filename, jobseeker, httpRequest);

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

    // TODO: replace hardcoded strings
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
}

