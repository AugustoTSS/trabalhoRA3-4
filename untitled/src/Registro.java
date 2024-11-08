public class Registro {

    // Atributo que armazena o código do registro.
    public int codigo;

    // Atributo que armazena o valor de hash associado ao registro.
    public int hash;

    // Construtor da classe Registro que inicializa os atributos 'codigo' e 'hash'.
    public Registro(int codigo, int hash) {
        this.codigo = codigo;  // Atribui o valor do código ao atributo 'codigo'.
        this.hash = hash;      // Atribui o valor do hash ao atributo 'hash'.
    }
}
