import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
//import java.util.Arrays;
//import org.junit.Ignore;

public class CircularQueueTest {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testCircularQueue() {
    CircularQueue<String> queue = new CircularQueue<String>();
    queue.enqueue("hello"); queue.enqueue("hi");
    assertTrue(queue.dequeue().equals("hello"));
    assertTrue(queue.peek().equals("hi"));
    queue.clear();
  }

  @Test
  public void testCircularQueueInt() {
    CircularQueue<Integer> queue = new CircularQueue<Integer>(2);
    queue.enqueue(2);
    queue.enqueue(3);
  }

  @Test
  public void testClear() {
    CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
    queue.enqueue(100);
    queue.enqueue(10);
    queue.enqueue(2);
    queue.clear();
    queue.enqueue(20);
    queue.enqueue(1000);
    queue.enqueue(30);
    assertTrue(queue.dequeue() == 20);
    assertTrue(queue.dequeue() == 1000);
    assertTrue(queue.dequeue() == 30);
   
  }

  @Test
  public void testContains() {
    CircularQueue<String> queue = new CircularQueue<String>(5);
    assertFalse(queue.contains("10"));
    queue.enqueue("hello");
    queue.enqueue("hi");
    queue.enqueue("1000");
    assertTrue(queue.contains("hi"));
    assertTrue(queue.contains("1000"));
  }

  @Test
  public void testCopyTo() {
    CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
    queue.enqueue(100); queue.enqueue(10); queue.enqueue(1);
    exception.expect(NullPointerException.class);
    queue.copyTo(null, 0);
    Integer[] arr = new Integer[3];
    queue.copyTo(arr, 0);
    assertTrue(arr[0] == 100 && arr[1] == 10 && arr[2] == 1);  
  }

  @Test
  public void testDequeue() {
    CircularQueue<String> test = new CircularQueue<String>(2);
    test.enqueue("Hi");
    test.enqueue("hello");
    assertTrue(test.dequeue().equals("Hi"));
    assertTrue(test.dequeue().equals("hello"));
    assertTrue(!test.contains("Hi"));
    exception.expect(NullPointerException.class);
    test.dequeue();
  }

  @Test
  public void testEnqueue() {
    CircularQueue<Integer> test = new CircularQueue<Integer>(2);
    test.enqueue(10); 
    test.enqueue(100);
    test.enqueue(3);   

    //test.dequeue();
    test.enqueue(2);
    //System.out.println(test.peek());
    assertTrue(test.peek() == 10);
    assertTrue(test.contains(10) && test.contains(100));
  }

  @Test
  public void testGet() {
    CircularQueue<Integer> test = new CircularQueue<Integer>(2);
    test.enqueue(10); test.enqueue(100);
    test.enqueue(3);
    test.dequeue();
    test.enqueue(2);
    assertTrue(test.get(0) == 100);
  }
  
  @Test
  public void testPeek() {
    CircularQueue<Integer> test = new CircularQueue<Integer>(5);
    test.enqueue(10); test.enqueue(100);
    test.enqueue(3); test.enqueue(2); test.enqueue(9);
    assertTrue(test.peek() == 10);
    assertTrue(test.contains(10));
  }
  
  /*
  @Ignore
  @Test
  public void testToArray() {
    Integer[] arr = new Integer[5];
    CircularQueue<Integer> test = new CircularQueue<Integer>(5);
    test.enqueue(10); test.enqueue(100);
    test.enqueue(3); test.enqueue(2); test.enqueue(9);
    Object[] temp = test.toArray();
    arr = Arrays.copyOf(temp, temp.length, Integer[].class);
    assertTrue(arr[0] == 10 && arr[2] == 3);
  }
  */
  
  @Test
  public void test() {
    CircularQueue<Integer> test = new CircularQueue<Integer>(0);
    test.enqueue(0);
    test.dequeue();

    test.enqueue(0);
    System.out.println(test.size());
    test.enqueue(1);
    test.dequeue();
    test.enqueue(2);
    System.out.println(test.get(1));
    test.enqueue(3); test.enqueue(4); test.enqueue(5);
    test.enqueue(6);
    test.enqueue(7);
    test.dequeue();
    test.enqueue(8);
    test.dequeue();
    test.enqueue(9);
    System.out.println(test.contains(9));
    System.out.println(test);
    
  }

}
