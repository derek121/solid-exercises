package com.theladders.solid.isp.oldjob;

import java.util.Date;

import com.theladders.solid.isp.oldjob.stubs.City;
import com.theladders.solid.isp.oldjob.stubs.Industry;
import com.theladders.solid.isp.oldjob.stubs.PositionLevel;
import com.theladders.solid.isp.oldjob.stubs.Region;
import com.theladders.solid.isp.oldjob.stubs.Sector;

public interface JobGeneralDetails
{
  /**
   * Get the (internally set) editor's note.
   *
   * @return editor's note.
   */
  String getEditorNote();


  /**
   * Is this job a Marketing job? If this flag is set, basic access is allowed to this job (where
   * otherwise it would be premium) from certain landing pages.
   *
   * @return true if this is marked for marketing, false otherwise.
   */
  // TODO: This should only ever be true for JobReq, refactor into the JobReq interface
  boolean isMarketing();

  /**
   * @return the name of the company
   */
  String getCompany();

  /**
   * Gets the value of the company_size_id field.
   * This represents the id in the company size table for the description of
   * how large the company is.
   *
   * @return companySize
   */
  Integer getCompanySize();
  /**
   * Get the Industry for this job.
   *
   * @return the Industry for this job.
   */
  Industry getIndustry();

  String getLocation();

  /**
   * Get the City for this job.
   *
   * @return the City for this job.
   */
  City getCity();

  /**
   * Get the region for this job.
   *
   * @return the region for this job.
   */
  Region getRegion();
}

