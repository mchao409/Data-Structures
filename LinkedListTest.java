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

}
