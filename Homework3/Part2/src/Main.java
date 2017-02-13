/**
 * Created by Andy on 2/13/17.
 */
public class Main {

    public static void main (String[] args){
        System.out.println("Create an empty list.");
        ListInterface<String> myList = new LinkedList<>();

        System.out.println("List should be empty; isEmpty returns "
                            + myList.isEmpty() + ".");
        System.out.println("\nTesting add to end: ");
        myList.add("15");
        myList.add("40");
        myList.add("532");
        myList.add("23");

        System.out.println("Beginning of List: " + myList.getEntry(1));

    }
}
