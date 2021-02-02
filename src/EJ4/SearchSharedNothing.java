package EJ4;

import java.time.Instant;

public class SearchSharedNothing
{
    private int aBuscar;
    private int size;
    private int numThreads;

    public SearchSharedNothing(int aBuscar, int size, int numThreads)
    {
        this.aBuscar = aBuscar;
        this.size = size;
        this.numThreads = numThreads;
    }


    public static int cercaParallela (int aBuscar, int[] Array, int numThreads) throws InterruptedException
    {
        SearchSharedNothing search = new SearchSharedNothing(aBuscar, Array.length, numThreads);

        int casella = -1;

        int chunkSize =  (int)Math.ceil((double)Array.length / numThreads);
        int numOfChunks = (int)Math.ceil((double)Array.length / chunkSize );

        ThreadData[] threadData = new ThreadData[numOfChunks];
        for(int i = 0; i < numOfChunks; ++i)
        {
            int start = i * chunkSize; // 1. Determinar la posición de inicio del trozo de array
            int length = Math.min(Array.length - start, chunkSize); // 2. Determinar la largada del trozo, en caso de ser el final, más pequeño

            int[] temp = new int[length]; // 3. Crear el trozo de array y copiar el fragmento del array original
            System.arraycopy(Array, start, temp, 0, length);

            threadData[i] = new ThreadData(start,temp); // 4. Llenar la información de cada thread
        }

        //Thread launch
        SearchThread[] threads = new SearchThread [numOfChunks]; // Creación array de threads

        Instant startTime = Instant.now(); // Tomamos el tiempo justo en el momento de iniciar el primer thread
        for(int i = 0; i < numOfChunks; i++)
        {
            int [] arrayToSearch = threadData[i].getTemp();
            int start = threadData[i].getStart();

            threads[i] = new SearchThread(arrayToSearch, aBuscar,i + 1, start, startTime);
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







