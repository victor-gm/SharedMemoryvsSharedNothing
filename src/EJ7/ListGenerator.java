package EJ7;

import java.util.Random;

public class ListGenerator {

    public static int[] randomListGenerator(int size){
        int list[] = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++){
            list[i] = rand.nextInt(size + 1);
        }
        return list;
    }

}
