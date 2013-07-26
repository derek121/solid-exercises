package com.theladders.solid.dip.refactor;

public class RepositoryManagerImpl
  implements RepositoryManager
{
  @Override
  public ContentNode getNodeByUuid(String id)
  {
    ContentNode node = new ContentNode();

    node.addProperty("uuid", id);

    return node;
  }
}
