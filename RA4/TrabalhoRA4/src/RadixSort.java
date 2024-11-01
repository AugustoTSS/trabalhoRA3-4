public class RadixSort {
    private static int iteracoes;
    private static int trocas;

    public static Resultado sort(int[] array, int tamanho) {
        trocas = 0;
        iteracoes = 0;
        long inicio = System.nanoTime();

        int max = getMax(array, tamanho);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, tamanho, exp);
        }

        long fim = System.nanoTime();
        double tempoExecucao = (fim - inicio) / 1_000_000.0;

        // Retorna os valores
        return new Resultado(tempoExecucao, trocas, iteracoes);
    }

    private static int getMax(int[] array, int tamanho) {
        int max = array[0];
        for (int i = 1; i < tamanho; i++) {
            iteracoes++;
            if (array[i] > max) {
                max = array[i];
                trocas++;
            }
        }
        return max;
    }

    private static void countSort(int[] array, int tamanho, int exp) {
        int[] output = new int[tamanho]; // Array para resultados
        int[] count = new int[10]; // Array de contagem para os dígitos 0-9

        // Contar a ocorrência de cada dígito
        for (int i = 0; i < tamanho; i++) {
            int index = (array[i] / exp) % 10;
            count[index]++;
            iteracoes++;
        }

        // Atualiza count[i] pra posições acumuladas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constroi o array de saida
        for (int i = tamanho - 1; i >= 0; i--) {
            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
            iteracoes++;
        }

        // Copia o array de saida pro array original
        for (int i = 0; i < tamanho; i++) {
            array[i] = output[i];
            trocas++;
        }
    }
}
