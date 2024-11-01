public class HashTable {
public static Node[] nodes(Registro[] registro, int tableSize, int quantity) {
        Node[] hashTable = new Node[tableSize];
        int IntInsrc = 0;
        int IntNode = 0 ;
        int collisionCount = 0;


    for (int i = 0; i < quantity; i++){
            int hashIndex = registro[i].hash;

            if(hashTable[hashIndex] == null) {
                hashTable[hashIndex] = new Node(registro[i]);
                IntInsrc++;
            } else {
                Node current = hashTable[hashIndex];
                while (current.proximoNode != null) {
                    current = current.proximoNode;
                }
                current.proximoNode = new Node(registro[i]);
                IntNode++;
                collisionCount++;
            }

        }
        System.out.println("Foram Feitas ["+ IntInsrc + "] Inserções sem colisão.");
        System.out.println("Foram Feitas ["+ IntNode + "] Inserções em Nodes (colisões resolvidas).");
        System.out.println("Número total de colisões: [" + collisionCount + "]");
        return hashTable;
    }
}
