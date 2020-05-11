import java.util.*;
//David Nygren
//IT 179 003
//Homework 04

//This class creates an ordered list for a SLL
public class InOrderSLL<E>
{
    //Declare an SLList object
    private SLList<E> sll;
    public InOrderSLL(){
        sll = new SLList<E>();
    }

    /** Inserts obj into the list preserving
    the list’s order.
     */
    public void addOrder(E obj){
        if(sll.size() == 0){
            //Insert the first object
            sll.addFirst(obj);   
        }
        else{
            for (int i = 0; i < sll.size(); i++){
                //Check if the object is greater than the object at index
                if (i >= 0 && ((int)sll.get(i) > (int)obj)){
                    sll.add(i, obj);
                    break;
                }
            }
        }
    }

    /** Returns the object at the specified index
     */
    public E get(int index){
        return sll.get(index);
    }

    /** Removes first occurrence of
    obj from the list. Returns true if the list contained object obj; otherwise,
    returns false. 
     */
    public boolean removeOrder(E obj){
        boolean check = false;
        for (int i = 0; i < sll.size(); i++){
            //If they are equal, break the loop and return true
            if (sll.get(i) == obj){
                check = true;
                break;
            }
        }
        return check;
    }

    /**  Method to Print all entries in the ordered
    list. 
     */
    public String toString(){
        return sll.toString();
    }

    /**   returns the size of the ordered list 
     */
    public int size(){
        return sll.size();
    }

    /**    returns largest element in the list 
     */
    public E max(){
        return sll.get(sll.size()-1);
    }

    /**    returns smallest element in the list 
     */
    public E min(){
        return sll.get(0);
    }

    /**    returns a comparison between two objects (>,<,=)
     */
    public int compareTo(E obj, E com){
        int com1 = (int)obj;
        int com2 = (int)com;
        int check = -2;
        if (com2 > com1){
            check = 1;
        }
        else if (com1 == com2){
            check = 0;
        }
        else {
            check = -1;
        }
        return check;
    }
}