import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] sizes = {1000, 10000, 100000, 500000, 1000000};
        int seed = 12;
        int vezes = 5;

        Gerador gerador = new Gerador(seed);
        Resultado coletor = new Resultado(0, 0, 0);

        // CSV
        FileWriter csvWriter = new FileWriter("resultados.csv");
        csvWriter.append("Algoritmo,Tamanho,TempoExecucao,NumeroTrocas,NumeroIteracoes\n");

        for (int size : sizes) {
            System.out.println("\n--- Tamanho: " + size + " ---");

            for (int i = 0; i < vezes; i++) {
                int[] array = gerador.geraArray(size);

                // Selection Sort
                int[] arraySelection = array.clone();
                Resultado resultadoSelection = SelectionSort.sort(arraySelection, size);
                coletor.addResultado("Selection Sort", resultadoSelection, size);
                csvWriter.append("Selection Sort," + size + "," + resultadoSelection.getTempoExecucao() + ","
                        + resultadoSelection.getNumeroTrocas() + "," + resultadoSelection.getNumeroIteracoes() + "\n");

                // Quick Sort
                int[] arrayQuick = array.clone();
                Resultado resultadoQuick = QuickSort.sort(arrayQuick, 0, size - 1);
                coletor.addResultado("Quick Sort", resultadoQuick, size);
                csvWriter.append("Quick Sort," + size + "," + resultadoQuick.getTempoExecucao() + ","
                        + resultadoQuick.getNumeroTrocas() + "," + resultadoQuick.getNumeroIteracoes() + "\n");

                // Heap Sort
                int[] arrayHeap = array.clone();
                Resultado resultadoHeap = HeapSort.sort(arrayHeap, size);
                coletor.addResultado("Heap Sort", resultadoHeap, size);
                csvWriter.append("Heap Sort," + size + "," + resultadoHeap.getTempoExecucao() + ","
                        + resultadoHeap.getNumeroTrocas() + "," + resultadoHeap.getNumeroIteracoes() + "\n");

                // Radix Sort
                int[] arrayRadix = array.clone();
                Resultado resultadoRadix = RadixSort.sort(arrayRadix, size);
                coletor.addResultado("Radix Sort", resultadoRadix, size);
                csvWriter.append("Radix Sort," + size + "," + resultadoRadix.getTempoExecucao() + ","
                        + resultadoRadix.getNumeroTrocas() + "," + resultadoRadix.getNumeroIteracoes() + "\n");
            }
        }

        coletor.exibirResultados();
        System.out.println("Resultados salvos em resultados.csv");

        // Fechando o FileWriter
        csvWriter.close();
    }
}
