import java.util.Random;

public class Gerador{
    private final Random random;

    public Gerador(int seed) {
        random = new Random(seed);
    }

    public int[] geraArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}