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
    Set<ConfidentialPhraseCategory> set = ConfidentialPhraseCategory.valuesOfAllTypes();
    assertEquals(7, set.size());

    assertTrue(set.contains(ConfidentialPhraseCategory.Name));
    assertTrue(set.contains(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(set.contains(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(set.contains(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(set.contains(ConfidentialPhraseCategory.ContactInfo));
    assertTrue(set.contains(ConfidentialPhraseCategory.CompanyName));
    assertTrue(set.contains(ConfidentialPhraseCategory.WorkExperience));
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

