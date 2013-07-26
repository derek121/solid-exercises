package com.theladders.solid.dip.refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratedCriteria
        implements Criteria
{
  protected List<Map<String, Object>> criteriaWithSingleValue;
  protected List<Map<String, Object>> criteriaWithListValue;


  public GeneratedCriteria()
  {
    criteriaWithSingleValue = new ArrayList<>();
    criteriaWithListValue = new ArrayList<>();
  }


  @Override
  public GeneratedCriteria andSubscriberIdEqualTo(Integer value)
  {
    addCriterion("subscriber_id =", value, "subscriberId");
    return this;
  }


  @Override
  public Criteria andSuggestedArticleSourceIdEqualTo(Integer value)
  {
    addCriterion("suggested_article_source_id =", value, "suggestedArticleSourceId");
    return this;
  }


  @Override
  public Criteria andSuggestedArticleStatusIdIn(List<Integer> values)
  {
    addCriterion("suggested_article_status_id in", values, "suggestedArticleStatusId");
    return this;
  }


  @Override
  public List<Map<String, Object>> getCriteriaWithSingleValue()
  {
    return criteriaWithSingleValue;
  }


  @Override
  public List<Map<String, Object>> getCriteriaWithListValue()
  {
    return criteriaWithListValue;
  }


  protected void addCriterion(String condition,
                              Object value,
                              String property)
  {
    if (value == null)
    {
      throw new RuntimeException("Value for " + property + " cannot be null");
    }

    Map<String, Object> map = new HashMap<>();
    map.put("condition", condition);
    map.put("value", value);
    criteriaWithSingleValue.add(map);
  }
}

