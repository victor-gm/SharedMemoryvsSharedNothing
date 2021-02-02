package EJ5;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SearchSharedMemory
{
    private int size;
    private int aBuscar;
    private int numThreads;

    public SearchSharedMemory(int aBuscar, int size, int numThreads)
    {
       this.size = size;
       this.aBuscar = aBuscar;
       this.numThreads = numThreads;
    }

    public static int cercaParallela (int aBuscar, int[] Array, int numThreads) throws InterruptedException
    {
        SearchSharedMemory searchSharedMemory = new SearchSharedMemory(aBuscar, Array.length, numThreads);

        int casella = -1;
        int chunkSize =  (int)Math.ceil((double)Array.length / numThreads);
        int numOfChunks = (int)Math.ceil((double)Array.length / chunkSize );

        // Thread Preparation
        ThreadData [] threadData = new ThreadData[numOfChunks];
        for(int i = 0; i < numOfChunks; ++i)
        {
            int start = i * chunkSize;
            int length = Math.min(Array.length - start, chunkSize); // En caso de que queden menos elementos que tamaño de de los trozos

            threadData[i] = new ThreadData(start,length);
        }

        //Thread launch
        SearchThread[] threads = new SearchThread[numOfChunks];

        Instant startTime = Instant.now();
        for(int i = 0; i < numOfChunks; i++)
        {
            int start = threadData[i].getStart();
            int lenght = threadData[i].getLenght();

            threads[i] = new SearchThread(Array,aBuscar,i + 1, start, lenght, startTime);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++)
        {
            threads[i].join();

            int casellaAux = threads[i].getCasella();
            if (casellaAux != -1)
            {
                casella = casellaAux;
            }
        }

        return casella;
    }



}
