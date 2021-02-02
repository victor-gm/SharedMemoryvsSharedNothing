package EJ3;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Search {

    private int size;
    private int num;

    LinkedList<Integer> l;

    public Search(int size, int num)
    {
        this.size = size;
        this.num = num;

        generateLinkedList();
        startThreads();
    }

    private void generateLinkedList()
    {
        l = new LinkedList<Integer>();

        for(int i = 0; i < size; i++)
        {
            l.add(i);
        }
    }

    private void startThreads ()
    {
        SearchThread st = new SearchThread(l,num,"normal");
        SearchThread st2 = new SearchThread(l,num,"reverse");

        st.start();
        st2.start();
    }

}
