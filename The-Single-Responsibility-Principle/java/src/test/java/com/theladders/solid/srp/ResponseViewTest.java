package com.theladders.solid.srp;


import org.junit.Test;

import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

import static org.junit.Assert.assertEquals;

public class ResponseViewTest
{
  @Test
  public void testSetResultApplySuccessNotPremiumAndIncomplete()
  {
    HttpResponse httpResponse = new HttpResponse();
    Jobseeker jobseeker = new Jobseeker(2, false);
    ProfileStatus profileStatus = ProfileStatus.INCOMPLETE;

    ResponseView responseView = ResponseView.create(jobseeker, profileStatus);
    responseView.computeResponse(httpResponse);
    assertEquals(Result.Type.COMPLETE_RESUME_PLEASE, httpResponse.getResultType());

  }


  @Test
  public void testSetResultApplySuccessNotPremiumAndApproved()
  {
    HttpResponse httpResponse = new HttpResponse();
    Jobseeker jobseeker = new Jobseeker(2, false);
    ProfileStatus profileStatus = ProfileStatus.APPROVED;

    ResponseView responseView = ResponseView.create(jobseeker, profileStatus);
    responseView.computeResponse(httpResponse);
    assertEquals(Result.Type.SUCCESS, httpResponse.getResultType());

  }


  @Test
  public void testSetResultApplySuccessPremiumAndIncomplete()
  {
    HttpResponse httpResponse = new HttpResponse();
    Jobseeker jobseeker = new Jobseeker(2, true);
    ProfileStatus profileStatus = ProfileStatus.INCOMPLETE;

    ResponseView responseView = ResponseView.create(jobseeker, profileStatus);
    responseView.computeResponse(httpResponse);
    assertEquals(Result.Type.SUCCESS, httpResponse.getResultType());

  }


}

