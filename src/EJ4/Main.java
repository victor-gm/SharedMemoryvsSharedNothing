package EJ4;
import EJ5.SearchSharedMemory;

public class Main
{
    private static int[] testArraySize  = {100, 1000, 10000, 100000, 1000000};
    private  static int[] testThreads   = {10, 100,  1000, 10000, 100000, 1000000};

    public static void main(String[] args)
    {
        System.out.println("******* EJERCICIO 4 *******");

        /*int arraySize = 100;
        int aBuscar = arraySize - 1;
        int numThreads = 10;

        System.out.println("----------------------------------  CACHING ---------------------------------- ");
        localTestSharedNothing(aBuscar,generateArray(arraySize),numThreads); //Ejecución para cargar la cache
        System.out.println("------------------------------------------------------------------------------ ");

        localTestSharedNothing(aBuscar,generateArray(arraySize),numThreads);*/

        //localTestSharedMemory(aBuscar,generateArray(arraySize),numThreads);

        for (int i = 0; i < 10; i++)
        {

        }

        automatedTest(testThreads,testArraySize);
    }



    public static int[] generateArray(int size)
    {
        int [] Array = new int [size];
        for (int i = 0; i < size; i++)
        {
            Array [i] = i;
        }

        return Array;
    }

    public static void localTestSharedNothing (int aBuscar, int [] Array, int numThreads)
    {
        try {
            SearchSharedNothing.cercaParallela(aBuscar, Array, numThreads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void localTestSharedMemory (int aBuscar, int [] Array, int numThreads)
    {
        try {
            SearchSharedMemory.cercaParallela(aBuscar, Array, numThreads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void automatedTest (int[] testThreads, int[] testArraySize)
    {
        System.out.println(" ******************************************************** AUTOMATED TEST  ********************************************************");
        for (int i = 0; i <  testArraySize.length; i++)
        {
            int aBuscar = testArraySize[i] - 1; // Buscamos el último número del array
            int [] Array = generateArray(testArraySize[i]);



            System.out.println(" ######################################## Array Size: " + testArraySize[i] + " ########################################");
            for (int i2 = 0; i2 <  testThreads.length; i2++)
            {
                if(testThreads[i2] <= testArraySize[i])
                {
                    System.out.println("-  CACHING - ");
                    localTestSharedNothing(aBuscar,Array,testThreads[i2]);
                    System.out.println("--------------");

                    System.out.println(" ***************** Number of Threads: " + testThreads[i2] + " *****************");

                    System.out.println("-------------- Shared Nothing -------------- ");
                    localTestSharedNothing(aBuscar,Array,testThreads[i2]);

                    System.out.println("-------------- Shared Memory --------------- ");
                    localTestSharedMemory(aBuscar,Array,testThreads[i2]);
                    System.out.println("-------------------------------------------- ");
                }

            }
        }
    }
}
