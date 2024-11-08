import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Criação do scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário a seed inicial para gerar números aleatórios
        System.out.println("-".repeat(26)); // Exibe uma linha decorativa
        System.out.print("| Digite a seed inicial:  |");  // Exibe o prompt
        System.out.println("\n" + "-".repeat(26)); // Exibe a linha decorativa novamente
        long seed = scanner.nextLong();  // Lê a seed do usuário

        // Solicita ao usuário a quantidade de números a serem gerados
        System.out.println("-".repeat(51)); // Exibe uma linha decorativa
        System.out.print("| Digite a quantidade de números a serem gerados:  |");  // Exibe o prompt
        System.out.println("\n" + "-".repeat(51)); // Exibe a linha decorativa novamente
        int quantity = scanner.nextInt();  // Lê a quantidade de números

        // Solicita ao usuário o tamanho da tabela hash
        System.out.println("-".repeat(36)); // Exibe uma linha decorativa
        System.out.print("| Digite o tamanho da tabela hash:  |");  // Exibe o prompt
        System.out.println("\n" + "-".repeat(36)); // Exibe a linha decorativa novamente
        int tableSize = scanner.nextInt();  // Lê o tamanho da tabela hash

        // Gera números aleatórios com base na seed usando um método da classe CSVUtils
        Registro[] randomNumbers = CSVUtils.generateSeedBasedNumbers(seed, quantity);

        // Exibe o menu para o usuário escolher o tipo de hash
        System.out.println("-".repeat(46)); // Exibe uma linha decorativa
        System.out.println("| Escolha o tipo de hash:                     |");
        System.out.println("| 1 - Hash por Dobramento                     |");
        System.out.println("| 2 - Hash por Módulo                         |");
        System.out.println("| 3 - Hash por Multiplicação                  |");
        System.out.println("-".repeat(46)); // Exibe a linha decorativa novamente
        int hashChoice = scanner.nextInt();  // Lê a escolha do tipo de hash

        // Inicializa uma variável para armazenar o tipo de hash em string
        String tipoHash = "";
        Registro[] hashedValues;

        // Calcula o hash com base na escolha do usuário
        switch (hashChoice) {
            case 1:
                System.out.println("Usando o Hash por Dobramento:");  // Informa qual tipo de hash está sendo utilizado
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);  // Chama o método para gerar o hash por dobramento
                tipoHash = "1";  // Hash por Dobramento
                break;
            case 2:
                System.out.println("Usando o Hash por Módulo:");  // Informa que o hash por módulo será utilizado
                hashedValues = HashGenerator.moduloHash(randomNumbers, tableSize, quantity);  // Chama o método para gerar o hash por módulo
                tipoHash = "2";  // Hash por Módulo
                break;
            case 3:
                System.out.println("Usando o Hash por Multiplicação:");  // Informa que o hash por multiplicação será utilizado
                hashedValues = HashGenerator.multiplicationHash(randomNumbers, tableSize, quantity);  // Chama o método para gerar o hash por multiplicação
                tipoHash = "3";  // Hash por Multiplicação
                break;
            default:
                System.out.println("Opção inválida! Usando o Hash por Dobramento por padrão.");  // Caso o usuário escolha uma opção inválida
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);  // Usa o hash por dobramento por padrão
                tipoHash = "1";  // Hash por Dobramento (padrão)
                break;
        }

        // Mede o tempo de inserção usando encadeamento (listas ligadas de nós)
        long startTime = System.nanoTime();  // Marca o tempo de início
        Node[] hashedTableNodes = HashTable.nodes(hashedValues, tableSize, quantity);  // Chama o método para inserir na tabela hash com encadeamento
        long endTime = System.nanoTime();  // Marca o tempo de fim
        long duration = endTime - startTime;  // Calcula a duração da inserção

        // O número de colisões seria capturado dentro do método nodes, mas aqui é inicializado como 0 para ilustrar
        int collisionCount = 0;  // Trocar para capturar o valor real das colisões, caso o método 'nodes' retorne essa informação

        // Gera um arquivo CSV com os resultados da operação
        CSVUtils.gerarArquivoCSV(tableSize, quantity, tipoHash, duration, collisionCount);

        // Exibe no console os resultados
        System.out.println("Hash armazenado baseado em Nodes.");
        System.out.println("Tempo de inserção (Node Encadeado): " + duration + " nanosegundos");  // Exibe o tempo de inserção
    }
}

