import java.util.NoSuchElementException;

/**
 * Created by Andy on 2/10/17.
 */
public class DoublyLinkedChain<T> implements DequeueInterface<T> {

    private DLNode firstNode;   //References node at front of queue
    private DLNode lastNode;    //References node at back of queue

    public DoublyLinkedChain(){
        firstNode = null;
        lastNode= null;
    }

    /** Adds a new entry to the front/ back of this dequeue.
     * @param newEntry An object to be added
     */
    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry , firstNode);

        if(isEmpty())
            lastNode = newNode;
        else
            firstNode.setPreviousNode(newNode);

        firstNode = newNode;
    }   //end addToFront
    public void addToBack(T newEntry){

        DLNode newNode = new DLNode(lastNode , newEntry, null);

        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    } // end addToBack

    /** Removes and returns the front/back entry of the dequeue.
     * @return The object at the front/back of the dequeue
     * @throws NoSuchElementException if the dequeue is empty before the operation
     */
    public T removeFront(){
        T front = getFront();

        assert firstNode != null;

        firstNode = firstNode.getNextNode();

        if(firstNode == null)
            lastNode=null;
        else
            firstNode.setPreviousNode(null);
        return front;
    } // end removeFront
    public T removeBack(){
        T reverseFront = getBack();
        assert lastNode != null;

        lastNode = lastNode.getPreviousNode();

        if(lastNode == null)
            firstNode = null;
        else
            lastNode.setNextNode(null);

        return reverseFront;
    }

    /** Retrieves the the front/back entry of this dequeue.
     * @return The object at the front/back
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T getFront(){
        if(isEmpty())
            throw new NoSuchElementException();
        else
            return firstNode.getData();

    }
    public T getBack(){
        if(isEmpty())
            throw new NoSuchElementException();
        else
            return lastNode.getData();
    }

    /** Detects whether this dequeue is empty.
     * @return True if the dequeue is empty.
     */
    public boolean isEmpty(){
        return ((firstNode == null) && (lastNode== null));
    }

    /** Removes all entries from this dequeue */
    public void clear(){
        while(!isEmpty()){
            removeFront();
        }
    }

    private class DLNode {
        private T data; // Deque entry
        private DLNode next;    // Link to next node
        private DLNode previous;    //Link to previous node

        public DLNode(DLNode first , T anEntry , DLNode last){
            data = anEntry;
            next = last;
            previous = first;
        }
        private T getData(){
            return data;
        }
        private void setData(T newEntry){
            data = newEntry;
        }
        private DLNode getNextNode(){
            return next;
        }

        private void setNextNode(DLNode node){
            next = node;
        }
        private DLNode getPreviousNode(){
            return previous;
        }
        private void setPreviousNode(DLNode node){
            previous = node;
        }
    }

} // end DoublyLinkedChain


