import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultado {
    private final double tempoExecucao;
    private final int numeroTrocas;
    private final int numeroIteracoes;
    private final Map<String, List<Resultado>> resultados = new HashMap<>();

    public Resultado(double tempoExecucao, int numeroTrocas, int numeroIteracoes) {
        this.tempoExecucao = tempoExecucao;
        this.numeroTrocas = numeroTrocas;
        this.numeroIteracoes = numeroIteracoes;
    }

    public double getTempoExecucao() {
        return tempoExecucao;
    }

    public int getNumeroTrocas() {
        return numeroTrocas;
    }

    public int getNumeroIteracoes() {
        return numeroIteracoes;
    }

    public void addResultado(String algoritmo, Resultado resultado, int tamanho) {
        resultados.putIfAbsent(algoritmo, new ArrayList<>());
        resultados.get(algoritmo).add(resultado);
        System.out.printf("%s: Tamanho %d -> Tempo: %.2f ms, Trocas: %d, Iterações: %d%n",
                algoritmo, tamanho, resultado.getTempoExecucao(), resultado.getNumeroTrocas(), resultado.getNumeroIteracoes());
    }

    public void exibirResultados() {
        for (String algoritmo : resultados.keySet()) {
            System.out.println("\nResultados para: " + algoritmo);
            for (Resultado resultado : resultados.get(algoritmo)) {
                System.out.printf("Tempo: %.2f ms, Trocas: %d, Iterações: %d%n",
                        resultado.getTempoExecucao(), resultado.getNumeroTrocas(), resultado.getNumeroIteracoes());
            }
        }
    }
}
