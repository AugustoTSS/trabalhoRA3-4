import java.io.FileWriter;
import java.io.IOException;

public class CSVUtils {

    public static void gerarArquivoCSV(int tableSize, int quantity, String tipoHash, long duration, int collisionCount) {
        String fileName = "hash_results.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Cabeçalhos do arquivo CSV
            writer.append("Tamanho da Tabela");
            writer.append(",");
            writer.append("Quantidade de Números");
            writer.append(",");
            writer.append("Tipo de Hash");
            writer.append(",");
            writer.append("Tempo de Inserção (nanosegundos)");
            writer.append(",");
            writer.append("Número de Colisões");
            writer.append("\n");

            // Dados
            writer.append(String.valueOf(tableSize));
            writer.append(",");
            writer.append(String.valueOf(quantity));
            writer.append(",");
            writer.append(tipoHash);
            writer.append(",");
            writer.append(String.valueOf(duration));
            writer.append(",");
            writer.append(String.valueOf(collisionCount));
            writer.append("\n");

            System.out.println("Arquivo CSV gerado com sucesso: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo CSV: " + e.getMessage());
        }
    }

    // Exemplo de método de geração de números baseado em seed
    public static Registro[] generateSeedBasedNumbers(long seed, int quantity) {
        Registro[] registros = new Registro[quantity];
        for (int i = 0; i < quantity; i++) {
            int codigo = (int) (seed + i * 17) % 10000; // Exemplo simples de geração
            int hash = codigo % 1000;  // Apenas um exemplo de cálculo de hash
            registros[i] = new Registro(codigo, hash);
        }
        return registros;
    }
}
