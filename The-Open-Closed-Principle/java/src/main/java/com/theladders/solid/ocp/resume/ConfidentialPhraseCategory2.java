package com.theladders.solid.ocp.resume;

import java.util.ArrayList;
import java.util.List;

public abstract class ConfidentialPhraseCategory2
{
  public static List<ConfidentialPhraseCategory2Value> values()
  {
    return ConfidentialPhraseCategory2Value.values();
  }


  public static List<ConfidentialPhraseCategory2Value> contactInfoValues()
  {
    List<ConfidentialPhraseCategory2Value> list = new ArrayList<>();
    for (ConfidentialPhraseCategory2Value value : ConfidentialPhraseCategory2Value.values())
    {
      if (value.type() == ConfidentialPhraseCategory2Value.Type.CONTACT)
      {
        list.add(value);
      }
    }

    return list;
  }

}

