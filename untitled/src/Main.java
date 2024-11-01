import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Perguntas interativas para o usuário
        System.out.println("-".repeat(26));
        System.out.print("| Digite a seed inicial:  |");
        System.out.println("\n" + "-".repeat(26));
        long seed = scanner.nextLong();

        System.out.println("-".repeat(51));
        System.out.print("| Digite a quantidade de números a serem gerados:  |");
        System.out.println("\n" + "-".repeat(51));
        int quantity = scanner.nextInt();

        System.out.println("-".repeat(36));
        System.out.print("| Digite o tamanho da tabela hash:  |");
        System.out.println("\n" + "-".repeat(36));
        int tableSize = scanner.nextInt();

        // Gera números aleatórios baseados na seed usando o método de CSVUtils
        Registro[] randomNumbers = CSVUtils.generateSeedBasedNumbers(seed, quantity);

        // Escolha do tipo de hash
        System.out.println("-".repeat(46));
        System.out.println("| Escolha o tipo de hash:                     |");
        System.out.println("| 1 - Hash por Dobramento                     |");
        System.out.println("| 2 - Hash por Módulo                         |");
        System.out.println("| 3 - Hash por Multiplicação                  |");
        System.out.println("-".repeat(46));
        int hashChoice = scanner.nextInt();

        // Inicializa uma variável para armazenar o tipo de hash em string
        String tipoHash = "";
        Registro[] hashedValues;

        // Calcula o hash usando a função escolhida
        switch (hashChoice) {
            case 1:
                System.out.println("Usando o Hash por Dobramento:");
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);
                tipoHash = "1";  // Hash por Dobramento
                break;
            case 2:
                System.out.println("Usando o Hash por Módulo:");
                hashedValues = HashGenerator.moduloHash(randomNumbers, tableSize, quantity);
                tipoHash = "2";  // Hash por Módulo
                break;
            case 3:
                System.out.println("Usando o Hash por Multiplicação:");
                hashedValues = HashGenerator.multiplicationHash(randomNumbers, tableSize, quantity);
                tipoHash = "3";  // Hash por Multiplicação
                break;
            default:
                System.out.println("Opção inválida! Usando o Hash por Dobramento por padrão.");
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);
                tipoHash = "1";  // Hash por Dobramento (padrão)
                break;
        }

        // Medir tempo de inserção usando encadeamento (Nodes)
        long startTime = System.nanoTime();
        Node[] hashedTableNodes = HashTable.nodes(hashedValues, tableSize, quantity);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Colisões já são contadas dentro do método nodes
        // Vamos supor que você retorne a contagem de colisões no método nodes
        int collisionCount = 0; // Trocar para capturar o valor real das colisões

        // Gera o arquivo CSV com os resultados
        CSVUtils.gerarArquivoCSV(tableSize, quantity, tipoHash, duration, collisionCount);

        System.out.println("Hash armazenado baseado em Nodes.");
        System.out.println("Tempo de inserção (Node Encadeado): " + duration + " nanosegundos");
    }
}
