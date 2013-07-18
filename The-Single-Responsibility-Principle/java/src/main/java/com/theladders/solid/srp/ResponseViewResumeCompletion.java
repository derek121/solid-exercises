package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpResponse;

public class ResponseViewResumeCompletion
        extends ResponseView
{
  @Override
  public void computeResponse(HttpResponse httpResponse)
  {
    Result result = new Result(Result.Type.COMPLETE_RESUME_PLEASE, null);
    httpResponse.setResult(result);
  }
}

