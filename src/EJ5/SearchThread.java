package EJ5;

import java.time.Duration;
import java.time.Instant;

public class SearchThread extends Thread
{
    private int num; // Nunber to find
    private int [] Array;

    private int threadNum;

    private int casella = -1;

    private int start;
    private int lenght;

    private Instant startTime;

    public int getCasella()
    {
        return casella;
    }

    public SearchThread(int[] Array, int aBuscar, int threadNum, int start, int lenght, Instant startTime)
    {
        this.num = aBuscar;
        this.Array = Array;
        this.threadNum = threadNum;
        this.start = start;
        this.lenght = lenght;
        this.startTime = startTime;
    }

    @Override
    public void run ()
    {
        int finish = start + lenght;
        for (int i = this.start; i < finish; i++)
        {
            if(Array[i] == this.num)
            {
                System.out.println(" *** Thread number " + this.threadNum + " found " + this.num + " *** ");
                casella = i;

                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(startTime, end);
                System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
            }
        }
    }

}
