package EJ7;

public class MergeSortThreadV2 extends Thread {

    private int [] list;
    private int length;

    public MergeSortThreadV2(int [] list, int length ){
        this.list = list;
        this.length = length;
    }

    @Override
    public void run(){
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortThreadV2(list, length);
    }

}
