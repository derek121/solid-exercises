package com.theladders.solid.srp.http;

import com.theladders.solid.srp.Result;

public class HttpResponse
{
  private Result result;

  public Result.Type getResultType()
  {
    return result.getType();
  }

  public void setResult(Result result)
  {
    this.result = result;
  }
}
