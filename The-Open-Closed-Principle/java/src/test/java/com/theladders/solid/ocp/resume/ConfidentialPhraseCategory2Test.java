package com.theladders.solid.ocp.resume;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConfidentialPhraseCategory2Test
{
  @Test
  public void testValues()
  {
    List<ConfidentialPhraseCategory2Value> values = ConfidentialPhraseCategory2.values();
    assertEquals(7, values.size());

    Collections.sort(values);

    Iterator<ConfidentialPhraseCategory2Value> iterator = values.iterator();
    assertEquals(iterator.next().name(), "CompanyName");
    assertEquals(iterator.next().name(), "ContactInfo");
    assertEquals(iterator.next().name(), "EmailAddress");
    assertEquals(iterator.next().name(), "MailingAddress");
    assertEquals(iterator.next().name(), "Name");
    assertEquals(iterator.next().name(), "PhoneNumber");
    assertEquals(iterator.next().name(), "WorkExperience");
  }


  @Test
  public void testContactInfoValues()
  {
    List<ConfidentialPhraseCategory2Value> values = ConfidentialPhraseCategory2.contactInfoValues();
    assertEquals(4, values.size());

    Collections.sort(values);

    Iterator<ConfidentialPhraseCategory2Value> iterator = values.iterator();
    assertEquals(iterator.next().name(), "ContactInfo");
    assertEquals(iterator.next().name(), "EmailAddress");
    assertEquals(iterator.next().name(), "MailingAddress");
    assertEquals(iterator.next().name(), "PhoneNumber");

  }

}

