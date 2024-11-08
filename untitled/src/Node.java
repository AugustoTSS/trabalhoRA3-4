public class Node {

    // Atributo que armazena o registro associado a este nó.
    public Registro registro;

    // Atributo que aponta para o próximo nó na lista encadeada.
    public Node proximoNode;

    // Construtor da classe Node, que inicializa o nó com um registro e define o próximo nó como null.
    public Node(Registro registro) {
        this.registro = registro;  // Atribui o registro passado como parâmetro ao atributo 'registro'.
        this.proximoNode = null;   // Inicializa o próximo nó como 'null', indicando que não há outro nó encadeado ainda.
    }
}
