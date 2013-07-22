package com.theladders.solid.ocp.resume;

import java.util.ArrayList;
import java.util.List;

public enum ConfidentialPhraseCategory
{
  Name(          76, Type.NON_CONTACT),
  MailingAddress(79, Type.CONTACT),
  PhoneNumber(   78, Type.CONTACT),
  EmailAddress(  77, Type.CONTACT),
  ContactInfo(   80, Type.CONTACT),
  CompanyName(   81, Type.NON_CONTACT),
  WorkExperience(82, Type.NON_CONTACT);

  private enum Type
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


  public static ConfidentialPhraseCategory[] contactInfoValues()
  {
    List<ConfidentialPhraseCategory> list = new ArrayList<>();
    for (ConfidentialPhraseCategory category : ConfidentialPhraseCategory.values())
    {
      if (category.type == Type.CONTACT)
      {
        list.add(category);
      }
    }

    return list.toArray(new ConfidentialPhraseCategory[0]);
  }

}

