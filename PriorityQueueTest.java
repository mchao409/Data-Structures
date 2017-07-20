import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class PriorityQueueTest {
  
  @Test
  public void testPriorityQueue() throws IOException {
    PriorityQueue<String> h = new PriorityQueue<String>();
    h.push("apple"); h.push("bear"); h.push("duck"); h.push("yarn");
    h.push("horse"); h.push("pear");
    assertTrue(h.pop().equals("apple"));
    assertTrue(h.contains("pear"));
    System.out.println(h);
    assertTrue(h.pop().equals("bear"));
    assertTrue(h.pop().equals("duck")); 
    assertTrue(h.pop().equals("horse"));
    assertTrue(h.pop().equals("pear")); 
    assertTrue(h.pop().equals("yarn"));
    assertTrue(h.size() == 0);
    
    PriorityQueue<Integer> ints = new PriorityQueue<Integer>();
    for(int i = 0; i < 10; i++) {
      ints.push(i);
      assertTrue(ints.contains(i));
    }
    ints.clear();
    assertTrue(ints.size() == 0);
  }

  @Test
  public void test() throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("PriorityQueueTest"));
    PriorityQueue<Integer> test = new PriorityQueue<Integer>();
    List<Integer> ints = new java.util.ArrayList<Integer>();
    
    for(int i = 0; i <= 10000; i++) {
      test.push(Integer.parseInt(f.readLine()));
    }
    
    for(int i = 0; i <= 10000; i++) {
      assertTrue(test.peek() == i);
      assertTrue(test.pop() == i);
    }
    assertTrue(test.size() == 0);
    
    for(int i = 0; i < 1000000; i++) {
      ints.add((int)(Math.random() * 10000 + 1));
    }
    
    for(int i = 0; i < ints.size(); i++) {
      test.push(ints.get(i));
    }
    
    Collections.sort(ints);
    for(int i = 0; i < 1000000; i++) {
      assertTrue(test.pop().equals(ints.get(i)));
    }

    f.close();
  }
  
  /*
  @Test
  public void testPush() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testClear() {
    fail("Not yet implemented");
  }

  @Test
  public void testComparator() {
    fail("Not yet implemented");
  }

  @Test
  public void testContains() {
    fail("Not yet implemented");
  }

  @Test
  public void testPeek() {
    fail("Not yet implemented");
  }

  @Test
  public void testPop() {
    fail("Not yet implemented");
  }

  @Test
  public void testSize() {
    fail("Not yet implemented");
  }
  */

}
