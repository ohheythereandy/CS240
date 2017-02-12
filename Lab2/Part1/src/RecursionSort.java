/**
 * Created by Andy on 2/9/17.
 */
import java.util.Random;

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

    private void merge(int[] array, int[]temp, int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            temp[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (temp[i] <= array[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }

    }

    public void quickSort(int[] data){
        quickSort(data,0, data.length -1);
    }

    public void quickSort(int[] data, int left, int right){
        int pivotValue = data[ (left +right) /2 ];
        int i = left;
        int j = right;

        while(i<= j){
            //Find leftmost value greater than or equal to pivot
            while(data[i] < pivotValue) i++;

            while(data[j] > pivotValue)j--;

            if(i <=j ) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if(left < j)
            quickSort(data, left, j);
        if(i <right)
            quickSort(data ,i ,right);
    }

    public void incrementalInsertionSort(int[] a, int first, int last, int space) {
        for(int unsorted = first + space ; unsorted <= last ; unsorted+=space  ){
            int nextToInsert = a[unsorted]; //element at top
            int index = unsorted - space; //element at beginning

            //while element at beginning is greater than element at end
            while((index >= first) && (nextToInsert < a[index])) {
                a[index+space] = a[index];
                index = index -space;
            }
            a[index +space] = nextToInsert;
        }
    }

    public void shellSort(int[] array, int first, int last){
        int space = array.length -1 ;

        while(space > 0){
            for (int begin = first ; begin < first + space  ; begin++){
                incrementalInsertionSort(array, begin, last, space);
            }
            space = space /2;
        }
    }

    private void swap(int[] array, int index , int lowest){
        int temp = array[lowest];
        array[lowest] = array[index];
        array[index]= temp;
    }




}
