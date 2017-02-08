import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Created by Andy on 2/7/17.
 */
public class VectorStack<T> implements StackInterface<T> {

    private Vector<T> stack; // Last Element is the top entry in stack
    private boolean initialized;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack(){
        this(DEFAULT_CAPACITY);
    }

    public VectorStack(int initialCapacity){
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity);
        initialized=true;

    }
    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry){
        checkInitialization();
        stack.add(newEntry);

    }


    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty before the operation. */
    public T pop(){

        checkInitialization();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack.remove(stack.size()-1);


    }

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty. */
    public T peek(){
        checkInitialization();

        if(isEmpty()){
            throw new EmptyStackException();
        }
        else
            return stack.lastElement();
    }

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /** Removes all entries from this stack. */
    public void clear(){
        stack.clear();
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

}
