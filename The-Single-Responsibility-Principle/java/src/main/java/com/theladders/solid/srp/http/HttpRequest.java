package com.theladders.solid.srp.http;

import java.util.Map;

public class HttpRequest
{
  public static final String JOB_ID = "jobId";
  public static final String WHICH_RESUME = "whichResume";
  public static final String MAKE_RESUME_ACTIVE = "makeResumeActive";

  public static final String WHICH_RESUME_EXISTING = "existing";
  public static final String MAKE_RESUME_ACTIVE_YES = "yes";

  private final HttpSession session;
  private final Map<String, String> parameters;

  public HttpRequest(HttpSession session,
                     Map<String,String> parameters)
  {
    this.session = session;
    this.parameters = parameters;
  }

  public HttpSession getSession()
  {
    return session;
  }

  public String getParameter(String key)
  {
    return parameters.get(key);
  }
}
