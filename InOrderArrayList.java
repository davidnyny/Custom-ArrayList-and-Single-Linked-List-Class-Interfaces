import java.util.*;
public class InOrderArrayList<E>
{
    private TheArrayList<E> arr = new TheArrayList<E>();

    /** Inserts obj into the list preserving
    the list’s order.
     */
    public void addOrder(E obj){
        boolean check = true;
        //If Arraylist is empty
        if (arr.size() == 0) {
            arr.add(obj);
            check = false;
        }

        if (check == true){
            for (int i = 0; i < arr.size(); i++){
                //If variable should be placed first
                if (compareTo(arr.get(0), obj) == -1){
                    arr.add(0,obj);
                    break;
                }
                //If variable is the same as another, add it right after
                else if(compareTo(arr.get(i), obj) == 0){
                    arr.add(i, obj);
                    break;
                }
                //If variable should be placed at end
                else if(i == (arr.size()-1)){
                    arr.add(obj);
                    break;
                }
                //Check if object should be placed in the middle of two objects
                else if((compareTo(arr.get(i), obj) == 1) && (compareTo(arr.get(i+1), obj) == -1)){
                    arr.add(i+1, obj);
                    break;
                }
            }
        }
    }

    /** Returns the object at the specified index
     */
    public E get(int index){
        return arr.get(index);
    }

    /** Removes first occurrence of
    obj from the list. Returns true if the list contained object obj; otherwise,
    returns false. 
     */
    public boolean removeOrder(E obj){
        boolean check = false;
        for (int i = 0; i < arr.size(); i++){
            //If they are equal, break the loop and return true
            if (arr.get(i) == obj){
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
        return arr.toString();
    }

    /**   returns the size of the ordered list 
     */
    public int size(){
        return arr.size();
    }

    /**    returns largest element in the list 
     */
    public E max(){
        return arr.get(arr.size()-1);
    }

    /**    returns smallest element in the list 
     */
    public E min(){
        return arr.get(0);
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
