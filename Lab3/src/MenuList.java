/**
 * Created by Andy on 2/11/17.
 */
import java.util.Vector;
public class MenuList<T> implements ListInterface<T> {

    private Vector<T> list;
    private boolean initialized;
    private static final int DEFAULT_CAPACITY = 20;
    private static final int MAX_Capacity = 10000;

    public MenuList(){
        this (DEFAULT_CAPACITY);
    }

    public MenuList(int initialCapacity){
        checkCapacity(initialCapacity);
        list = new Vector<>(initialCapacity);
        initialized = true;
    }

    /**
     * Adds newEntry to the end of the list
     * List size increased by 1
     * @param newEntry Entry to be added
     */
    public void add(T newEntry){
        checkInitialization();
        list.add(newEntry);
    }

    /**
     * Adds newEntry at the position indicated . Entry at position is shifted to next highest position
     * List size increased by one
     * @param newEntry is the object to be added within list
     * @param position is the integer representing position that newEntry is inserted to
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public void add(T newEntry, int position){
        checkInitialization();
        checkListPosition(position);

        list.add(position, newEntry);
    }

    /**
     * Removes entry at indicated position and returns the object that was removed .
     * @param position is the integer representing the position in the list to be removed
     * @return The object that was removed at the indicated position
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public T remove(int position){
        checkInitialization();
        checkListPosition(position);
        T remove = list.remove(position);
        return remove;
    }

    /**
     * Removes all entries from list
     */
    public void clear(){
        list.clear();
    }

    /**
     * Replaces entry at given position with the object newEntry
     * @param position The integer position at which the object will be swapped with
     * @param newEntry  The object that will replace the object at the indicated position
     * @return Original entry that was replaced
     * @throws IndexOutOfBoundsException if given a position > 0 or greater than list size
     * */
    public T replace(int position , T newEntry){
        checkInitialization();
        checkListPosition( position);
        T original = list.remove(position);
        list.add(position , newEntry);

        return original;
    }

    /**
     * Finds and returns the object at the indicated position within the list
     * @param position The index in the list
     * @return The object occupying index position
     * @throws IndexOutOfBoundsException if given a position >0 or greater than list size
     */
    public T getEntry(int position){
        checkInitialization();
        checkListPosition(position);
        T anEntry = list.get(position);
        return anEntry;
    }

    /**
     * Retrieves all entries within the list in the order in which they occur
     * @return An array of all the entries in the list
     */
    public T[] toArray(){


        T[] tempList = (T[])list.toArray();


        return tempList;
    }

    /**
     * Checks for given object in the list.
     * @param anEntry The object to be searched for within the list
     * @return true if anEntry is found within the list. False otherwise
     */
    public boolean checkEntry(T anEntry){
        checkInitialization();
        boolean found = list.contains(anEntry);

        return found;
    }

    /**
     * Gets the size of the list
     * @return A number representing the number of objects in the list
     */
    public int checkSize(){
        checkInitialization();
        return list.size();
    }

    /**
     * Checks to see if the list is empty or not
     * @return true if empty, otherwise is false
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    private void checkInitialization(){
        if(!initialized)
            throw new SecurityException("VectorStack not properly initialized");
    }

    private void checkListPosition(int listPosition){
        if((listPosition > 0) || (listPosition > checkSize()))
            throw new IndexOutOfBoundsException("Invalid list position.");
    }

    private void checkCapacity(int desiredCapacity){
        if(desiredCapacity > MAX_Capacity){
            throw new IllegalStateException("Attempt to create a list" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_Capacity);
        }
    }
}