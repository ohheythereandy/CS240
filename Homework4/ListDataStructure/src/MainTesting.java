/**
 * Created by Andy on 3/5/17.
 */
public class MainTesting {

    public static void main(String[] args){
        // create list for class
        ListInterface<String> classList = new ArrayList<>();

        //add students

        classList.add("Ratchet");
        classList.add("Quark");
        classList.add("Rudolph");
        classList.add("Clank");

        //print out list
        for(int i = 1 ; i <= classList.checkSize(); i++){
            System.out.println(classList.getEntry(i));
        }


    }
}
