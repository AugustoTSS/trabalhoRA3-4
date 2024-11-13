public class Main {

    public static void main(String[] args) {
        long seed = 12;  // Seed fixa para gerar números aleatórios
        int quantity = 10; // Quantidade de números a serem gerados
        int tableSize = 20; // Tamanho da tabela hash

        Registro[] randomNumbers = CSVUtils.generateSeedBasedNumbers(seed, quantity);

        int hashChoice = 1; // Tipo de hash: 1 - Dobramento, 2 - Módulo, 3 - Multiplicação
        Registro[] hashedValues;
        String tipoHash;

        // Calcula o hash com base na escolha
        switch (hashChoice) {
            case 1:
                System.out.println("Usando o Hash por Dobramento:");
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);
                tipoHash = "1";
                break;
            case 2:
                System.out.println("Usando o Hash por Módulo:");
                hashedValues = HashGenerator.moduloHash(randomNumbers, tableSize, quantity);
                tipoHash = "2";
                break;
            case 3:
                System.out.println("Usando o Hash por Multiplicação:");
                hashedValues = HashGenerator.multiplicationHash(randomNumbers, tableSize, quantity);
                tipoHash = "3";
                break;
            default:
                System.out.println("Opção inválida! Usando o Hash por Dobramento.");
                hashedValues = HashGenerator.foldHash(randomNumbers, tableSize, quantity);
                tipoHash = "1";
                break;
        }

        long startTime = System.nanoTime();
        Node[] hashedTableNodes = HashTable.nodes(hashedValues, tableSize, quantity);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        int collisionCount = 0; // Substituir se o método nodes retornar as colisões

        CSVUtils.gerarArquivoCSV(tableSize, quantity, tipoHash, duration, collisionCount);

        System.out.println("Hash armazenado com Nodes.");
        System.out.println("Tempo de inserção: " + duration + " nanosegundos");
    }
}
