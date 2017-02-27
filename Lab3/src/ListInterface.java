/**
 * @author Andy on 2/10/17.
 */
public interface ListInterface<T> {

    /**
     * Adds newEntry to the end of the list
     * List size increased by 1
     * @param newEntry Entry to be added
     */
    public void add(T newEntry);

    /**
     * Adds newEntry at the position indicated . Entry at position is shifted to next highest position
     * List size increased by one
     * @param newEntry is the object to be added within list
     * @param position is the integer representing position that newEntry is inserted to
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public void add(T newEntry, int position);

    /**
     * Removes entry at indicated position and returns the object that was removed .
     * @param position is the integer representing the position in the list to be removed
     * @return The object that was removed at the indicated position
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public T remove(int position);

    /**
     * Removes all entries from list
     */
    public void clear();

    /**
     * Replaces entry at given position with the object newEntry
     * @param position The integer position at which the object will be swapped with
     * @param newEntry  The object that will replace the object at the indicated position
     * @return Original entry that was replaced
     * @throws IndexOutOfBoundsException if given a position > 0 or greater than list size
     * */
    public T replace(int position , T newEntry);

    /**
     * Finds and returns the object at the indicated position within the list
     * @param position The index in the list
     * @return The object occupying index position
     * @throws IndexOutOfBoundsException if given a position >0 or greater than list size
     */
    public T getEntry(int position);

    /**
     * Retrieves all entries within the list in the order in which they occur
     * @return An array of all the entries in the list
     */
    public T[] toArray();

    /**
     * Checks for given object in the list.
     * @param anEntry The object to be searched for within the list
     * @return true if anEntry is found within the list. False otherwise
     */
    public boolean checkEntry(T anEntry);

    /**
     * Gets the size of the list
     * @return A number representing the number of objects in the list
     */
    public int checkSize();

    /**
     * Checks to see if the list is empty or not
     * @return true if empty, otherwise is false
     */
    public boolean isEmpty();
}// end ListInterface