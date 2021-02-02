package EJ7;

public class MergeSortThread extends Thread {

    private int [] list;
    private int length;

    public MergeSortThread(int [] list, int length ){
        this.list = list;
        this.length = length;
    }

    @Override
    public void run(){
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortThread(list, length);
    }

}
