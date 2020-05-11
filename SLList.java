import java.util.NoSuchElementException;
import java.util.*;

public class SLList<E> implements ListInter<E> {
    /** Creating a node structure
    static nested class - does not have access to other members of the enclosing class
     */
    private static class Node<E> {
        // Data fields
        private E data; // reference to data
        private Node<E> next; // link (reference) to next node

        //Constructor
        /** Creates an new node with a null next field.
         */
        private Node(E dataItem){
            data = dataItem;
            next = null;
        }
    }

    // Data fields for SLL
    private Node<E> head = null;
    private int size = 0;

    /** Remove the node after a given node
    @param nodeRef - The node before the one to be removed
    @return - The data from the removed node, or nullâ€‰if there is no node to remove
     */
    private E removeAfter(Node<E> nodeRef){
        Node<E> temp = nodeRef.next;
        if(temp != null){
            nodeRef.next = temp.next;
            size--;
            return temp.data;
        } else{
            return null;
        }
    }

    /** Traverse the list: Find the node at a specified position
    @param index The position of the node sought
    @return The node at index or null if it does not exist
     */
    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i = 0; i< index && node != null; i++){
            node = node.next;
        }
        return node;
    }

    /**  Get the data at an index 
     * @param index - index of the element to return
     * @return   the element at the specified position in this list
     */
    public E get(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /** Inserts an item at the beginning of this list.
    @param item - the item to add
     */
    public void addFirst(E item){
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Adds/Insert an item after a given node
    @param nodeRef - Reference node after which the item is to be inserted
    @param item - element to be inserted
     */
    private void addAfter(Node<E> nodeRef, E item){
        Node<E> newNode = new Node<>(item);
        newNode.next = nodeRef.next;
        nodeRef.next = newNode;
        size++;
    }

    /** Insert the data item at a specified index
    @param item - item to be added
    @param index - position to
     */
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0)
            addFirst(item);
        else{
            Node<E> node = getNode(index-1); // 
            addAfter(node, item);
        }
    }

    /** Append an element to the end of the list
     @param element element to be inserted
     @return true
     */
    public boolean add(E item){
        add(size, item);
        return true;
    }

    /** Returns the first variable in the SLL
     */
    public E getFirst(){
        Node<E> node = head;
        if (node == null) 
            throw new NoSuchElementException(); 

        Node<E> returNode = getNode(0);

        return returNode.data;
    }

    /** Returns the last variable in the SLL
     */
    public E getLast(){
        Node<E> node = head;
        if (node == null) 
            throw new NoSuchElementException(); 
        Node<E> returNode = getNode(size-1);

        return returNode.data;
    }

    /** Removes the first variable in the SLL
     */
    public E removeFirst(){
        Node<E> node = head;  
        if (node == null) 
            throw new NoSuchElementException(); 
        Node<E> returNode = getNode(0);
        head = node.next;
        size--;        
        return returNode.data; 
    }

    /** Removes the variable in the SLL at the given index
     */
    public E remove(int index){
        Node<E> node = head;  
        if (index < 0 || index >=size) 
            throw new IndexOutOfBoundsException(index);

        Node<E> returNode = getNode(index);
        //connecting the nods on both sides in order to remove
        if(index > 0){
            Node<E> previous = getNode(index-1);
            Node<E> after = getNode(index+1);

            previous.next = after;
        }
        else if (index == 0){
        head = node.next;
        }
        size--;        
        return returNode.data; 
    }

    /** returns the size of the SLL
     */
    public int size(){
        return size;
    }

    /** Return string representation of the list*/
    public String toString(){
        if (head==null){
            return "No items in the list";
        }
        String str = "";
        for(int i = 0; i<size-1; i++){
            str+= get(i) + " -> ";
        }
        return "[ " + str + get(size-1) + " ]";
    }

}