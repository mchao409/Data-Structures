/**
 * Implementation of Singly Linked List
 *
 */
public class LinkedList<E> {
  Node head;
  
  public class Node {
    private E contents;
    private Node next;
    
    /**
     * Constructs a new Node
     */
    public Node(E obj) {
      contents = obj;
    }
    
    public E getContents() {
      return contents;
    }
    
    public Node getNext() {
      return next;
    }
  }
  
  /**
   * Constructs an empty LinkedList
   */
  public LinkedList() {}
  
  /**
   * Constructs an empty LinkedList with one object
   */
  public LinkedList(E obj) {
    head = new Node(obj);
  }
  
  /**
   * Adds to the end of the LinkedList
   */
  public boolean add(E e) {
    Node toAdd = new Node(e);
    if(head == null) {
      head = toAdd;
      return true;
    }
    Node n = head;
    while(n.next != null) {
      n = n.next;
    }
    n.next = toAdd;
    return true;
  }
  
  /**
   * Inserts the element at the specified index
   */
  public void add(int index, E element) {
    Node toAdd = new Node(element);
    Node temp = head;
    if(index == 0) {
      head = toAdd;
      head.next = temp; 
      return;
    }
    for(int i = 1; i < index; i++) {
      if(temp.next != null) {
        temp = temp.next;
      }
      else return;
    }
    Node otherTemp = temp.next;
    temp.next = toAdd;
    toAdd.next = otherTemp; 
  }
  
  /**
   * Removes all elements from the LinkedList
   */
  public void clear() {
    head = null;
  }
  
  /**
   * Checks if the LinkedList contains the specified element
   */
  public boolean contains(Object o) {
    Node n = head;
    while(n != null) {
      if(n.contents.equals(o)) return true;
      if(n.next != null) n = n.next;
      else return false;
    }
    return false;
  }
  
  public String toString() {
    String s = "[";
    Node h = head;
    while(h != null) {
      s += h.contents + ", ";
      h = h.next;
    }
    s = s.substring(0, s.length()-2);
    s += "]";
    return s;
  }
  
  /**
   * Returns the head of the LinkedList (used in testing)
   */
  public Node getHead() {
    return head;
  }
}
