package com.theladders.solid.dip.refactor;

import java.util.List;
import java.util.Map;

public interface Criteria
{
  public Criteria andSubscriberIdEqualTo(Integer value);

  public Criteria andSuggestedArticleSourceIdEqualTo(Integer value);

  public Criteria andSuggestedArticleStatusIdIn(List<Integer> values);

  List<Map<String, Object>> getCriteriaWithSingleValue();

  List<Map<String, Object>> getCriteriaWithListValue();

}

