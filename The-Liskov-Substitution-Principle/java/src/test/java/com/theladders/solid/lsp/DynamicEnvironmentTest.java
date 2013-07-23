package com.theladders.solid.lsp;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DynamicEnvironmentTest
{
  @Test
  public void testGetPlain()
  {
    Environment base = new Environment();
    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);
    assertEquals(val, map.get(key));
  }

  @Test
  public void testGetInitializedWithKeyMap()
  {
    Environment base = new Environment();

    Map<String, String> keyMap = new HashMap<>();
    keyMap.put("foo", "foo2");

    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);
    assertEquals(val, map.get(key));
  }

  @Test
  public void testGetWithKeyMap()
  {
    Environment base = new Environment();

    Map<String, String> keyMap = new HashMap<>();
    keyMap.put("foo", "foo2");

    DynamicEnvironment map = new DynamicEnvironment(base, keyMap);

    String val = "bar";
    map.put("foo2", val);

    assertEquals(val, map.getWithKeyMap("foo"));
    assertNull(map.get("foo"));
  }


  //////////
  @Test
  public void testValuesPlain()
  {
    Environment base = new Environment();
    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Collection<Object> values = map.values();
    assertEquals(1, values.size());
    assertEquals(val, values.iterator().next());
  }

  @Test
  public void testValuesInitializedWithBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Collection<Object> values = map.values();
    assertEquals(1, values.size());
    assertEquals(val, values.iterator().next());
  }

  @Test
  public void testValuesWithBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = Collections.emptyMap();
    DynamicEnvironment map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Collection<Object> values = map.valuesWithBase();
    assertEquals(2, values.size());
    assertTrue(values.contains("bar"));
    assertTrue(values.contains("baseVal"));
  }


  //////////
  @Test
  public void testEntrySetPlain()
  {
    Environment base = new Environment();
    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Set<Map.Entry<Object, Object>> entries = map.entrySet();
    assertEquals(1, entries.size());
    Map.Entry entry = entries.iterator().next();
    assertEquals(key, entry.getKey());
    assertEquals(val, entry.getValue());
  }

  @Test
  public void testEntrySetInitializedWithBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Set<Map.Entry<Object, Object>> entries = map.entrySet();
    assertEquals(1, entries.size());
    Map.Entry entry = entries.iterator().next();
    assertEquals(key, entry.getKey());
    assertEquals(val, entry.getValue());
  }

  @Test
  public void testEntrySetWithBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = Collections.emptyMap();
    DynamicEnvironment map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Set<Map.Entry<Object, Object>> entries = map.entrySetWithBase();
    assertEquals(2, entries.size());
    Map.Entry entry1 = entries.iterator().next();
    Map.Entry entry2 = entries.iterator().next();
    assertTrue(entry1.getKey().equals("foo") || entry2.getKey().equals("x"));
    assertTrue(entry1.getValue().equals("bar") || entry2.getValue().equals("baseVal"));
  }


  //////////
  @Test
  public void testKeySetPlain()
  {
    Environment base = new Environment();
    Map<String, String> keyMap = Collections.emptyMap();
    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Set<Object> keySet = map.keySet();
    assertEquals(1, keySet.size());
    Object o = keySet.iterator().next();
    assertEquals(key, o);
  }

  @Test
  public void testKeySetInitializedWithKeyMapAndBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = new HashMap<>();
    keyMap.put("foo", "foo2");

    Map<Object, Object> map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    Set<Object> keySet = map.keySet();
    assertEquals(1, keySet.size());
    Object o = keySet.iterator().next();
    assertEquals(key, o);
  }

  @Test
  public void testKeySetWithKeyMapAndBase()
  {
    Environment base = new Environment();
    base.put("x", "baseVal");

    Map<String, String> keyMap = new HashMap<>();
    keyMap.put("foo", "foo2");

    DynamicEnvironment map = new DynamicEnvironment(base, keyMap);

    String key = "foo", val = "bar";
    map.put(key, val);

    map.put("extra", "z");

    Set<Object> keySet = map.keySetWithKeyMapAndBase();
    assertEquals(3, keySet.size());
    assertTrue(keySet.contains("x"));
    assertTrue(keySet.contains("foo"));
    assertTrue(keySet.contains("extra"));
  }

}

