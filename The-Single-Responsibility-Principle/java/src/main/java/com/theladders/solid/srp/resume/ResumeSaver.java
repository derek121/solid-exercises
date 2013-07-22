package com.theladders.solid.srp.resume;

import com.theladders.solid.srp.jobseeker.Jobseeker;

public class ResumeSaver
{
  private final ResumeManager   resumeManager;
  private final MyResumeManager myResumeManager;


  public ResumeSaver(ResumeManager resumeManager,
                     MyResumeManager myResumeManager)
  {

    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }


  public Resume saveNewOrRetrieveExistingResume(String newResumeFileName,
                                                Jobseeker jobseeker,
                                                String whichResume,
                                                String makeResumeActive)
  {
    Resume resume;

    // TODO: replace hardcoded strings
    if (!"existing".equals(whichResume))
    {
      resume = resumeManager.saveResume(jobseeker, newResumeFileName);

      if (resume != null && "yes".equals(makeResumeActive))
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

