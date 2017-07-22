import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
  
  @Test
  public void testAddAtEnd() {
    LinkedList<String> list = new LinkedList<String>();
    list.add("hello"); 
    assertTrue(list.getHead().getContents().equals("hello"));
    list.add("apple");
    assertTrue(list.getHead().getNext().getContents().equals("apple"));
  }
  
  @Test
  public void testAddAtIndex() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(0,1); list.add(1,2); list.add(2,100);
    list.add(0,10); list.add(1,3);
    assertTrue(list.getHead().getContents() == 10);
    assertTrue(list.getHead().getNext().getContents() == 3);
    assertTrue(list.getHead().getNext().getNext().getContents() == 1);
    assertTrue(list.getHead().getNext().getNext().getNext().getContents() == 2);
    assertTrue(list.getHead().getNext().getNext().getNext().getNext().getContents() == 100);

  }
  
  @Test
  public void testClear() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.clear();
    assertTrue(list.head == null);
    
    list.add(10);
    list.clear();
    assertTrue(list.head == null);
    
    for(int i = 0 ; i < 100; i++) {
      list.add(i);
    }
    list.clear();
    assertTrue(list.head == null);
  }
  
  @Test
  public void testRemoveIndex() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    try {
      list.remove(10);
      fail();
    } catch (NullPointerException e) {}
    list.add(1);
    
    try {
      list.remove(2);
      fail();
    } catch (NullPointerException e) {}
    assertTrue(list.remove(0) == 1);
    
    for(int i = 0; i < 10; i++) {
      list.add(i);
    }
    assertTrue(list.remove(9) == 9);
    
    try {
      list.remove(9);
      fail();
    } catch (NullPointerException e) {}
    
    for(int i = 8; i >= 0; i--) {
      assertTrue(list.remove(i) == i);
    }   
  }
  
  @Test
  public void testRemoveObject() {
    LinkedList<String> list = new LinkedList<String>();
    assertFalse(list.remove("apple"));
    
    String[] words = {"apple","apple","pear", "blueberry","banana", "apple"};
    for(int i = 0; i < words.length; i++) {
      list.add(words[i]);
    }
    list.remove("apple");
    assertTrue(list.getHead().getContents().equals("apple"));
    list.remove("apple");
    assertTrue(list.getHead().getNext().getNext()
        .getNext().getNext().getNext().getContents().equals("apple"));
    assertTrue(list.contains("apple"));
    for(int i = 2; i < words.length; i++) {
      assertTrue(list.remove(words[i]));
    }
    
  }
  
  @Test
  public void testContains() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    assertFalse(list.contains(10));
    list.add(100);
    assertTrue(list.contains(100));
    list.remove(0);
    assertFalse(list.contains(100));
    for(int i = 0; i < 100; i++) {
      list.add(i);
      assertTrue(list.contains(i));
    }
    for(int i = 99; i >= 0; i--) {
      list.remove(i);
      assertFalse(list.contains(i));
    }
  }
  
  @Test
  public void testSize() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    assertTrue(list.size() == 0);
    list.add(0);
    assertTrue(list.size() == 1);
    list.remove(0);
    assertTrue(list.size() == 0);
    for(int i = 0; i < 100; i++) {
      list.add(i);
      assertTrue(list.size() == i+1);
    }
    for(int i = 99; i >= 0; i--) {
      list.remove(i);
      assertTrue(list.size() == i);
    }
  } 
}
