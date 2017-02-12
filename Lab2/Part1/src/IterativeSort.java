/**
 * Created by Andy on 2/9/17.
 */
import java.util.ArrayList;
import java.util.List;
public class IterativeSort {

    public int[] selectiveSort(int[] unsortedArray) {

        int temp = 0;
        int min = 0;

        for (int index = 0; index < unsortedArray.length; index++) {

            min = unsortedArray[index];

            for (int j = index + 1; j < unsortedArray.length; j++) {

                if (min > unsortedArray[j]) {
                    min = unsortedArray[j];
                    temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[index];
                    unsortedArray[index] = temp;
                }


            }


        }

        return unsortedArray;
    }

    public void insertionSortIterative(int[] unsortedArray, int first, int last) {
        for (int index = first + 1; index < unsortedArray.length; index++) {
            int nextToInsert = unsortedArray[index];
            insertInOrder(nextToInsert, unsortedArray, first, index - 1);
        }
    }

    public void insertInOrder(int nextInsert, int[] array, int begin, int end) {
        int index = end;

        while ((index >= begin) && (nextInsert < array[index])) {
            array[index + 1] = array[index];
            index--;
        }

        array[index + 1] = nextInsert;
    }

    public void shellSort(int[] a) {
        int n = a.length;


        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i += 1) {

                int temp = a[i];


                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
                    a[j] = a[j - gap];

                a[j] = temp;
            }
        }

    }

    public void radixSort(int[] input) {
        final int RADIX = 10;
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
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }//end radix sort

    public void mergeSort(int[] a, int[] temp, int length) {

        for (int currentSize = 1; currentSize < length ; currentSize = 2 * currentSize) {

            for (int start = 0; start < length; start += 2 * currentSize) {
                int left = start;
                int mid = start + currentSize;
                int end = start + 2 * currentSize;

                merge(a, temp, start, mid, end);
            }
        }
    } // end mergeSort

    private void merge(int[] a, int[] tmp, int iLeft, int iMiddle, int iRight) {
        int i, j, k;

        i = iLeft;     // Re-adjust the indices
        j = iMiddle;
        k = iLeft;

        while (i < iMiddle || j < iRight)    // It's the same algorithm !
        {
            if (i < iMiddle && j < iRight) {  // Both array have elements
                if (a[i] < a[j])
                    tmp[k++] = a[i++];
                else
                    tmp[k++] = a[j++];
            }
            else if (i == iMiddle)
                tmp[k++] = a[j++];      // a is empty
            else if (j == iRight)
                tmp[k++] = a[i++];      // b is empty
        }

      /* =================================
         Copy tmp[] back to a[]
         ================================= */
        for (i = iLeft; i < iRight; i++)
            a[i] = tmp[i];
    }

}