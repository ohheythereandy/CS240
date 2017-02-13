/**
 * Created by Andy on 2/9/17.
 */
import java.util.ArrayList;
import java.util.List;
public class IterativeSort {


    public void selectiveSort(int[] unsortedArray) {

        int temp = 0;
        int min = 0;
        int countMove =0;
        int countCompare = 0;

        for (int index = 0; index < unsortedArray.length; index++) {

            min = unsortedArray[index];

            for (int j = index + 1; j < unsortedArray.length; j++) {
                countCompare++;
                if (min > unsortedArray[j]) {
                    min = unsortedArray[j];
                    temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[index];
                    unsortedArray[index] = temp;
                    countMove++;
                }


            }


        }
       // System.out.println("Count move : " + countMove
        //                    + " Count Compare: " + countCompare);
    }

    public void insertionSort(int[] unsortedArray, int first, int last) {

        int countMove=0;
        int countCompare=0;
        for (int index = first + 1; index < unsortedArray.length; index++) {
            int nextToInsert = unsortedArray[index];
            insertInOrder(nextToInsert, unsortedArray, first, index - 1, countCompare, countMove);

        }
//        System.out.println("Count move : " + countMove
//                + " Count Compare: " + countCompare);

    }

    public void insertInOrder(int nextInsert, int[] array, int begin, int end, int compare, int move) {
        int index = end;


        compare++;
        while ((index >= begin) && (nextInsert < array[index])) {
            array[index + 1] = array[index];
            index--;
            move++;

        }

        array[index + 1] = nextInsert;

    }

    public void shellSort(int[] a) {
        int length = a.length;
        int countMove =0;
        int countCompare= 0;

        for (int gap = length / 2; gap > 0; gap /= 2) {

                for (int i = gap; i < length; i += 1) {

                int temp = a[i];


                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap){
                    a[j] = a[j - gap];
                    countCompare++;
                }


                a[j] = temp;
                countMove++;
            }
        }
        //System.out.println("Count move : " + countMove
        //                   + " Count Compare: " + countCompare);

    }

    public void radixSort(int[] input) {
        final int RADIX = 10;
        int countMove = 0;
        int countCompare =0;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        boolean maxLength = false;
        int tmp = 0;
        int placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                countMove++;

                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    countMove++;
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
//         System.out.println("Count move : " + countMove
 //                           + " Count Compare: " + countCompare);

    }//end radix sort

    public void mergeSort(int[] a, int[] temp, int length) {

        for (int currentSize = 1; currentSize <= length ; currentSize = 2 * currentSize) {

            for (int start = 0; start < length; start += 2 * currentSize) {

                int left = start;
                int mid = left + currentSize ;
                int end = left + 2 * currentSize ;

                merge(a, temp, left, mid, end);
            }
        }
    } // end mergeSort

    private void merge(int[] a, int[] tmp, int left, int middle, int right) {
        int i, j, k;

        i = left;
        j = middle;
        k = left;

        while (i < middle || j < right)
        {
            if (i < middle && j < right) {  // Both array have elements
                if (a[i] < a[j])
                    tmp[k++] = a[i++];
                else
                    tmp[k++] = a[j++];
            }
            else if (i == middle)
                tmp[k++] = a[j++];      // a is empty
            else if (j == right)
                tmp[k++] = a[i++];      // b is empty
        }
        for (i = left; i < right; i++)
            a[i] = tmp[i];
    } //end merge

    public void quickSort(int a[], int low, int high)
    {
        int countMove =0;
        int countCompare =0;

        int temp[] = new int[high-low+1];

        // initialize top
        int top = -1;

        // push initial values
        temp[++top] = low;
        temp[++top] = high;


        while (top >= 0)
        {
            countCompare++;
            high = temp[top--];
            low = temp[top--];

            // set pivot element at it's proper position
            int p = partition(a, low, high , countMove, countCompare);

            // If there are elements on left side of pivot,
            countCompare++;
            if ( p-1 > low )
            {
                temp[ ++top ] = low;
                temp[ ++top ] = p - 1;
                countMove++;
            }

            // If there are elements on right side of pivot,
            countCompare++;
            if ( p+1 < high )
            {
                temp[ ++top ] = p + 1;
                temp[ ++top ] = high;
                countMove++;
            }
        }
        //System.out.println("Count move : " + countMove
        //       + " Count Compare: " + countCompare);
    } //end quickSort


    private int partition (int arr[], int low, int high, int move, int compare)
    {
        int x = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high- 1; j++)
        {
            compare++;
            if (arr[j] <= x)
            {
                i++;
                // swap arr[i] and arr[j]
                swap(arr,i,j);
                move++;
            }
        }
        // swap arr[i+1] and arr[h]
        swap(arr,i+1,high);
        move++;
        return (i + 1);
    } //end partition

    private void swap(int[] array, int index , int lowest){
        int temp = array[lowest];
        array[lowest] = array[index];
        array[index]= temp;
    }//end swap

}