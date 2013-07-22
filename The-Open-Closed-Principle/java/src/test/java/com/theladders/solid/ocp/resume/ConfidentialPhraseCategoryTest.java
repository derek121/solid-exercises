package com.theladders.solid.ocp.resume;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConfidentialPhraseCategoryTest
{
  @Test
  public void testValues()
  {
    ConfidentialPhraseCategory[] arr = ConfidentialPhraseCategory.values();
    assertEquals(7, arr.length);

    List<ConfidentialPhraseCategory> list = Arrays.asList(arr);
    assertTrue(list.contains(ConfidentialPhraseCategory.Name));
    assertTrue(list.contains(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(list.contains(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(list.contains(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(list.contains(ConfidentialPhraseCategory.ContactInfo));
    assertTrue(list.contains(ConfidentialPhraseCategory.CompanyName));
    assertTrue(list.contains(ConfidentialPhraseCategory.WorkExperience));
  }

}

