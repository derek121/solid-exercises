package com.theladders.solid.srp;

import java.util.HashMap;
import java.util.List;

import com.theladders.solid.srp.http.HttpResponse;

public class ResponseViewError
        extends ResponseView
{
  private final List<String> messages;


  public ResponseViewError(List<String> messages)
  {
    this.messages = messages;
  }


  @Override public void computeResponse(HttpResponse response)
  {
    Result result = new Result(Result.Type.ERROR, new HashMap<String, Object>(), messages);
    response.setResult(result);
  }
}

