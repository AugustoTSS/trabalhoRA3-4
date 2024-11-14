public class TabelaHashRehashing {
    private Registro[] tabela;
    private int tamanho;
    public int contagemColisoes;

    public TabelaHashRehashing(int tamanho) {
        this.tabela = new Registro[tamanho];
        this.tamanho = tamanho;
        this.contagemColisoes = 0;
    }

    public void inserir(Registro registro, int tipoHash) {
        int codigo = registro.codigo;
        int hash = obterHash(codigo, tipoHash);

        // Normalizar o indice do hash para garantir que seja positivo
        int indice = Math.abs(hash % tamanho);
        int i = 0;
        while (tabela[indice] != null) {
            contagemColisoes++;
            i++;
            indice = (hash + i) % tamanho; // probing linear
            indice = Math.abs(indice); // Garantir que o inndice seja positivo apos o probingg
        }
        tabela[indice] = registro;
    }
    private int obterHash(int chave, int tipoHash) {
        if (tipoHash == 1) {
            return Hashs.hashDiv(chave, tamanho);
        } else if (tipoHash == 2) {
            return Hashs.hashMultiplicacao(chave, tamanho);
        } else {
            return Hashs.hashDobramento(chave, tamanho);
        }
    }

    public boolean buscar(int codigo, int tipoHash) {
        int hash = obterHash(codigo, tipoHash);
        int indice = hash;
        int i = 0;

        while (tabela[indice] != null) {
            if (tabela[indice].codigo == codigo) {
                return true;  // Encontrou o registro
            }
            indice = (hash + ++i) % tamanho; // Probing linear
        }
        return false;  // Não encontrou o registro
    }
}
