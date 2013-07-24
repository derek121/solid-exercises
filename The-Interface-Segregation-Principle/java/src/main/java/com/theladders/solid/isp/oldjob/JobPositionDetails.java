package com.theladders.solid.isp.oldjob;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.theladders.solid.isp.oldjob.stubs.City;
import com.theladders.solid.isp.oldjob.stubs.Discipline;
import com.theladders.solid.isp.oldjob.stubs.Industry;
import com.theladders.solid.isp.oldjob.stubs.JobFunction;
import com.theladders.solid.isp.oldjob.stubs.PositionLevel;
import com.theladders.solid.isp.oldjob.stubs.Region;
import com.theladders.solid.isp.oldjob.stubs.Sector;

public interface JobPositionDetails
{

  /**
   * Get this job's compensation (text).
   *
   * @return compensation for this job.
   */
  String getCompensation();

  /**
   * Get this job's compensationSalary (text).
   *
   * @return compensationSalary for this job.
   */
  String getCompensationSalary();

  /**
   * Get this job's compensationBonus (text).
   *
   * @return compensationBonus for this job.
   */
  String getCompensationBonus();

  /**
   * Get this job's compensationOther (text).
   *
   * @return compensationOther for this job.
   */
  String getCompensationOther();

  /**
   * Retrieves a list of disciplines for this job.
   *
   * @return List of Disciplines
   */
  List<Discipline> getDisciplines();


  /**
   * Refactored so it can be used by both job and JobReq
   *
   * @return fullJobDescription()
   */
  String getDescription();

  Collection<JobFunction> getJobFunctions();


  /**
   * Returns a unique identifier for this job. In the web application, this currently maps to
   * job_location_id in the Database. Scripts may use other values.
   *
   * @return unique identifier for this job.
   */
  int getJobId();

  /**
   * Return the jobsite id for this job.
   *
   * @return jobsite id for this job.
   */
  int getJobSiteId();

  /**
   * Get the date this job was originally published
   *
   * @return the Date the job was originally published
   */
  Date getOriginalPublicationDate();

  /**
   * Returns the real job_id.
   *
   * @return job id
   */
  Integer getParentJobId();

  PositionLevel getPositionLevel();

  /**
   * Get the sector for this job.
   *
   * @return the sector for this job.
   */
  Sector getSector();

  /**
   * Get this job's short description.
   *
   * @return a summary description of this job.
   */
  String getShortDescription();

  /**
   * Get the URL for this job. This is only valid for external (harvested) jobs (! isJobReq).
   *
   * @return URL for this job.
   */
  String getUrl();

}

