/**
 * Created by Andy on 2/9/17.
 */
import java.util.Random;
import java.util.jar.Pack200;

public class RecursionSort extends IterativeSort{


    public void selectionSort(int[] unsortedArray ,int first, int last){
        int minimum = first;

        if(first < last){
            for(int unsortedIndex = first + 1 ; unsortedIndex< unsortedArray.length; unsortedIndex++){
                if(unsortedArray[unsortedIndex] < unsortedArray[minimum])
                    minimum = unsortedIndex;
            }

            swap(unsortedArray, first, minimum );
            selectionSort(unsortedArray, first+1, last);
        }


    }

    public void insertionSort(int[]array , int first, int last){
        if(first < last){
            insertionSortIterative(array , first, last-1);
            insertInOrder(array[last], array, first, last -1);
        }
    }

    public void insertInOrder(int nextInsert , int[] a, int begin, int end){
        if(nextInsert >= a[end])
            a[end+1]= nextInsert;
        else if(begin < end){
            a[end+1] = a[end];
            insertInOrder(nextInsert ,a, begin, end-1);
        }
        else {
            a[end+1] = a[end];
            a[end] = nextInsert;
        }
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }


    public void mergeSort(int[] array , int[] temp, int first, int last){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSort(array , temp , first, mid);

            mergeSort(array , temp, mid+1 , last);

            merge(array , temp, first , mid , last);
        }
    }

    private void merge(int[] array, int[] temp, int first, int mid, int last) {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid+1;
        int endHalf2 = last;
        int index = 0;

        while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)){
            if(array[beginHalf1] <= array[beginHalf2])
                temp[index] = array[beginHalf1++];
            else{
                temp[index] = array[beginHalf2++];
            }

            index++;
        }

        while(beginHalf1 <= endHalf1){
            temp[index++] = array[beginHalf1++];
        }
        while(beginHalf2 <= endHalf2) {
            temp[index++] = array[beginHalf2++];
        }

        for(int i=0; i < index; i++)
            array[i] = temp[i];
    }

    private int partition(int[] a, int start, int end){
        Random ran = new Random();
        int index = start+ran.nextInt(end - start + 1); //set random index pivot value
        int pivot = a[index];//sets the random pivot value
        swap(a,index, end); // puts random pivot value at the end of array
        index = start; // set partition index to the beginning of the array
        for (int i= start; i < end; i++) {
            if (a[i]<pivot) {
                swap(a,index, i);
                index++;
            }
        }
        swap(a,index, end);
        return index;
    }


    public void quickSort(int[] a, int start, int end){
        if(end > start){
            int index = partition(a,start,end);
            quickSort(a, start, index - 1);
            quickSort(a, index + 1, end);
        }
    }

    private void swap(int[] array, int index , int lowest){
        int temp = array[lowest];
        array[lowest] = array[index];
        array[index]= temp;
    }



}
