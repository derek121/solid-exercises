package com.theladders.solid.srp;

import java.util.List;
import java.util.Map;

public class Result
{
  public enum Type { SUCCESS, COMPLETE_RESUME_PLEASE, ERROR, INVALID_JOB }

  private final Type type;
  private final Map<String, Object> model;
  private final List<String> errorList;

  public Result(Type type,
                Map<String, Object> model)
  {
    this.type  = type;
    this.model = model;
    this.errorList = null;
  }

  public Result(Type type,
                Map<String, Object> model,
                List<String> errList)
  {
    this.type  = type;
    this.model = model;
    this.errorList = errList;
  }

  public Type getType()
  {
    return type;
  }

  @Override
  public String toString()
  {
    return "Result [type=" + type + ", model=" + model + ", errorList=" + errorList + "]";
  }
}
