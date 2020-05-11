public interface ListInter<E> {
    
    /** Insert the data item at a specified index
     @param item - item to be added
     @param index - position to
     */
     public void add(int index, E item);
    
    /** Append to the end of the list
     @param item - item to be added
     @return true - if item has been added
     */
    public boolean add(E item);

    
    /**  Get the data at an index
     * @param index - index of the element to return
     * @return   the element at the specified position in this list
     */
    public E get(int index);
    
    
    /** Removes and returns the first element from this list.
     @return the removed element
     @throws NoSuchElementException - if this list is empty
     */
    public E removeFirst();
    
    /**
     Removes the element at the specified position in this list.
     @param index - the index of the element to be removed
     @return  the element previously at the specified position
     @throws IndexOutOfBoundsException - if the index is out of range
     */
    public E remove(int index);
    
    
    /**
     Returns the first element in this list.
     @return the first element in this list
     @throws NoSuchElementException - if this list is empty
     */
    public E getFirst();
    /**
     Returns the last element in this list.
     @return the last element in this list
     @throws NoSuchElementException - if this list is empty
     */
    
    public E getLast();
    
    /** Returns the number of elements in this list.
     @return  the number of elements in this list
     */
    public  int size();
    
    
    /** Returns a string representation of this collection. 
     The string representation consists of a list of the collection's 
     elements in the order they are returned by its iterator, 
     enclosed in square brackets ("[]"). Adjacent elements 
     are separated by the characters ", " (comma and space).
     @return a string representation of this collection
     
     */
     public String toString();
    
}


