package com.theladders.solid.ocp.resume;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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


  @Test
  public void testContactInfoValues()
  {
    Set<ConfidentialPhraseCategory> set =
            ConfidentialPhraseCategory.valuesOfType(ConfidentialPhraseCategory.Type.CONTACT);

    assertEquals(4, set.size());

    assertTrue(set.contains(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(set.contains(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(set.contains(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(set.contains(ConfidentialPhraseCategory.ContactInfo));
  }

}

