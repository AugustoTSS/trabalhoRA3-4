public class QuickSort {
    private static int trocas;
    private static int iteracoes;

    public static Resultado sort(int[] array, int baixo, int alto) {
        trocas = 0;
        iteracoes = 0;
        long inicio = System.nanoTime();

        quickSort(array, baixo, alto);

        long fim = System.nanoTime();
        double tempoExecucao = (fim - inicio) / 1_000_000.0;

        // Retorna os valores, tempo, troca, interação
        return new Resultado(tempoExecucao, trocas, iteracoes);
    }

    private static void quickSort(int[] array, int baixo, int alto) {
        if (baixo < alto) {
            int pIndex = partition(array, baixo, alto);
            quickSort(array, baixo, pIndex - 1);
            quickSort(array, pIndex + 1, alto);
        }
    }

    private static int partition(int[] array, int baixo, int alto) {
        int pivot = array[alto];
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            iteracoes++;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                trocas++;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;
        trocas++;

        return i + 1;
    }
}
