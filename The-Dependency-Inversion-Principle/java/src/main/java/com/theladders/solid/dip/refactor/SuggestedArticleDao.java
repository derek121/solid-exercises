package com.theladders.solid.dip.refactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SuggestedArticleDao
{
  private List<SuggestedArticle> articles = new ArrayList<>();
  List<SuggestedArticleExample> selectedCriteria = new ArrayList<>();


  public void updateByPrimaryKeySelective(@SuppressWarnings ("unused") SuggestedArticle article)
  {
  }


  public int insertReturnId(@SuppressWarnings ("unused") SuggestedArticle suggestedArticle)
  {
    articles.add(suggestedArticle);
    return 0;
  }

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria)
  {
    selectedCriteria.add(criteria);
    return new ArrayList<>(articles);
  }


  boolean wasAdded(SuggestedArticle suggestedArticle)
  {
    return articles.contains(suggestedArticle);
  }


  List<SuggestedArticleExample> getSelectedCriteria()
  {
    return selectedCriteria;
  }
}
