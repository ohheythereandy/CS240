/**
 * Created by Andy on 2/9/17.
 */
import java.util.Random;
public class Main {

    public static void main(String[] args) {

        IterativeSort sSort = new IterativeSort();
        RecursionSort rSort = new RecursionSort();
        Random rand = new Random();
        int[] array = new int[10];
        int[] temp = new int[10];


        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(1000);
            temp[i] = i;
        }

        for(int number : array){
            System.out.print(number + " ");
        }

        sSort.quickSort(array , 0 , array.length -1);

        System.out.println(" ");

        for(int number : array)
            System.out.print(number + " ");

    }
}
