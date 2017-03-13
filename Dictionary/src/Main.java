/**
 * Created by Andy on 3/13/17.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {

    public static void main(String[] args){
        DictionaryInterface<String, String> wordDict = new ArrayDictionary<String, String>();

        wordDict.add("Andy" , "Cool");
        System.out.println("The size of this dictionary is: " + wordDict.getSize());

        wordDict.add("Eddy", "Small");
        System.out.println("The size of this dictionary is: " + wordDict.getSize());

        wordDict.add("Andy", "Buff");
        ArrayList andyList = wordDict.getValue("Andy");

        wordDict.add("Forrest", "Phat");

        System.out.println(Arrays.toString(andyList.toArray()));

        Iterator<String> keyIterator = wordDict.getKeyIterator();

        keyIterator.next();
        keyIterator.remove();

        Iterator<String> secondKeyIterator = wordDict.getKeyIterator();

        while(secondKeyIterator.hasNext()){
            System.out.println(secondKeyIterator.next());
        }


        //Iterator <ArrayList<String>> valueIterator = wordDict.getValueIterator();



    }
}
