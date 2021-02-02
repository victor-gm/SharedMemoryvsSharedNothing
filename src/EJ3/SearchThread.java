package EJ3;

import java.util.LinkedList;

public class SearchThread extends Thread
{
    LinkedList <Integer> l;
    String mode; // Modality of search
    int num; // Nunber to find


    public SearchThread(LinkedList<Integer> l, int num, String mode)
    {
        this.l = l;
        this.mode = mode;
        this.num = num;
    }

    @Override
   public void run ()
    {
        if (mode == "normal")
        {
            for (int i = 0; i < l.size() ; i++) {
                if (l.get(i) == num) {
                    System.out.println("Thread searching in " + mode + " mode found the number " + num + " in index " + i);
                    return;
                }
            }

        } else {
            for (int i = l.size() - 1; i > 0 ; i--) {
                if (l.get(i) == num) {
                    System.out.println("Thread searching in " + mode + " mode found the number " + num + " in index " + i);
                    return;
                }
            }
        }
    }
}
