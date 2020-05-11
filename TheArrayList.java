import java.util.Arrays;
import java.util.*;
//David Nygren
//IT 179 003
//Homework 04

//This class implements functions that can be used for ArrayLists
/** This class implements ListInter interface using an array as data structure 
 Homework 4
 */
public class TheArrayList<E> implements ListInter<E> {
    // Data fields
    private int capacity;
    private int size;
    private E[] theData;
    private static final int INITIAL_CAPACITY = 10;
    
    // Constructor
    @SuppressWarnings("unchecked")
    public TheArrayList(){
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }
        
    /** Reallocate method - Creates a new array that is twice the size of the current array and then copies the contents of the current array into the new one
     */
    private void reallocate(){
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }
    
    
    /** Append an element to the end of the list
     @param element element to be inserted
     @return true
     */
    
    public boolean add(E element){
        if (size==capacity){
            reallocate();
        }
        theData[size] = element;
        size++;
        return true;
        
    }
    
    
    /** Inserts the specified element at the specified position in this list.
     @param index - index at which the specified element is to be inserted
     @param element - element to be inserted
     */
    
    public  void add(int index, E element){
        if (index<0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        if (size==capacity){
            reallocate();
        }
        int i = size;
        while(i > index){
            theData[i] = theData[i-1];
            i--;
        }
        theData[index] = element;
        size++;
        
        
    }
    
    /** get method - Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return element - the element at the specified position in this list
     */
    
    public E get(int index){
        if (index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
        
    }
    
    /** Removes the first variable in the arraylist
     */
    public E removeFirst(){
        //check for the size
        if (size<=0){
            throw new NoSuchElementException();
        }
        E returnValue = theData[0];
        E[] copyData = (E[]) new Object[size-1];
        for (int i = 1; i < size; i++){
         copyData[i-1] = theData[i];   
        }
        theData = copyData;
        size--;
        return returnValue;
    }
    
    /** Removes the variable in the arraylist at the given index
     */
    public E remove(int index){
        //check to make sure the input isn't out of bounds
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
       }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++){
         theData[i-1] = theData[i];   
        }
        size--;
        return returnValue;
    }
    
    /** returns the first variable in the arraylist
     */
    public E getFirst(){
        if (size<0){
            throw new NoSuchElementException();
        }
        return theData[0];
    }
    
    /** returns the last variable in the arraylist
     */
    public E getLast(){
        if (size<0){
            throw new NoSuchElementException();
        }
        return theData[size-1];
    }
    
    /** returns the size of the arraylist
     */
    public int size(){
         return size;
    }

    
    /** Returns a string representation of this collection.
     @return a string representation of this collection
     
     */
    public String toString(){
        String str = "";
        for (int i=0; i<size; i++){
            if (i==size-1){
                str = str + theData[i];
            }else
            {
                str = str + theData[i] + ", ";
            }
        }
        return "[" + str + "]";
    }
    
    
    
}