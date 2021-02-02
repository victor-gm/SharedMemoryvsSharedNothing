package EJ7;


import java.time.Duration;
import java.time.Instant;

public class Ex7 {
    public static void main(String[] args){
        System.out.println("******* EJERCICIO 7 *******");

        int [] list = ListGenerator.randomListGenerator(10000000);
        MergeSort mergeSort = new MergeSort();

        Instant start = Instant.now();
        //mergeSort.mergeSort(list, list.length);
        //mergeSort.mergeSortThread(list, list.length);
        //mergeSort.mergeSortThreadV2(list, list.length);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

    }

}
