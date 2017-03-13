
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
     or the values that were associated with the key before the new addition. */
    public ArrayList<V> add(K key, V value){
        checkInitialization();
        if((key==null) || (value == null)){
            throw new IllegalArgumentException();
        }
        else{
            ArrayList<V> valueList = new ArrayList<>();

            int keyIndex = locateIndex(key);

            //if key is found in dictionary
            if(keyIndex < numberOfEntries){
                valueList = dictionary[keyIndex].getValueList();
                dictionary[keyIndex].setValue(value);
            }
            else{   //key not found, add new entry to dictionary
                dictionary[numberOfEntries] = new Entry<>(key,value);
                numberOfEntries++;
                //ensureCapacity();
            }
            return valueList;
        }

    }//end ADD

    private int locateIndex(K key){

        int index = 0;
        while((index < numberOfEntries) && (!key.equals(dictionary[index].getKey()))){
            index++;
        }
        return index;
    }//end locateIndex

    /** Removes all entries associated with a given key
     @param key  An object search key of the entry to be removed.
     @return  Either the values that was associated with the search key
     or null if no such object exists. */
    public ArrayList<V> remove(K key){

        checkInitialization();
        ArrayList<V> valueList = new ArrayList<>();
        int keyIndex = locateIndex(key);

        //key found, remove entry values and return list of values
        if(keyIndex < numberOfEntries){
            valueList = dictionary[keyIndex].getValueList();
            dictionary[keyIndex] = dictionary[numberOfEntries -1];
            dictionary[numberOfEntries-1] = null;
            numberOfEntries--;
        }//end if

        return valueList;
    }//end remove

    /** Retrieves from this dictionary the value(s) associated with a given key.
     @param key  An object search key of the entry to be retrieved.
     @return  Either the value(s) that is associated with the search key
     or an empty list of no such values exist. */
    public ArrayList<V> getValue(K key){
        ArrayList<V> valueList = new ArrayList<>();

        int keyIndex = locateIndex(key);

        if(keyIndex < numberOfEntries){
            valueList = dictionary[keyIndex].getValueList();
        }

        return valueList;

    }//end getValue

    /** Sees whether a specific entry is in this dictionary.
     @param key  An object search key of the desired entry.
     @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key){

        boolean result = false;
        int index = 0;

        while(index < numberOfEntries){
            if(key.equals(dictionary[index].getKey()))
                result = true;
            index++;
        }

        return result;
    }// end contAINS

    /** Creates an iterator that traverses all search keys in this dictionary.
     @return  An iterator that provides sequential access to the search
     keys in the dictionary. */
//    public Iterator<K> getKeyIterator(){


//    }// end getKeyIterator

    /** Creates an iterator that traverses all values in this dictionary.
     @return  An iterator that provides sequential access to the values
     in this dictionary. */
//    public Iterator<V> getValueIterator(){

//    }// end getValueIterator

    /** Sees whether this dictionary is empty.
     @return  True if the dictionary is empty. */
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }//end is Empty

    /** Gets the size of this dictionary.
     @return  The number of entries (key-value pairs) currently
     in the dictionary. */
    public int getSize(){
        return numberOfEntries;
    }//end getSize

    /** Removes all entries from this dictionary. */
    public void clear(){
        for(int i = 0; i<=numberOfEntries; i++){
            dictionary[i] = null;
        }
    }//end clear

    private void checkInitialization(){
        if(!initialized){
            throw new SecurityException("ArrayDictionary not properly initialized.");
        }
    }// end checkInitialization

    private void checkCapacity(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list" +
                    "whose capacity exceeds allowed maximum of "
                    + MAX_CAPACITY);
        }
    }

    private class Entry<S,T> {
        private S key;
        private ArrayList<T> valueList = new ArrayList<>();

        private Entry(S searchKey, T dataValue) {
            key = searchKey;
            valueList.add(dataValue);
        }

        private void setValue(T newValue){
            valueList.add(newValue);
        }

        private S getKey() {
            return key;
        }

        private ArrayList<T> getValueList(){
            return valueList;
        }
    }
}//end ArrayDictionary
