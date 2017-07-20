import java.util.Arrays;

public class ArrayList<E> {
  /**
   * the array which stores the elements of the ArrayList
   */
  private E[] list;
  
  /**
   * the default capacity of the ArrayList
   */
  private final int DEFAULT_CAP = 10;
  
  /**
   * the current capacity of the ArrayList - equivalent to the length of list
   */
  private int capacity;
  
  /**
   * the number of elements in ArrayList
   */
  private int size; 

  /**
   * Constructs an ArrayList of default capacity 10
   */
  @SuppressWarnings("unchecked")
  public ArrayList() {
    list = (E[])new Object[DEFAULT_CAP];
    capacity = 10;
    size = 0;
  }
  
  /**
   * Constructs an ArrayList with a capacity of num
   * @param num the capacity of the ArrayList to be constructed
   */
  @SuppressWarnings("unchecked")
  public ArrayList(int initialCap) {
    list = (E[])new Object[0];
    capacity = initialCap;
    size = 0;
  }
  
  /**
   * Constructs an ArrayList with the elements of the ArrayList passed as parameter - shallow clone
   * @param lst the ArrayList that has the elements the new ArrayList will contain
   */
  @SuppressWarnings("unchecked")
  public ArrayList(ArrayList<E> lst) {
    list = (E[])new Object[lst.size()];
    capacity = lst.capacity;
    size = lst.size;
    for(int i = 0; i < size; i++) {
      list[i] = lst.list[i];
    }
  }
  
  /**
   * Appends an element to the end of the ArrayList
   * @param e the element to append at the end of the ArrayList
   * @return true if the element was successfully appended
   */
  public void add(E e) {
    resize();
    list[size] = e;
    size++;
  }
  
  /**
   * Resizes the ArrayList if the number of elements it contains is equal
   * to its capacity
   */
  @SuppressWarnings("unchecked")
  private void resize() {
    int newCap = Math.max(capacity*2, DEFAULT_CAP);
    if(size < list.length) return;
    
    Object[] temp = new Object[newCap];
    for(int i = 0; i < list.length; i++) {
      temp[i] = list[i];
    }
    list = (E[])temp;
    capacity = newCap;
  }
  
  /**
   * Inserts an element at the specified index, pushes the current 
   * elements at and after the insertion point back
   * @param index the index where the element will be inserted into
   * the ArrayList
   * @param e the element to be inserted
   */
  public void add(int index, E e) {
    resize();
    for(int i = size-1; i >= index; i--) {
      list[i+1] = list[i];
    }
    list[index] = e;
    size++;
  }
  
  /**
   * Creates a new, empty ArrayList of the same capacity it had
   * previously
   */
  @SuppressWarnings("unchecked")
  public void clear() {
    list = (E[])new Object[capacity];
    size = 0;
  }
  
  /**
   * Clones the current ArrayList and returns it
   */
  public ArrayList<E> clone() {
    ArrayList<E> temp = new ArrayList<E>();
    temp.size = this.size;
    temp.capacity = this.capacity;
    temp.list = Arrays.copyOf(this.list, this.list.length);
    return temp;
  }
  
  /**
   * Checks if the ArrayList contains an object
   * @param o the object to check
   * @return true if the ArrayList contains o, false otherwise
   */
  public boolean contains(Object o) {
    for(int i = 0; i < size; i++) {
      if(list[i].equals(o)) return true;
    }
    return false;
  }
  
  /**
   * Returns the element at a specified index of the ArrayList
   * @param index the index of the element to return
   * @return the element at index
   */
  public E get(int index) {    
    return (E)list[index];
  }
  
  /**
   * Finds the index of an Object in the ArrayList
   * @param o the object
   * @return the index of o if it is in the ArrayList, -1 if it 
   * is not in the ArrayList
   */
  public int indexOf(Object o) {
    int index = -1;
    for(int i = 0; i < size; i++) {
      if(list[i].equals(o)) {
        index = i; break;
      }
    }
    return index;
  }
  
  /**
   * Checks if the ArrayList is empty
   * @return true if the ArrayList contains no elements,
   * false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }
  
  /**
   * Finds the last index of object o
   * @param o the object
   * @return the last index of o in the ArrayList, -1 if
   * it is not in the ArrayList
   */
  public int lastIndexOf(Object o) {
    int index = -1;
    for(int i = 0; i < size; i++) {
      if(list[i].equals(o)) index = i;
    }
    return index;
  }
  
  /**
   * Removes the element at the specified index, shifts the 
   * following elements accordingly
   * @param index to remove
   * @return the element that is removed
   */
  public E remove(int index) {
    if(index > size) return null;
    E element = null;
    for(int i = index+1; i < size; i++) {
      list[i-1] = list[i];
    }
    list[size-1] = null;
    size--;
    return element;
  }
  
  /**
   * Removes the specified object from the ArrayList
   * @param o the object to remove
   * @return true if the Object is successfully, false otherwise
   */
  public boolean remove(Object o) {
    int index = indexOf(o);
    if (index == -1) return false;
    remove(index);
    return true;
  }
  
  /**
   * Sets the element at the specified index to the given element
   * @param index the index to set the new element
   * @param element the new element
   * @return the element that was previously at the given index
   */
  public E set(int index, E element) {
    if(index < 0 || index >= size())
      throw new IndexOutOfBoundsException();
    E currentElement = get(index);
    list[index] = element;
    return currentElement;
  }
  
  /**
   * Returns the number of elements in the ArrayList
   * @return size - how many elements the ArrayList contains
   */
  public int size() {
   return size;
  }
  
  /**
   * Returns a sublist of the current ArrayList
   * @param fromIndex the beginning of the subList
   * @param toIndex the end of the subList
   * @return a new ArrayList with a shallow copy of the elements
   * from the index fromIndex to the index toIndex
   */
  public ArrayList<E> subList(int fromIndex, int toIndex) {
    ArrayList<E> temp = new ArrayList<E>();
    for(int i = fromIndex; i< toIndex; i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
  
  /**
   * Returns the elements of the ArrayList in an array
   * @return an array containing a shallow copy of the elements
   * in ArrayList
   */
  public Object[] toArray() {
    Object[] arr = new Object[size];
    for(int i = 0; i < this.size; i++) {
      arr[i] = this.get(i);
    }
    return arr;
  }
  
  
  public String toString() {
    if(size == 0) return "[]";
    String str = "{" + list[0];
    for(int i = 1; i < size; i++) {
      str = str + ", " + list[i];
    }
    str = str + "]";
    return str;
    
  }
  

  

}
