package EJ4;

import java.time.Duration;
import java.time.Instant;

public class SearchThread extends Thread
{
    private int [] Array;
    private int threadNum;
    private int casella = -1;
    private int start;
    private int aBuscar;
    private Instant startTime;

    public int getCasella()
    {
        return casella;
    }

    public SearchThread(int[] Array, int aBuscar, int threadNum, int start, Instant startTime)
    {
        this.Array = Array;
        this.threadNum = threadNum;
        this.start = start;
        this.aBuscar = aBuscar;
        this.startTime = startTime;
    }

    @Override
    public void run ()
    {
        for (int i = 0; i < Array.length; i++)
        {
            if(Array[i] == aBuscar)
            {
                System.out.println(" *** Thread number " + threadNum + " found " + aBuscar + " *** ");
                casella = i + start;

                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(startTime, end);
                System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
            }
        }
    }

}
