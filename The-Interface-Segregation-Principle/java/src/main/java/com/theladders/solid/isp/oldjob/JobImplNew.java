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

public class JobImplNew
  implements JobGeneralDetails, JobStatus, JobPositionDetails
{
  // JobGeneralDetails

  @Override public String getEditorNote()
  {
    return null;
  }


  @Override public boolean isMarketing()
  {
    return false;
  }


  @Override public String getCompany()
  {
    return null;
  }


  @Override public Integer getCompanySize()
  {
    return null;
  }


  @Override public Industry getIndustry()
  {
    return null;
  }


  @Override public String getLocation()
  {
    return null;
  }


  @Override public City getCity()
  {
    return null;
  }


  @Override public Region getRegion()
  {
    return null;
  }



  // JobPositionDetails

  @Override public String getCompensation()
  {
    return null;
  }


  @Override public String getCompensationSalary()
  {
    return null;
  }


  @Override public String getCompensationBonus()
  {
    return null;
  }


  @Override public String getCompensationOther()
  {
    return null;
  }


  @Override public List<Discipline> getDisciplines()
  {
    return null;
  }


  @Override public String getDescription()
  {
    return null;
  }


  @Override public Collection<JobFunction> getJobFunctions()
  {
    return null;
  }


  @Override public int getJobId()
  {
    return 0;
  }


  @Override public int getJobSiteId()
  {
    return 0;
  }


  @Override public Date getOriginalPublicationDate()
  {
    return null;
  }


  @Override public Integer getParentJobId()
  {
    return null;
  }


  @Override public PositionLevel getPositionLevel()
  {
    return null;
  }


  @Override public Sector getSector()
  {
    return null;
  }


  @Override public String getShortDescription()
  {
    return null;
  }


  @Override public String getUrl()
  {
    return null;
  }


  // JobStatus

  @Override public boolean hasStatus(JobStatus status)
  {
    return false;
  }


  @Override public boolean isDeleted()
  {
    return false;
  }


  @Override public boolean isExpired()
  {
    return false;
  }


  @Override public boolean isFilled()
  {
    return false;
  }
}

