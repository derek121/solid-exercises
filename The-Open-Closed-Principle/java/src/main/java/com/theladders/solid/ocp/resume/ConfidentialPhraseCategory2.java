package com.theladders.solid.ocp.resume;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ConfidentialPhraseCategory2
{
  public static Set<ConfidentialPhraseCategory2Value> valuesOfAllTypes()
  {
    return ConfidentialPhraseCategory2Value.valuesOfAllTypes();
  }


  public static Set<ConfidentialPhraseCategory2Value> valuesOfType(ConfidentialPhraseCategory2Value.Type type)
  {
    Set<ConfidentialPhraseCategory2Value> set = new HashSet<>();
    for (ConfidentialPhraseCategory2Value value : ConfidentialPhraseCategory2Value.valuesOfAllTypes())
    {
      if (value.type() == type)
      {
        set.add(value);
      }
    }

    return set;
  }

}

