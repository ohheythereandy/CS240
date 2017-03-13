import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Andy on 2/7/17.
 */
public final class LinkedStack<T> implements StackInterface<T> {

    private Node topNode; //references first node in chain

    public LinkedStack() {
        topNode = null;
    }


    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry){
        Node newNode = new Node(newEntry , topNode);
        topNode = newNode;
    }

    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty before the operation. */
    public T pop(){
        T top = peek();

        if(top == null)
            throw new EmptyStackException();
        else{
            topNode = topNode.getNextNode();
        }

        return top;
    }

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty. */
    public T peek(){

        if(isEmpty())
            throw new EmptyStackException();
        else{
            return topNode.getData();
        }
    }

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty(){
        return topNode == null;
    }

    /** Removes all entries from this stack. */
    public void clear(){
        topNode = null;
    }

    public Iterator<T> getIterator(){
        return new LinkedStackIterator();
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

    private class LinkedStackIterator implements Iterator<T>{

        private Node currentNode = topNode;

        public boolean hasNext(){
            return currentNode != null;
        }

        public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            else{
                T data = currentNode.getData();
                currentNode = currentNode.next;
                return data;
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

}
