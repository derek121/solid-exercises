package com.theladders.solid.dip.refactor;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriberArticleManagerImplTest
{
  private Integer STATUS_UNREAD  = 1;
  private Integer HTP_CONSULTANT = 1;

  private SuggestedArticleDao      suggestedArticleDao;
  private SubscriberArticleManager subscriberArticleManager;


  @Before
  public void setup()
  {
    suggestedArticleDao = new SuggestedArticleDao();
    RepositoryManager repositoryManager = new RepositoryManager();
    subscriberArticleManager = new SubscriberArticleManagerImpl(suggestedArticleDao, repositoryManager);
  }


  @Test
  public void testAddSuggestedArticle()
  {
    SuggestedArticle suggestedArticle = new SuggestedArticle();
    subscriberArticleManager.addSuggestedArticle(suggestedArticle);

    // Check changes to suggestedArticle
    assertEquals(STATUS_UNREAD, suggestedArticle.getSuggestedArticleStatusId());
    assertEquals(HTP_CONSULTANT, suggestedArticle.getSuggestedArticleSourceId());

    long now = System.currentTimeMillis();
    long createTime = suggestedArticle.getCreateTime().getTime();
    long updateTime = suggestedArticle.getUpdateTime().getTime();
    assertTrue(createTime > 0 && createTime <= now);
    assertTrue(updateTime > 0 && updateTime <= now);

    // Check that it was added to suggestedArticleDao
    assertTrue(suggestedArticleDao.wasAdded(suggestedArticle));
  }

  @Test
  public void testGetArticlesBySubscriber()
  {
    int id = 10;
    SuggestedArticle suggestedArticle = new SuggestedArticle(id, null, null, 0);
    subscriberArticleManager.addSuggestedArticle(suggestedArticle);

    List<SuggestedArticle> list = subscriberArticleManager.getArticlesbySubscriber(10);
    assertEquals(1, list.size());
    assertTrue(list.contains(suggestedArticle));

//  List<SuggestedArticle> criteria = suggestedArticleDao.

    SuggestedArticleExample example = suggestedArticleDao.getSelectedCriteria().get(0);
    List<Criteria> oredCriteria = example.getOredCriteria();
    assertEquals(1, oredCriteria.size());

    Criteria criteria = oredCriteria.get(0);
    List<Map<String, Object>> criteriaWithSingleValue = criteria.getCriteriaWithSingleValue();
    assertEquals(3, criteriaWithSingleValue.size());

    boolean found = false;
    for (Map<String, Object> map : criteriaWithSingleValue)
    {
      if (map.get("condition").equals("subscriber_id ="))
      {
        assertEquals(id, map.get("value"));
        found = true;
      }
    }
    assertTrue("Didn't find subscriber_id", found);

  }

}

