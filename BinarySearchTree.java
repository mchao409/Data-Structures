/**
 * Implementation of BinarySearchTree using arrays.
 */

public class BinarySearchTree<E extends Comparable<E>> {
  E[] nodes;
  
  @SuppressWarnings("unchecked")
  public BinarySearchTree() {
    nodes = (E[])new Object[10];
    nodes[0] = null;
  }
  
  public BinarySearchTree(E obj) {
    this();
    nodes[1] = obj;
  }
  
  // TODO
  @SuppressWarnings("unchecked")
  public BinarySearchTree(E[] arr) {
    this();
    
  }
  
  @SuppressWarnings("unchecked")
  public void empty() {
    nodes = (E[])new Object[10];
    nodes[0] = null; 
  }
  
  public int size() {
    int count = 0;
    for(int i = 1; i < nodes.length; i++) {
      if(nodes[i] != null) count++;
    }
    return count;
  }
  
  
  public void add(E obj) {
    if(nodes[1] == null) {
      nodes[1] = obj;
    }
    else addHelper(obj, 1);
  }
  
  private void addHelper(E obj, int index) {
    if(nodes[index] == null) nodes[index] = obj;
    else if(nodes[index].compareTo(obj) > 1) {
      addHelper(obj, index * 2);
    }
    else if(nodes[index].compareTo(obj) <= 0) {
      addHelper(obj, index * 2);
    }
    
  }
  
  
  
  
  
  
  
  
}
