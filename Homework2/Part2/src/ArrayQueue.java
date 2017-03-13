import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Created by Andy on 2/8/17.
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity){
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object [initialCapacity+1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    }
    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added. */
    public void enqueue(T newEntry){
        checkInitialization();
        ensureCapacity();
        backIndex= (backIndex+1) % queue.length;
        queue[backIndex] = newEntry;

    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty before the operation. */
    public T dequeue(){
        checkInitialization();
        if(isEmpty())
            throw new NoSuchElementException();
        else
        {
            T front = queue [frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex+1) % queue.length;
            return front;
        }

    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty. */
    public T getFront(){
        checkInitialization();

        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return queue[frontIndex];
        }

    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty(){
        return frontIndex == ((backIndex +1) % queue.length);
    }

    /** Removes all entries from this queue. */
    public void clear(){
        frontIndex = 0;
        backIndex = queue.length -1;

    }

    private void checkInitialization(){
        if(!initialized)
            throw new SecurityException("ArrayStack object is not initialized properly");
    }

    private void ensureCapacity(){
        if(frontIndex== ((backIndex +2) % queue.length)){
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2* oldSize;
            checkCapacity(newSize);

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for(int i =0 ; i<oldSize-1 ; i++){
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex +1) % oldSize;
            }

            frontIndex=0;
            backIndex = oldSize - 2;
        }
    }

    private void checkCapacity(int desiredCapacity) {
        if(desiredCapacity > MAX_CAPACITY )
            throw new IllegalStateException("Attempt to create a bag" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    public Iterator<T> getIterator(){
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T>{
        private int index =0;

        public boolean hasNext(){
            return index <queue.length;
        }
        public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            T result = queue[(index + frontIndex) % queue.length];
            index++;
            return result;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
