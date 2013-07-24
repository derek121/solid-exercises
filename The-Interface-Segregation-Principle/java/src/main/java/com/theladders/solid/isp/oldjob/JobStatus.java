package com.theladders.solid.isp.oldjob;

public interface JobStatus
{
  /**
   * Does the job have a particular status? There's a legacy thing where a job could have more than
   * one status, hence this method... Status should be moved out of PublicationInfo though, and this
   * should be a getStatus() method...
   *
   * @param status status to check against.
   * @return true if job has this status, false otherwise.
   */
  boolean hasStatus(JobStatus status);

  boolean isDeleted();

  boolean isExpired();

  /**
   * Is this job filled?
   *
   * @return true if this job is filled, false otherwise.
   */
  boolean isFilled();

}

