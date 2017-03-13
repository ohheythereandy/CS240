/**
 * Created by Andy on 2/7/17.
 */

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack; // Array of stack entries
    private int topIndex; //Index of top entry
    private boolean initialized = false ;
    private static final int MAX_CAPACITY =50;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity){

        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;

    }

    private void checkInitialization() {
        if(!initialized)
            throw new SecurityException("ArrayStack object is not initialized properly");

    }

    private void checkCapacity(int desiredCapacity) {
        if(desiredCapacity > MAX_CAPACITY )
            throw new IllegalStateException("Attempt to create a bag" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_CAPACITY);
    }

    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry){
        checkInitialization();
        ensureCapacity();
        stack[topIndex+1] = newEntry;
        topIndex++;

    }

    private void ensureCapacity(){
        if(topIndex == stack.length -1){
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack , newLength);
        }

    }

    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty before the operation. */
    public T pop(){

        T top = peek();
        stack[topIndex] = null;
        topIndex--;
        return top;

    }

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty. */
    public T peek() {

        checkInitialization();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else
            return stack[topIndex];

    }

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty(){
        return topIndex < 0;

    }

    /** Removes all entries from this stack. */
    public void clear(){

    }

    public Iterator<T> iterator(){
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<T>{
        private int index;

        public ArrayStackIterator(){
            index = topIndex -1;
        }

        public boolean hasNext(){
            return index >= 0;
        }

        public T next(){

            T result ;

            if(!hasNext()){
                throw new NoSuchElementException();
            }
            else{
                result = stack[index];
                index--;
                return result;
            }
        }//end next()

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

}//end Stack
