package com.theladders.solid.ocp.resume;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConfidentialPhraseCategory2Value
        implements Comparable<ConfidentialPhraseCategory2Value>
{


  public static Set<ConfidentialPhraseCategory2Value> valuesOfAllTypes()
  {
    return new HashSet<>(Arrays.asList(
            new ConfidentialPhraseCategory2Value("Name", Type.NON_CONTACT),
            new ConfidentialPhraseCategory2Value("MailingAddress", Type.CONTACT),
            new ConfidentialPhraseCategory2Value("PhoneNumber", Type.CONTACT),
            new ConfidentialPhraseCategory2Value("EmailAddress", Type.CONTACT),
            new ConfidentialPhraseCategory2Value("ContactInfo", Type.CONTACT),
            new ConfidentialPhraseCategory2Value("CompanyName", Type.NON_CONTACT),
            new ConfidentialPhraseCategory2Value("WorkExperience", Type.NON_CONTACT)));
  }


  public enum Type
  {
    CONTACT, NON_CONTACT
  }

  private       String name;
  private final Type   type;


  public ConfidentialPhraseCategory2Value(String name,
                                          Type type)
  {
    this.name = name;
    this.type = type;
  }


  public String name()
  {
    return name;
  }


  public Type type()
  {
    return type;
  }


  @Override public int compareTo(ConfidentialPhraseCategory2Value other)
  {
    return this.name.compareTo(other.name);
  }
}

