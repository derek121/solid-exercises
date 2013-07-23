package com.theladders.solid.ocp.resume;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ConfidentialPhraseCategory
{
  Name(          76, Type.NON_CONTACT),
  MailingAddress(79, Type.CONTACT),
  PhoneNumber(   78, Type.CONTACT),
  EmailAddress(  77, Type.CONTACT),
  ContactInfo(   80, Type.CONTACT),
  CompanyName(   81, Type.NON_CONTACT),
  WorkExperience(82, Type.NON_CONTACT);

  public enum Type
  {
    CONTACT, NON_CONTACT
  }

  @SuppressWarnings ("unused")
  private int id;

  private final Type type;

  private ConfidentialPhraseCategory(int id,
                                     Type type)
  {
    this.id = id;
    this.type = type;
  }


  public static Set<ConfidentialPhraseCategory> valuesOfAllTypes()
  {
    return EnumSet.allOf(ConfidentialPhraseCategory.class);
  }

  public static Set<ConfidentialPhraseCategory> valuesOfType(Type type)
  {
    Set<ConfidentialPhraseCategory> set = new HashSet<>();

    for (ConfidentialPhraseCategory category : ConfidentialPhraseCategory.values())
    {
      if (category.type == type)
      {
        set.add(category);
      }
    }

    return set;
  }

}

