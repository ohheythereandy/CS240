/**
 * Created by Andy on 2/8/17.
 **/
import java.util.NoSuchElementException;
import java.util.Iterator;
public class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>{

    private Node queueNode;
    private Node freeNode;

    public TwoPartCircularLinkedQueue( ){
        freeNode = new Node (null, null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    }

    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added. */
    public void enqueue(T newEntry){
        freeNode.setData(newEntry);

        if(isChainFull()){
            Node newNode = new Node(null, freeNode.getNextNode());
            freeNode.setNextNode(newNode);
        }
        freeNode = freeNode.getNextNode();
    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty before the operation. */
    public T dequeue(){
        T front = getFront();
        assert !isEmpty();
        queueNode.setData(null);
        queueNode = queueNode.getNextNode();

        return front;
    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty. */
    public T getFront(){
        if(isEmpty())
            throw new NoSuchElementException();
        else
            return queueNode.getData();

    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty(){
        return queueNode == freeNode;
    }

    /** Removes all entries from this queue. */
    public void clear(){
        queueNode = freeNode;
    }

    private boolean isChainFull(){
        return queueNode == freeNode.getNextNode();
    }

    public Iterator<T> getIterator(){
        return new TwoPartLinkedQueueIterator();
    }

    private class TwoPartLinkedQueueIterator implements Iterator<T>{

        private Node currentNode;

        public TwoPartLinkedQueueIterator(){
            currentNode = queueNode;
        }
        public boolean hasNext(){
            return currentNode!= freeNode.getNextNode();
        }

        public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            T result = currentNode.getData();
            currentNode= currentNode.next;
            return result;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
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
