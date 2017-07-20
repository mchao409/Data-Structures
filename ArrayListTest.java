import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.Rule;

/**
 * Test class for ArrayList.
 */
public class ArrayListTest {
  
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testArrayList() {
    ArrayList<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("welcome");
    assertTrue(list.contains("hello"));
    assertTrue(list.get(0).equals("hello"));
    assertTrue(list.size() == 2);
    ArrayList<String> test2 = new ArrayList<String>(list);
    test2.remove(0);
    assertTrue(list.size() == 2 && test2.size() == 1);
    
  }

  @Test
  public void testArrayListInt() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(2);
    assertTrue(test.size() == 1);
    assertTrue(test.get(0) == 2);
    test.remove(0);
    assertTrue(test.size() == 0);
  }

  @Ignore 
  @Test
  public void testArrayListArrayListOfE() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testAddE() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(100);
    test.add(10);
    test.add(0);
    assertTrue(test.contains(0));
    assertTrue(test.size() == 3);
  }
  
  @Test
  public void testAddIntE() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(100);
    test.add(0,10);
    test.add(0,0);
    assertTrue(test.get(0) == 0);
    assertTrue(test.get(1) == 10);
    exception.expect(IndexOutOfBoundsException.class);
    test.add(100, 2);
  }

  @Test
  public void testClear() {
    ArrayList<String> test = new ArrayList<String>();
    test.add("hello");
    test.add("hi");
    test.add("la");
    assertTrue(test.size() == 3);
    test.clear();
    assertTrue(test.size() == 0);
    ArrayList<String> test1 = new ArrayList<String>();
    test1.clear();
    assertTrue(test.size() == 0);
  }

  @Test
  public void testClone() {
    ArrayList<String> test = new ArrayList<String>();
    test.add("hello");
    test.add("hi");
    test.add("la");
    ArrayList<String> test2 = (ArrayList<String>) test.clone();
    assertTrue(!test2.equals(test));
    test2.add("w");
    assertTrue(test2.size() != test.size());
  }

  @Test
  public void testContains() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(1000);
    test.add(4);
    assertTrue(test.contains(1));
  }

  @Test
  public void testGet() {
    ArrayList<String> test = new ArrayList<String>();
    test.add("hi");
    test.add("door");
    test.add("cat");
    test.add("zero");
    assertTrue(test.get(2).equals("cat"));
  }

  @Test
  public void testIndexOf() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(0);
    test.add(2);
    test.add(10);
    assertTrue(test.indexOf(2) == 1);
  }

  @Test
  public void testIsEmpty() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(10);
    test.remove(0);
    assertTrue(test.size() == 0 && test.isEmpty());
  }

  @Test
  public void testLastIndexOf() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(0);
    test.add(2);
    test.add(0);
    test.add(2);
    assertTrue(test.lastIndexOf(2) == 3);
  }

  @Test
  public void testRemoveIndex() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(2);
    test.add(4);
    test.add(3);
    test.remove(2);
    assertTrue(test.contains(2));

  }

  @Test
  public void testRemoveObject() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(2);
    test.add(4);
    test.add(3);
    test.remove(Integer.valueOf(3));
    assertTrue(test.contains(4));
  }

  @Test
  public void testSet() {
    ArrayList<String> test = new ArrayList<String>();
    test.add("hello");
    test.add("hi");
    test.add("what's up?");
    test.add("zero");
    test.set(2, "I changed this");
    assertTrue(!test.contains("what's up?"));
  }

  @Test
  public void testSize() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(2);
    test.add(0);
    test.add(100);
    test.remove(0);
    test.add(0, 10);
    assertTrue(test.size() == 3);
  }

  @Test
  public void testSubList() {
    ArrayList<String> test = new ArrayList<String>();
    test.add("hi");
    test.add("zero");
    test.add("hello");
    test.add("we");
    test.add("cat");
    ArrayList<String> test2 = test.subList(1,3);
    assertTrue(test2.contains("zero") && test2.contains("hello"));
    assertTrue(test2.size() == 2);
    }

  @Test
  public void testToArray() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(0);
    test.add(5);
    test.add(6);
    Object[] arr = test.toArray();
    assertTrue(arr.length == 3);
  }
  
  @Ignore
  @Test
  public void testToString() {
    fail("Not yet implemented");
  }
  
  
  @Test
  public void testStress() {
    ArrayList<Integer> test = new ArrayList<Integer>();
    for(int i = 0; i < 1000000; i++) {
      test.add(i);
    }
  }
}
