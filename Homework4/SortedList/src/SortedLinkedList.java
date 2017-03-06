/**
 * Created by Andy on 3/6/17.
 */
import java.util.LinkedList;
public class SortedLinkedList<T extends Comparable<? super T>>
                                implements SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;
    private LinkedList<T> list;

    public SortedLinkedList(){
        initializeDataFields();
        list = new LinkedList<>();
    }

    //Initializes the class's data fields to indicate an empty list
    private void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    }// end initializeDataFields

    /** Adds a new entry to this sorted list in its proper order.
     The list's size is increased by 1.
     @param newEntry  The object to be added as a new entry. */
    public void add(T newEntry){
        int newPosition = Math.abs(getPosition(newEntry));
        list.add(newPosition, newEntry);
    }

    private Node getNodeBefore(T anEntry){

        Node currentNode = firstNode;
        Node nodeBefore  = null;

        while( (currentNode != null) &&
                (anEntry.compareTo(currentNode.getData()) > 0) ){
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while

        return nodeBefore;
    }// end getNodeBefore


    /** Removes the first or only occurrence of a specified entry
     from this sorted list.
     @param anEntry  The object to be removed.
     @return  True if anEntry was located and removed;
     otherwise returns false. */
    public boolean remove(T anEntry){

        boolean result = false;
        int position = getPosition(anEntry);

        if(position >0){
            list.remove(position);
            result = true;
        }

        return result;
    }

    /** Gets the position of an entry in this sorted list.
     @param anEntry  The object to be found.
     @return  The position of the first or only occurrence of anEntry
     if it occurs in the list; otherwise returns the position
     where anEntry would occur in the list, but as a negative
     integer. */
    public int getPosition(T anEntry){
        int position =1;
        int length = list.size();

        while( (position <= length) &&
                (anEntry.compareTo(list.get(position)) >0 )){
            position ++;
        }
        if((position > length) ||
                (anEntry.compareTo(list.get(position)) != 0))
            position = -position;

        return position;
    }

    /**
     * Removes entry at indicated position and returns the object that was removed .
     * @param position is the integer representing the position in the list to be removed
     * @return The object that was removed at the indicated position
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public T remove(int position){

        T result = null;
        if((position >= 1) && (position <= numberOfEntries)){

            assert !isEmpty();
            if(position==1){
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else {
                Node nodeBefore = getNodeAt(position - 1);
                Node nodeRemove = nodeBefore.getNextNode();
                Node nodeAfter = nodeRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = nodeRemove.getData();
            } //end inner if loop

            numberOfEntries--;
            return result;
        }
        else{
            throw new IndexOutOfBoundsException("Illegal position given.");
        }// end outer if loop
    }//end remove

    /**
     * Finds and returns the object at the indicated position within the list
     * @param position The index in the list
     * @return The object occupying index position
     * @throws IndexOutOfBoundsException if given a position >0 or greater than list size
     */
    public T getEntry(int position){

        if((position >= 1) && (position <= numberOfEntries)){
            assert !isEmpty();
            return getNodeAt(position).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given");
    }// end getEntry

    /**
     * Checks for given object in the list.
     * @param anEntry The object to be searched for within the list
     * @return true if anEntry is found within the list. False otherwise
     */
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && currentNode!= null){
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    /**
     * Removes all entries from list
     */
    public void clear(){
        initializeDataFields();
    }

    /**
     * Checks to see if the list is empty or not
     * @return true if empty, otherwise is false
     */
    public boolean isEmpty(){

        boolean result;
        if(numberOfEntries ==0) {
            assert firstNode == null;
            result = true;
        }
        else{
            assert firstNode != null;
            result = false;
        }

        return result;
    }//end isEmpty

    /**
     * Gets the size of the list
     * @return A number representing the number of objects in the list
     */
    public int getLength(){
        return numberOfEntries;
    }

    /**
     * Retrieves all entries within the list in the order in which they occur
     * @return An array of all the entries in the list
     */
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode!= null)){
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    } // end toArray

    /**
     * Gets node at indicated position
     * @param givenPosition Position to get node at
     * @return Node at given position
     */
    private Node getNodeAt(int givenPosition){
        assert((firstNode != null) && (givenPosition <= numberOfEntries)
                &&(1<= givenPosition));
        Node currentNode = firstNode;

        for(int counter =1 ; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        return currentNode;
    }


    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion){
            this(dataPortion, null);
        }

        private Node(T dataPortion , Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }


    }

}
