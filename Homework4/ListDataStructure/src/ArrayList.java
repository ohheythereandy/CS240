/**
 * Created by Andy on 3/5/17.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity){
        if(initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
                T[] tempList = (T[]) new Object[initialCapacity +1];
        list = tempList;
        numberOfEntries = 0;
        initialized = true;
    }// end constructor

    /**
     * Adds newEntry to the end of the list
     * List size increased by 1
     * @param newEntry Entry to be added
     */
    public void add(T newEntry){
        checkInitialization();
        list[numberOfEntries+1] = newEntry;
        numberOfEntries++;

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

        if((position>=1) && (position<= numberOfEntries +1)){
            if(position<= numberOfEntries)
                makeRoom(position);
            list[position] = newEntry;
            numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException("Given position of add's entry is out of bounds");
    }

    private void makeRoom(int newPosition){
        assert((newPosition >=1) && (newPosition <= numberOfEntries+1));

        int newIndex = newPosition;
        int lastIndex = numberOfEntries;

        for(int index = lastIndex; index >= newIndex ; index--){
            list[index+1] = list[index];
        }
    }// end makeROom

    /**
     * Removes entry at indicated position and returns the object that was removed .
     * @param position is the integer representing the position in the list to be removed
     * @return The object that was removed at the indicated position
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public T remove(int position){
        checkInitialization();

        if((position >=1) && (position <= numberOfEntries)){
            assert !isEmpty();
            T result = list[position];

            if(position < numberOfEntries)
                removeGap(position);
            numberOfEntries--;
            return result;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation");
    }

    public void removeGap(int givenPosition){
        assert ((givenPosition >= 1 ) && (givenPosition < numberOfEntries));

        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries;

        for(int index = removedIndex ; index < lastIndex; index ++){
            list[index] = list[index +1];
        }
    }//end removeGap

    /**
     * Removes all entries from list
     */
    public void clear(){
        for(int index = 0 ; index <= numberOfEntries; index++){
            list[index] = null;
        }
        numberOfEntries = 0;
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

        if((position >= 1 ) && (position <= numberOfEntries)){
            assert !isEmpty();
            T originalEntry = list[position];
            list[position] = newEntry;
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace");
    }

    /**
     * Finds and returns the object at the indicated position within the list
     * @param position The index in the list
     * @return The object occupying index position
     * @throws IndexOutOfBoundsException if given a position >0 or greater than list size
     */
    public T getEntry(int position){
        checkInitialization();

        if((position >=1) && (position <= numberOfEntries)){
            assert !isEmpty();
            return list[position];
        }
        else
            throw new IndexOutOfBoundsException("Illegal Position given to getEntry operation");
    }

    /**
     * Retrieves all entries within the list in the order in which they occur
     * @return An array of all the entries in the list
     */
    public T[] toArray(){
        checkInitialization();

        @SuppressWarnings("unchecked")
                T[] result = (T[]) new Object[numberOfEntries];

        for(int index = 0 ; index < numberOfEntries; index ++)
            result[index] = list[index+1];

        return result;
    }

    /**
     * Checks for given object in the list.
     * @param anEntry The object to be searched for within the list
     * @return true if anEntry is found within the list. False otherwise
     */
    public boolean checkEntry(T anEntry){
        assert !isEmpty();
        boolean isFound = false;

        for(int i = 0 ; i <= numberOfEntries; i++){
            if(anEntry.equals(list[i]))
                isFound = true;
        }

        return isFound;
    }

    /**
     * Gets the size of the list
     * @return A number representing the number of objects in the list
     */
    public int checkSize(){
        return numberOfEntries;
    }

    /**
     * Checks to see if the list is empty or not
     * @return true if empty, otherwise is false
     */
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    private void checkInitialization(){
        if(!initialized)
            throw new SecurityException("ArrayList not properly initialized");
    }

    private void checkCapacity(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_CAPACITY);
        }

    }

    public Iterator<T> getArrayListIterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{

        private int index ;

        public ArrayListIterator(){
            index = 0;

        }
        public boolean hasNext(){
           return index <= numberOfEntries;
        }

        public T next(){
            T result;
            if(!hasNext())
                throw new NoSuchElementException();
            else{
                result = list[index];
                index++;
                return result;
            }
        }

        public void remove(){
            throw new NoSuchElementException();
        }

    }// end ArrayListIterator
}//end ArrayList
