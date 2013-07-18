package com.theladders.solid.srp;

import java.util.HashMap;
import java.util.Map;

import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class ProvideView
{
  private final HttpResponse     response;
  private final int              jobId;
  private final JobseekerProfile jobseekerProfile;
  private final Job              job;
  private final Jobseeker        jobseeker;


  public ProvideView(HttpResponse response,
                     int jobId,
                     Jobseeker jobseeker,
                     JobseekerProfile jobseekerProfile,
                     Job job)
  {
    this.response = response;
    this.jobId = jobId;
    this.jobseeker = jobseeker;
    this.jobseekerProfile = jobseekerProfile;
    this.job = job;
  }


  public void provide()
  {
    Map<String, Object> model = new HashMap<>();
    model.put(ApplyController.JOB_ID, jobId);
    model.put(ApplyController.JOB_TITLE, job.getTitle());

    if (shouldDoCompletionView(jobseeker))
    {
      provideResumeCompletionView(response, model);
    }
    else
    {
      provideApplySuccessView(response, model);
    }
  }


  private boolean shouldDoCompletionView(Jobseeker jobseeker)
  {
    return (!jobseeker.isPremium() && (jobseekerProfile.getStatus().equals(ProfileStatus.INCOMPLETE) ||
                                       jobseekerProfile.getStatus().equals(ProfileStatus.NO_PROFILE) ||
                                       jobseekerProfile.getStatus().equals(ProfileStatus.REMOVED)));
  }

  private void provideApplySuccessView(HttpResponse response, Map<String, Object> model)
  {
    Result result = new Result(Result.Type.SUCCESS, model);
    response.setResult(result);
  }

  private void provideResumeCompletionView(HttpResponse response, Map<String, Object> model)
  {
    Result result = new Result(Result.Type.COMPLETE_RESUME_PLEASE, model);
    response.setResult(result);
  }


}

