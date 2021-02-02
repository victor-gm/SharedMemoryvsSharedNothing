package EJ7;

import java.time.Duration;
import java.time.Instant;

public class MergeSort {


    public void mergeSort(int [] list, int length ){

        if(length > 1){

            int middleIndex = length/2;

            //Aux sub Arrays
            int [] leftArr = new int[middleIndex];
            int [] rightArr = new int[length-middleIndex];

            //copy info into aux arrays
            for (int i = 0; i < middleIndex; i++){
                leftArr[i] = list[i];
            }
            for (int i = middleIndex; i < length; i++){
                rightArr[i-middleIndex] = list[i];
            }

            mergeSort(leftArr, middleIndex);
            mergeSort(rightArr, length-middleIndex);

            merge(list, leftArr, rightArr, middleIndex, length-middleIndex);
        }
    }

    public void mergeSortThread(int [] list, int length ){

        if(length > 1){

            int middleIndex = length/2;

            //Aux sub Arrays
            int [] leftArr = new int[middleIndex];
            int [] rightArr = new int[length-middleIndex];

            //copy info into aux arrays
            for (int i = 0; i < middleIndex; i++){
                leftArr[i] = list[i];
            }
            for (int i = middleIndex; i < length; i++){
                rightArr[i-middleIndex] = list[i];
            }

            MergeSortThread mergeSortThreadLeft = new MergeSortThread(leftArr,middleIndex);
            MergeSortThread mergeSortThreadRight = new MergeSortThread(rightArr,length-middleIndex);
            mergeSortThreadLeft.start();
            mergeSortThreadRight.start();
            try {
                mergeSortThreadLeft.join();
                mergeSortThreadRight.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(list, leftArr, rightArr, middleIndex, length-middleIndex);
        }
    }

    public void mergeSortThreadV2(int [] list, int length ){

        if(length > 1){

            int middleIndex = length/2;

            //Aux sub Arrays
            int [] leftArr = new int[middleIndex];
            int [] rightArr = new int[length-middleIndex];

            //copy info into aux arrays
            for (int i = 0; i < middleIndex; i++){
                leftArr[i] = list[i];
            }
            for (int i = middleIndex; i < length; i++){
                rightArr[i-middleIndex] = list[i];
            }

            if (length < 1000000){
                mergeSort(leftArr, middleIndex);
                mergeSort(rightArr, length-middleIndex);
            }else{

                MergeSortThreadV2 mergeSortThreadLeft = new MergeSortThreadV2(leftArr,middleIndex);
                MergeSortThreadV2 mergeSortThreadRight = new MergeSortThreadV2(rightArr,length-middleIndex);
                mergeSortThreadLeft.start();
                mergeSortThreadRight.start();
                try {
                    mergeSortThreadLeft.join();
                    mergeSortThreadRight.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            merge(list, leftArr, rightArr, middleIndex, length-middleIndex);
        }
    }

    private void merge(int[] list, int[] leftArr, int[] rightArr, int low, int high) {

        int i = 0;
        int j = 0;
        int k = 0;

        //Merge arrays
        while (i < low && j < high){

            if(leftArr[i] < rightArr[j]) {
                list[k] = leftArr[i];
                k++;
                i++;
            }else {
                list[k] = rightArr[j];
                k++;
                j++;
            }
        }

        //Copy any remaining numbers into the main array
        while (i < low){
            list[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < high){
            list[k] = rightArr[j];
            k++;
            j++;
        }
    }

    /**
     * It runs 10 consecutive tests with random arrays of the specified size
     * @param size size of the array
     * @param algorithm 0 = merge, 1= mergeThreads, 2=mergeV2(mixed merge)
     */
    public void runTests(int size, int algorithm){
        MergeSort mergeSort = new MergeSort();
        int [] list;

        for (int i = 0; i < 10; i++){
            list = ListGenerator.randomListGenerator(size);
            Instant start = Instant.now();
            switch (algorithm){
                case 0:
                    mergeSort.mergeSort(list, list.length);
                    break;
                case 1:
                    mergeSort.mergeSortThread(list, list.length);
                    break;
                case 2:
                    mergeSort.mergeSortThreadV2(list, list.length);
                    break;
                default:
                    break;
            }
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        }
    }
}
