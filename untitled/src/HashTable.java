public class HashTable {
    // Método que cria uma tabela hash e insere registros nela.
    public static Node[] nodes(Registro[] registro, int tableSize, int quantity) {
        // Inicializa a tabela hash com o tamanho especificado.
        Node[] hashTable = new Node[tableSize];
        // Variáveis auxiliares para contagem de inserções sem colisão, inserções em nós (colisões resolvidas) e o número de colisões.
        int IntInsrc = 0;
        int IntNode = 0;
        int collisionCount = 0;

        // Laço que percorre todos os registros para inseri-los na tabela hash.
        for (int i = 0; i < quantity; i++) {
            // Calcula o índice do hash para o registro atual.
            int hashIndex = registro[i].hash;

            // Verifica se já existe um nó na posição calculada pelo índice de hash.
            if (hashTable[hashIndex] == null) {
                // Se não existir, cria um novo nó na posição correspondente e incrementa a contagem de inserções sem colisões.
                hashTable[hashIndex] = new Node(registro[i]);
                IntInsrc++;
            } else {
                // Caso já exista um nó (colisão), encontra o último nó da lista ligada para adicionar o novo nó.
                Node current = hashTable[hashIndex];
                while (current.proximoNode != null) {
                    current = current.proximoNode;
                }
                // Adiciona o novo nó ao final da lista ligada, ou seja, resolve a colisão.
                current.proximoNode = new Node(registro[i]);
                IntNode++; // Incrementa o contador de inserções em nós.
                collisionCount++; // Incrementa o contador de colisões.
            }
        }

        // Exibe os resultados no console: número de inserções sem colisão, inserções em nós e número total de colisões.
        System.out.println("Foram Feitas [" + IntInsrc + "] Inserções sem colisão.");
        System.out.println("Foram Feitas [" + IntNode + "] Inserções em Nodes (colisões resolvidas).");
        System.out.println("Número total de colisões: [" + collisionCount + "]");

        // Retorna a tabela hash com os registros inseridos.
        return hashTable;
    }
}
