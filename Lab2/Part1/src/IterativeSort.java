/**
 * Created by Andy on 2/9/17.
 */

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

    public void radixSort(int[] a, int length , int maxDigits){

        for(int exp = 1 ; maxDigits / exp > 0 ; exp*= 10){
            countSort(a,length,exp);
        }
    }

    public void countSort(int a[], int length, int exp){
        int output[] = new int[length]; // output array
        int count[] = new int[10];

        for(int number : count)
            count[number] = 0;

        // Store count of occurrences in count[]
        for (int i = 0; i < length; i++)
            count[ (a[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];


        for (int i = length - 1; i >= 0; i--)
        {
            output[count[ (a[i]/exp)%10 ] - 1] = a[i];
            count[ (a[i]/exp)%10 ]--;
        }


        for (int i = 0; i < length; i++)
            a[i] = output[i];
    }

}
