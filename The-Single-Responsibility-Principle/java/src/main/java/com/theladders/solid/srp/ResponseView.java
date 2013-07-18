package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public abstract class ResponseView
{
  public abstract void computeResponse(HttpResponse httpResponse);


  public static ResponseView create(Jobseeker jobseeker,
                                    ProfileStatus profileStatus)
  {
    if (!jobseeker.isPremium() && (profileStatus.equals(ProfileStatus.INCOMPLETE) ||
                                   profileStatus.equals(ProfileStatus.NO_PROFILE) ||
                                   profileStatus.equals(ProfileStatus.REMOVED)))
    {
      return new ResponseViewResumeCompletion();
    }
    else
    {
      return new ResponseViewApplySuccess();
    }

  }
}
