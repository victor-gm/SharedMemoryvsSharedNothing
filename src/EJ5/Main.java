package EJ5;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("******* EJERCICIO 5 *******");
        localTestSharedMemory(9999,10000,10);
    }

    public static void localTestSharedMemory (int aBuscar, int size, int numThreads)
    {
        try {
            SearchSharedMemory.cercaParallela(aBuscar, generateArray(size),numThreads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
}
