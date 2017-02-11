/**
 * Created by Andy on 2/10/17.
 */
public interface DequeueInterface<T> {
    /** Adds a new entry to the front/ back of this dequeue.
     * @param newEntry An object to be added
     */
    public void addToFront(T newEntry);
    public void addToBack(T newEntry);

    /** Removes and returns the front/back entry of the dequeue.
     * @return The object at the front/back of the dequeue
     * @throws EmptyQueueException if the dequeue is empty before the operation
     */
    public T removeFront();
    public T removeBack();

    /** Retrieves the the front/back entry of this dequeue.
     * @return The object at the front/back
     * @throws EmptyQueueException if the dequeue is empty
     */
    public T getFront();
    public T getBack();

    /** Detects whether this dequeue is empty.
     * @return True if the dequeue is empty.
     */
    public boolean isEmpty();

    /** Removes all entries from this dequeue */
    public void clear();

}
