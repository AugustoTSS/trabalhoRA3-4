import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] tamanhosTabela = {100000, 1000000, 5000000};
        int[] tamanhosDados = {10000, 100000, 500000};
        int[] tiposHash = {1, 2, 3};  // 1 = mod, 2 = multiplicação, 3 = dobramento

        // Gerador de números aleatórios com uma semente fixa
        Random aleatorio = new Random(12);

        // Iteração sobre diferentes tamanhos de dados
        for (int tamanhoDados : tamanhosDados) {
            Registro[] registros = new Registro[tamanhoDados];
            // Geração dos registros com números aleatórios
            for (int i = 0; i < tamanhoDados; i++) {
                registros[i] = new Registro(aleatorio.nextInt(Integer.MAX_VALUE));
            }

            // Iteração sobre diferentes tamanhos de tabela
            for (int tamanhoTabela : tamanhosTabela) {
                // Criação das tabelas com o tamanho especificado
                TabelaHashRehashing tabelaRehashing = new TabelaHashRehashing(tamanhoTabela);
                TabelaHashEncadeamento tabelaEncadeamento = new TabelaHashEncadeamento(tamanhoTabela);

                // Variáveis para armazenar o tempo total e as colisões para cada função hash
                long[] temposRehashing = new long[3];  // 0 = divisão, 1 = multiplicação, 2 = dobramento
                long[] temposEncadeamento = new long[3];
                int[] colisaoRehashing = new int[3];
                int[] colisaoEncadeamento = new int[3];

                // Iteração sobre os diferentes tipos de funções hash
                for (int tipoHash : tiposHash) {
                    // Medindo o tempo de inserção para Rehashing
                    long tempoInicial = System.nanoTime();
                    for (Registro registro : registros) {
                        tabelaRehashing.inserir(registro, tipoHash);
                    }
                    long tempoFinal = System.nanoTime();
                    temposRehashing[tipoHash - 1] = tempoFinal - tempoInicial;
                    colisaoRehashing[tipoHash - 1] = tabelaRehashing.contagemColisoes;

                    // Medindo o tempo de inserção para Encadeamento
                    tempoInicial = System.nanoTime();
                    for (Registro registro : registros) {
                        tabelaEncadeamento.inserir(registro, tipoHash);
                    }
                    tempoFinal = System.nanoTime();
                    temposEncadeamento[tipoHash - 1] = tempoFinal - tempoInicial;
                    colisaoEncadeamento[tipoHash - 1] = tabelaEncadeamento.contagemColisoes;
                }

                // Exibindo os resultados em uma única linha
                System.out.println("Tamanho: " + tamanhoTabela +
                        " - Tempo de Insercao divisao Rehashing: " + temposRehashing[0] / 1_000_000.0 + " ms, " +
                        "Tempo de Insercao multiplicacao Rehashing: " + temposRehashing[1] / 1_000_000.0 + " ms, " +
                        "Tempo de Insercao dobramento Rehashing: " + temposRehashing[2] / 1_000_000.0 + " ms, " +
                        "Colisoes divisao Rehashing: " + colisaoRehashing[0] + ", " +
                        "Colisoes multiplicacao Rehashing: " + colisaoRehashing[1] + ", " +
                        "Colisoes dobramento Rehashing: " + colisaoRehashing[2] + ", " +

                        "Tempo de Insercao divisao Encadeamento: " + temposEncadeamento[0] / 1_000_000.0 + " ms, " +
                        "Tempo de Insercao multiplicacao Encadeamento: " + temposEncadeamento[1] / 1_000_000.0 + " ms, " +
                        "Tempo de Insercao dobramento Encadeamento: " + temposEncadeamento[2] / 1_000_000.0 + " ms, " +
                        "Colisoes divisao Encadeamento: " + colisaoEncadeamento[0] + ", " +
                        "Colisoes multiplicacao Encadeamento: " + colisaoEncadeamento[1] + ", " +
                        "Colisoes dobramento Encadeamento: " + colisaoEncadeamento[2]);
            }
        }
    }
}