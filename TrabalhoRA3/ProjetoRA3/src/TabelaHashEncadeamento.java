    public class TabelaHashEncadeamento {
        private Node[] tabela;
        private int tamanho;
        public int contagemColisoes;

        public TabelaHashEncadeamento(int tamanho) {
            this.tabela = new Node[tamanho];
            this.tamanho = tamanho;
            this.contagemColisoes = 0;
        }

        public void inserir(Registro registro, int tipoHash) {
            int codigo = registro.codigo;
            int hash = obterHash(codigo, tipoHash);

            // Normalizar o indice do hash para garantir que seja positivo
            int indice = Math.abs(hash % tamanho);

            // Verifica se há colisão (ou seja, se a posição já contém um nó)
            if (tabela[indice] != null) {
                contagemColisoes++;
            }

            // Adiciona o novo nó na posição correspondente
            Node novoNode = new Node(registro);
            novoNode.proximoNode = tabela[indice]; // Faz o novo nó apontar para um nó existnte, se existir um novo nó
            tabela[indice] = novoNode; // A posição na tabela aponta para o novo nó
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
            int indice = Math.abs(hash % tamanho);  // Normaliza o índice para garantir que seja positivo

            Node atual = tabela[indice];
            while (atual != null) {
                if (atual.registro.codigo == codigo) {
                    return true;  // Encontrou o registro
                }
                atual = atual.proximoNode;  // Vai para o próximo nó na lista
            }
            return false;  // Não encontrou o registro
        }
    }