package com.theladders.solid.srp;

import java.util.HashMap;
import java.util.Map;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;

public class ResponseViewInvalidJob
  extends ResponseView
{
  private final int jobId;


  public ResponseViewInvalidJob(int jobId)
  {
    this.jobId = jobId;
  }


  public void computeResponse(HttpResponse response)
  {
    Map<String, Object> model = new HashMap<>();
    model.put(HttpRequest.JOB_ID, jobId);

    Result result = new Result(Result.Type.INVALID_JOB, model);
    response.setResult(result);
  }
}

