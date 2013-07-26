package com.theladders.solid.dip.refactor;

import java.util.ArrayList;
import java.util.List;

public class SuggestedArticleExampleNew
{
  protected String orderByClause;

  protected boolean distinct;

  protected List<CriteriaNew> oredCriteria;


  public SuggestedArticleExampleNew()
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


  public List<CriteriaNew> getOredCriteria()
  {
    return oredCriteria;
  }


  public void or(CriteriaNew criteria)
  {
    oredCriteria.add(criteria);
  }


  public CriteriaNew or()
  {
    CriteriaNew criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }


  public CriteriaNew createCriteria()
  {
    CriteriaNew criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0)
    {
      oredCriteria.add(criteria);
    }
    return criteria;
  }


  protected CriteriaNew createCriteriaInternal()
  {
    // TODO: inject it?
    CriteriaNew criteria = new GeneratedCriteriaNew();
    return criteria;
  }
}

