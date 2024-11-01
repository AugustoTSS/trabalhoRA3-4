public class HeapSort {
    private static int trocas;
    private static int iteracoes;

    public static Resultado sort(int[] array, int tamanho) {
        trocas = 0;
        iteracoes = 0;
        long inicio = System.nanoTime();

        // Constroi o heap
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(array, tamanho, i);
        }

        // Extrai elementos
        for (int i = tamanho - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            trocas++;
            heapify(array, i, 0);
        }

        long fim = System.nanoTime();
        double tempoExecucao = (fim - inicio) / 1_000_000.0;

        // Retornar os valores, tempo, troca, interações
        return new Resultado(tempoExecucao, trocas, iteracoes);
    }

    private static void heapify(int[] array, int tamanho, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tamanho && array[esquerda] > array[maior]) {
            maior = esquerda;
        }

        if (direita < tamanho && array[direita] > array[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int swap = array[i];
            array[i] = array[maior];
            array[maior] = swap;
            trocas++;
            heapify(array, tamanho, maior);
        }
        iteracoes++;
    }
}
