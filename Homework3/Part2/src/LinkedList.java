/**
 * Created by Andy on 2/13/17.
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        initializeDataFields();
    }
    /**
     * Adds newEntry to the end of the list
     * List size increased by 1
     * @param newEntry Entry to be added
     */
    public void add(T newEntry){

        Node newNode = new Node(newEntry);

        if(isEmpty())
            firstNode = newNode;
        else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
    }//end add

    /**
     * Adds newEntry at the position indicated . Entry at position is shifted to next highest position
     * List size increased by one
     * @param newEntry is the object to be added within list
     * @param newPosition is the integer representing position that newEntry is inserted to
     * @throws IndexOutOfBoundsException if position indicated is less than one or longer than list size
     */
    public void add(T newEntry, int newPosition){

        if((newPosition>= 1) && (newPosition <= numberOfEntries+1)){

            Node newNode = new Node(newEntry);

            if(newPosition ==1){
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else {
                Node nodeBefore = getNodeAt(newPosition-1);
                Node nodeAfter = nodeBefore.getNextNode();
                nodeBefore.setNextNode(newNode);
                newNode.setNextNode(nodeAfter);
            }

            numberOfEntries++;
        }
        else{
            throw new IndexOutOfBoundsException("Illegal Position given.");
        }
    }//end add

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
     * Removes all entries from list
     */
    public void clear(){
        initializeDataFields();
    }

    /**
     * Replaces entry at given position with the object newEntry
     * @param position The integer position at which the object will be swapped with
     * @param newEntry  The object that will replace the object at the indicated position
     * @return Original entry that was replaced
     * @throws IndexOutOfBoundsException if given a position > 0 or greater than list size
     * */
    public T replace(int position , T newEntry){

        if((position >= 1) && (position <= numberOfEntries)){
            assert !isEmpty();
            Node nodeToReplace = getNodeAt(position);
            T originalEntry = nodeToReplace.getData();
            nodeToReplace.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal Position given");
    }// end replace

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
     * Checks for given object in the list.
     * @param anEntry The object to be searched for within the list
     * @return true if anEntry is found within the list. False otherwise
     */
    public boolean checkEntry(T anEntry){
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
     * Gets the size of the list
     * @return A number representing the number of objects in the list
     */
    public int checkSize(){
        return numberOfEntries;
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

    //Initializes the class's data fields to indicate an empty list
    private void initializeDataFields(){
        firstNode = null;
        numberOfEntries=0;
    }//end initializeDataFields

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
