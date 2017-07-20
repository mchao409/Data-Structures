import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementation of a PriorityQueue using internal ArrayList
 * Min-heap
 */
public class PriorityQueue<E extends Comparable<E>> {
  
  /**
   * the List containing the elements of the PriorityQueue
   */
  private List<E> elements;
  
  /**
   * Comparator to determine priority of elements
   */
  private Comparator<? super E> compare;
  
  /**
   * Constructs a PriorityQueue of size 0, adds null - index zero will
   * not be used, sets compare to null (will use comparable)
   */
  public PriorityQueue() {
    elements = new ArrayList<E>();
    elements.add(null);
    compare = null;
    }

  /**
   * Constructs a PriorityQueue of size 0, adds null - index
   * will not be used, sets compare to the specified comparator
   * @param comparator the comparator to be used in comparing the elements
   */
  public PriorityQueue(Comparator<? super E> comparator) {
    elements = new ArrayList<E>();
    elements.add(null);
    compare = comparator;
  }
  
  /**
   * Compares the element at ind with the specified element   
   * @param element the element to compare to the element at index ind
   * @param ind the index containing an element being compared
   * @return Returns 1 if the element at index ind is greater than 
   * element, returns -1 otherwise
   */
  
  private int comp(E element, int ind) {
    if(compare == null) {
      if(element.compareTo(elements.get(ind)) < 0) {
        return -1;
      }
      return 1;
    }
    if(compare.compare(element, elements.get(ind)) < 0) {
      return -1;
    }
    return 1;
  }
  
  /**
   * Adds an element to the PriorityQueue
   * @param e the element to be added to the PriorityQueue
   * @return true - the element has been added
   */
  public boolean push(E e) {
    elements.add(e);
    int index = elements.size()-1;
    while(index/2 != 0 && comp(e, index/2) < 0 ) {
      Collections.swap(elements,index, index/2);
      index /= 2;
    }
    return true;
  }
  
  /**
   * Clears the PriorityQueue
   */
  public void clear() {
    elements = new ArrayList<E>();
    elements.add(null);
  }
  
  /**
   * Returns the comparator used - if no comparator was provided
   * in the constructor it returns null
   * @return the comparator provided, or null if none was
   */
  public Comparator<? super E> comparator() {
    return compare;
  }
  
  /**
   * Checks if an element is present in the PriorityQueue
   * @param o the element to check
   * @return true if the element is present, false otherwise
   */
  public boolean contains(Object o) {
    return elements.contains(o);
  }
  
  /**
   * Returns the first element in the PriorityQueue (without removing)
   * @return the first element
   */
  public E peek() {
    return elements.get(1);
  }
  
  /**
   * Removes the first element in the PriorityQueue
   * @return the first element
   */
  public E pop() {
    final E element = elements.get(1);
    Collections.swap(elements, 1, elements.size()-1);
    elements.remove(elements.size()-1);
    int currInd = 1;
    int newInd = findNewInd(currInd);
    if(newInd == -1) {
      return element;
    }
    while(comp(elements.get(currInd), newInd) >= 0) {
      Collections.swap(elements, currInd, newInd);
      currInd = newInd;
      newInd = findNewInd(currInd);
      if(newInd == -1) break;
    }
    return element;
  }

  private int findNewInd(int curr) {
    if(curr * 2 >= elements.size()){
      return -1;
    }
    if(curr * 2 + 1 >= elements.size()) {
      if(curr * 2 < elements.size()){
        return curr * 2;
      }
      return -1;
    }

    E el1 = elements.get(curr*2);
    E el2 = elements.get(curr*2+1);
    if(compare == null) {
      if(el1.compareTo(el2) <= 0) {
        return curr*2;
      }
      return curr*2+1;
    }
    else if(compare.compare(el1,el2) <= 0) {
      return curr * 2;
    }
    return curr*2 + 1; 
  }
  
  /**
   * Gives the size of the PriorityQueue(including null, index 0)
   * @return the size of elements
   */
  public int size() {
    return elements.size()-1;
  }
  
  public String toString() {
    return elements.toString();
  }
}
