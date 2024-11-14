public class Node {
    public Registro registro;
    public Node proximoNode;

    public Node(Registro registro) {
        this.registro = registro;
        this.proximoNode = null;
    }
}