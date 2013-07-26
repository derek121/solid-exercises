package com.theladders.solid.dip.refactor;

import java.util.List;
import java.util.Map;

public interface CriteriaNew
{
  public CriteriaNew andSubscriberIdEqualTo(Integer value);

  public CriteriaNew andSuggestedArticleSourceIdEqualTo(Integer value);

  public CriteriaNew andSuggestedArticleStatusIdIn(List<Integer> values);

  List<Map<String, Object>> getCriteriaWithSingleValue();

  List<Map<String, Object>> getCriteriaWithListValue();

}

