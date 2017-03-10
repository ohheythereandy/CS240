
import java.util.Iterator;

/**
 * Created by HiThereAndy on 3/10/2017.
 */
public class ArrayDictionary<K, V> implements DictionaryInterface<K,V > {

    private Entry<K ,V>[] dictionary;
    private int numberOfEntries;
    private boolean initialized = false;
    private final static int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrayDictionary(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayDictionary(int initialCapacity){
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        Entry<K,V>[] tempDict = (Entry<K,V>[])new Entry[initialCapacity];
        dictionary= tempDict;
        numberOfEntries = 0;
        initialized=true;
    }

    /** Adds a new entry to this dictionary. If the given search key already
     exists in the dictionary, adds value given to existing value list for the key
     @param key    An object search key of the new entry.
     @param value  An object associated with the search key.
     @return  Either null if the new entry was added to the dictionary
     or the value that was associated with key if that value
     was replaced. */
    public V add(K key, V value){

    }//end ADD

    /** Removes all entries associated with a given key
     @param key  An object search key of the entry to be removed.
     @return  Either the values that was associated with the search key
     or null if no such object exists. */
    public V remove(K key){

    }//end remove

    /** Retrieves from this dictionary the value(s) associated with a given key.
     @param key  An object search key of the entry to be retrieved.
     @return  Either the value(s) that is associated with the search key
     or null if no such object exists. */
    public V getValue(K key){

    }//end getValue

    /** Sees whether a specific entry is in this dictionary.
     @param key  An object search key of the desired entry.
     @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key){

    }// end contAINS

    /** Creates an iterator that traverses all search keys in this dictionary.
     @return  An iterator that provides sequential access to the search
     keys in the dictionary. */
    public Iterator<K> getKeyIterator(){

    }// end getKeyIterator

    /** Creates an iterator that traverses all values in this dictionary.
     @return  An iterator that provides sequential access to the values
     in this dictionary. */
    public Iterator<V> getValueIterator(){

    }// end getValueIterator

    /** Sees whether this dictionary is empty.
     @return  True if the dictionary is empty. */
    public boolean isEmpty(){

    }//end is Empty

    /** Gets the size of this dictionary.
     @return  The number of entries (key-value pairs) currently
     in the dictionary. */
    public int getSize(){

    }//end getSize

    /** Removes all entries from this dictionary. */
    public void clear(){

    }//end clear

    private void checkCapacity(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_CAPACITY);
        }
    }

    private class Entry<S,T> {
        private S key;
        private T value;

        private Entry(S searchKey, T dataValue) {
            key = searchKey;
            value = dataValue;
        }

        private S getKey() {
            return key;
        }

        private T getValue(){
            return value;
        }
    }
}//end ArrayDictionary
