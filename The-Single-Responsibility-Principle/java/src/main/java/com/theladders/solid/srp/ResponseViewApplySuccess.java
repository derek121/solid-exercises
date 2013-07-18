package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpResponse;

public class ResponseViewApplySuccess
        extends ResponseView
{
  @Override
  public void computeResponse(HttpResponse httpResponse)
  {
    Result result = new Result(Result.Type.SUCCESS, null);
    httpResponse.setResult(result);
  }
}

