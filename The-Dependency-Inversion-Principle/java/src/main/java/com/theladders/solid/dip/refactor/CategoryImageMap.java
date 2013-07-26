package com.theladders.solid.dip.refactor;

import java.util.EnumMap;
import java.util.Map;

public class CategoryImageMap
{
  public enum Category
  {
    Interviewing,
    JobSearch,
    Networking,
    PersonalBranding,
    Resume,
    Salary,
    Assessment,
    OnTheJob
  }

  private Map<Category, String> map;


  public CategoryImageMap()
  {
    map = new EnumMap<>(Category.class);

    map.put(Category.Interviewing, "interviewing_thumb.jpg");
    map.put(Category.JobSearch, "job_search_thumb.jpg");
    map.put(Category.Networking, "networking_thumb.jpg");
    map.put(Category.PersonalBranding, "personalBranding_thumb.jpg");
    map.put(Category.Resume, "resume_thumb.jpg");
    map.put(Category.Salary, "salary_thumb.jpg");
    map.put(Category.Assessment, "salary_thumb.jpg");
    map.put(Category.OnTheJob, "salary_thumb.jpg");
  }

  public String getImageName(Category category)
  {
    return map.get(category);
  }
}

