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
            array[i] = rand.nextInt(100);
            temp[i] = i;
        }

        for(int number : array){
            System.out.print(number + " ");
        }

        //rSort.selectionSort(array , 0 , array.length-1);
        //sSort.insertionSortIterative(array, 0 , array.length-1);
        //rSort.insertionSort(array, 0 , array.length-1);
        //rSort.mergeSort(array, temp , 0 , array.length -1);
        //sSort.shellSort(array);
        //sSort.radixSort(array);
        //rSort.quickSort(array, 0 , array.length-1);

        System.out.println(" ");

        for(int number : array)
            System.out.print(number + " ");


    }
}
