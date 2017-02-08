
/**
 * Created by Andy on 2/8/17.
 *
 */

public class LinkedQueue <T> implements QueueInterface<T> {

    private Node firstNode;
    private Node lastNode;

    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }

    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added.*/

    public void enqueue(T newEntry){

        Node newNode = new Node(newEntry,null);
        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;

    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue. */
    public T dequeue(){

        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if(firstNode == null)
            lastNode = null;

        return front;
    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue. */
    public T getFront(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else
            return firstNode.getData();

    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty(){
        return(firstNode ==null) && (lastNode == null);
    }

    /** Removes all entries from this queue. */
    public void clear(){
        firstNode= null;
        lastNode = null;

    }
    private class Node{
        private T data ; //Entry in Stack
        private Node next ; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion,null);
        }

        private Node(T dataPortion , Node nextNode){
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }

}
