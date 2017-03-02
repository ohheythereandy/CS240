/**
 * Created by Andy on 2/7/17.
 */

import java.util.Arrays;
import java.util.EmptyStackException;

public class FoodStack<T> implements StackInterface<T> {

    private T[] stack; // Array of stack entries
    private int topIndex; //Index of top entry
    private boolean initialized = false ;
    private static final int MAX_CAPACITY =100000;
    private static final int DEFAULT_CAPACITY = 10000;

    public FoodStack(){
        this(DEFAULT_CAPACITY);
    }

    public FoodStack(int initialCapacity){

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

}