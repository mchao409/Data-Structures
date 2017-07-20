public class CircularQueue<E> {
  public ArrayList<E> elements;
  
  /**
   * the index of the front of the CircularQueue
   */
  private int front;
  
  /**
   * the index of the rear of the CircularQueue
   */
  private int rear;
  
  /**
   * The number of elements currently in the CircularQuue
   */
  private int numElements;
  
  /**
   * The size of the CircularQueue - maximum number of elements it can hold
   * without resizing
   */
  private int size;
  
  /**
   * Constructs a CircularQueue with an initial capacity of 10
   */
  public CircularQueue() {
    elements = new ArrayList<E>();
    front = 0; rear = 0; numElements = 0; size = 10;
  }
  
  /**
   * Constructs a CircularQueue with an initial capacity of size num
   * @param num the initial size of the CircularQueue
   */
  public CircularQueue(int num) {
    elements = new ArrayList<E>(num);
    front = 0; rear = 0; numElements = 0; size = num;
  }
  
  /**
   * Clears the CircularQueue, default size is the same as it was before it 
   * was cleared
   */
  public void clear() {
    elements = new ArrayList<E>(size);
    front = 0; rear = 0; numElements = 0;
  }
  
  /**
   * 
   * @param num the value to check if contained in the CircularQueue
   * @return true, if num is in the CircularQueue, or false, if num is not
   */
  public boolean contains(Object e) {
    for(int i = 0; i < elements.size(); i++) {
      if(e.equals(elements.get(i))) return true;
    }
    return false;
  }
  
  /**
   * 
   * @param arr the array to copy the elements of the CircularQueue
   *            over to (shallow copy)
   * @param ind the index to begin copying from
   * 
   */
  public void copyTo(E[] arr, int ind) {
    for(int i = 0; i < elements.size(); i++) {
      arr[ind+i] = elements.get(i);
    }
  }
   
  /**
   * 
   * @return the element at the front of the CircularQueue
   */
  public E dequeue() {
    if(numElements == 0){
      throw new NullPointerException();
    }
    E element = elements.get(front);
    elements.set(front, null);
    if(front == size-1) front = 0;
    else front++;
    numElements--;
    return element;
  }
   
  /**
   * 
   * @param element the element to be placed at the rear of the queue
   */
  public void enqueue(E element){
    if(rear < front) {
      elements.add(rear, element);
      numElements++;
      rear++;
      return;
    }
    elements.add(rear, element);
    numElements++;
    rear++;
  }
   
  /**
   * 
   * @param ind the index of the CircularQueue to retrieve
   * @return the value of the CircularQueue at index ind
   */
  public E get(int ind) {
    int tempf = front;
    int index = (tempf + ind)% numElements;
    return elements.get(index);
  }  
  
  /**
   * 
   * @return the element at the front of the CircularQueue, does not remove
   */
  public E peek() {
    if(numElements == 0) {
      throw new NullPointerException();
    }
    return elements.get(front);
  }
  
  public String toString() {
    if(front == rear) return "[]";
    int start = front, end = rear;
    String str = "" + elements.get(start);
    int add = 0;
    if(start > rear) {
      start -= elements.size();
      add = elements.size();
    }
    for(int i = start+1; i < end; i++) {
      if(i + add >= size()) {
        str += ", " + elements.get(i);
      }
      else str += ", " + elements.get(i+add);
      
    }
    str = "[" + str + "]";
    return str;
  }
  
  /**
   * 
   * @return the size of the CircularQueue
   */
  public int size() {
    return size;
  }
}
