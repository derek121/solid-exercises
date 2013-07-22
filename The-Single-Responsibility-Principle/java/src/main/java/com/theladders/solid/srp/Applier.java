package com.theladders.solid.srp;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.srp.resume.ResumeSaver;

public class Applier
{
  private final ResumeSaver          resumeSaver;
  private       JobApplicationSystem jobApplicationSystem;


  public Applier(JobApplicationSystem jobApplicationSystem,
                 ResumeManager resumeManager,
                 MyResumeManager myResumeManager)
  {
    this.jobApplicationSystem = jobApplicationSystem;
    this.resumeSaver = new ResumeSaver(resumeManager, myResumeManager);
  }


  public void apply(Jobseeker jobseeker,
                    Job job,
                    String filename,
                    String whichResume,
                    String makeResumeActive)
  {
    Resume resume = resumeSaver.saveNewOrRetrieveExistingResume(
            filename, jobseeker, whichResume, makeResumeActive);

    UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume);
    JobApplicationResult applicationResult = jobApplicationSystem.apply(application);

    if (applicationResult.failure())
    {
      throw new ApplicationFailureException(applicationResult.toString());
    }
  }


}

