package com.theladders.solid.dip.refactor;

import java.util.List;


public interface SuggestedArticleDao
{
  void updateByPrimaryKeySelective(SuggestedArticle article);

  int insertReturnId(SuggestedArticle suggestedArticle);

  List<SuggestedArticle> selectByExampleWithBlobs(SuggestedArticleExample criteria);

}

