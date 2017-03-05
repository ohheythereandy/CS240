/**
 * Created by Andy on 2/15/17.
 */

public class SortingAlgorithms {

    /**
     * @param array
     */
    public void iterativeSelective(int[] array) {

        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length - 1; j++) {

                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }


            }
        }
    }

    /**
     * @param array
     * @param start
     * @param compare
     */
    public void recursiveSelective(int[] array, int start, int compare) {
        //base case = reach end of array

        if (start == array.length - 1)
            return;
        // swap
        if (array[start] > array[compare]) {
            int smallNum = array[start];
            array[start] = array[compare];
            array[compare] = smallNum;

        }
        compare++;

        if (compare == array.length - 1) {
            start++;
            compare = start + 1;
        }

        recursiveSelective(array, start, compare);

    }

    public void iterativeInsertion(int[] array) {
        //two pointers , partition array and insert unsorted element into correct
        //position

        //compare index
        for (int i = 1; i < array.length; i++) {

            int unsortedElem = array[i];
            int j = i - 1; // sorted element

            while ((j >= 0) && (unsortedElem < array[j])) {
                array[j + 1] = array[j];
                j--;
            }

            array[j+1] = unsortedElem;
        }

    }

}
