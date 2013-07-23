package com.theladders.solid.ocp.resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConfidentialPhraseCategory2Test
{
  @Test
  public void testValues()
  {
    List<ConfidentialPhraseCategory2Value> values = new ArrayList<>(ConfidentialPhraseCategory2.valuesOfAllTypes());
    assertEquals(7, values.size());

    Collections.sort(values);

    Iterator<ConfidentialPhraseCategory2Value> it = values.iterator();
    assertEquals("CompanyName", it.next().name());
    assertEquals("ContactInfo", it.next().name());
    assertEquals("EmailAddress", it.next().name());
    assertEquals("MailingAddress", it.next().name());
    assertEquals("Name", it.next().name());
    assertEquals("PhoneNumber", it.next().name());
    assertEquals("WorkExperience", it.next().name());
  }


  @Test
  public void testContactInfoValues()
  {
    List<ConfidentialPhraseCategory2Value> values =
            new ArrayList<>(ConfidentialPhraseCategory2.valuesOfType(ConfidentialPhraseCategory2Value.Type.CONTACT));
    assertEquals(4, values.size());

    Collections.sort(values);

    Iterator<ConfidentialPhraseCategory2Value> it = values.iterator();
    assertEquals("ContactInfo", it.next().name());
    assertEquals("EmailAddress", it.next().name());
    assertEquals("MailingAddress", it.next().name());
    assertEquals("PhoneNumber", it.next().name());
  }

}

