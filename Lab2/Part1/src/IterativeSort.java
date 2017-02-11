/**
 * Created by Andy on 2/9/17.
 */
import java.util.ArrayList;
import java.util.List;
public class IterativeSort {

    public int[] selectiveSort(int[] unsortedArray) {

        int temp = 0;
        int min =0;

        for (int index = 0; index < unsortedArray.length; index++) {

            min = unsortedArray[index];

            for (int j = index + 1 ; j < unsortedArray.length; j++) {

                if(min > unsortedArray[j]){
                    min = unsortedArray[j];
                    temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[index];
                    unsortedArray[index] = temp;
                }


            }



        }

        return unsortedArray;
    }

    public void insertionSortIterative(int[] unsortedArray, int first, int last){
        for(int index = first + 1 ; index < unsortedArray.length; index++){
            int nextToInsert = unsortedArray[index];
            insertInOrder(nextToInsert, unsortedArray, first , index-1);
        }
    }

    public void insertInOrder(int nextInsert , int [] array, int begin, int end){
        int index = end;

        while((index >= begin) && (nextInsert<array[index])){
            array[index+1] = array[index];
            index--;
        }

        array[index+1] = nextInsert;
    }

    public void shellSort(int [] array) {
        int i, j, k, h, hCount, increments[] = new int[10];
        // create an number of increments h
        for (h = 1, i = 0; h < array.length; i++) {
            increments[i] = h;
            h = 2 * i + 1;
        }
        // loop on the number of different increments h
        for (i--; i >= 0; i--) {
            h = increments[i];

            for (hCount = h; hCount < 2 * h; hCount++) {
                for (j = hCount; j < array.length; ) {
                    int tmp =  array[j];
                    k = j;
                    while (k - h >= 0 && tmp <array[k - h] ) {
                        array[k] = array[k - h];
                        k -= h;
                    }
                    array[k] = tmp;
                    j += h;
                }
            }
        }
    }

    public void radixSort(int[] input) {
        final int RAD = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RAD];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }


        boolean maxLength = false;
        int temp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : input) {
                temp = i / placement;
                bucket[temp % RAD].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RAD; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RAD;
        }
    }





}
