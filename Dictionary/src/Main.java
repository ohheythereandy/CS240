/**
 * Created by Andy on 3/13/17.
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

    public static void main(String[] args){
        DictionaryInterface<String, String> wordDict = new ArrayDictionary<String, String>();

        wordDict.add("Andy" , "Cool");
        System.out.println("The size of this dictionary is: " + wordDict.getSize());

        wordDict.add("Eddy", "Small");
        System.out.println("The size of this dictionary is: " + wordDict.getSize());

        wordDict.add("Andy", "Buff");
        ArrayList andyList = wordDict.getValue("Andy");

        System.out.println(Arrays.toString(andyList.toArray()));

        wordDict.remove("Andy");
        System.out.println("The size of this dictionary is: " + wordDict.getSize());
    }
}
