public class SelectionSort {
    public static Resultado sort(int[] array, int tamanho) {
        int trocas = 0;
        int iteracoes = 0;
        long inicio = System.nanoTime();

        for (int i = 0; i < tamanho - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tamanho; j++) {
                iteracoes++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                trocas++;
            }
        }

        long fim = System.nanoTime();
        double tempoExecucao = (fim - inicio) / 1_000_000.0;

        // Retorna o valores
        return new Resultado(tempoExecucao, trocas, iteracoes);
    }
}
