package com.theladders.solid.dip.refactor;

import java.util.ArrayList;
import java.util.List;

public class SuggestedArticleExample
{
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;


  public SuggestedArticleExample()
  {
    oredCriteria = new ArrayList<>();
  }


  public void setOrderByClause(String orderByClause)
  {
    this.orderByClause = orderByClause;
  }


  public String getOrderByClause()
  {
    return orderByClause;
  }


  public void setDistinct(boolean distinct)
  {
    this.distinct = distinct;
  }


  public boolean isDistinct()
  {
    return distinct;
  }


  public List<Criteria> getOredCriteria()
  {
    return oredCriteria;
  }


  public void or(Criteria criteria)
  {
    oredCriteria.add(criteria);
  }


  public Criteria or()
  {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }


  public Criteria createCriteria()
  {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0)
    {
      oredCriteria.add(criteria);
    }
    return criteria;
  }


  protected Criteria createCriteriaInternal()
  {
    // TODO: inject it?
    Criteria criteria = new GeneratedCriteria();
    return criteria;
  }
}

