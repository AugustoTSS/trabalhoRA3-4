public class Hashs {
    public static int hashDiv(int chave, int tamanhoTabela) {
        return ((chave % tamanhoTabela) + tamanhoTabela) % tamanhoTabela;
    }

    public static int hashMultiplicacao(int chave, int tamanhoTabela) {
        double A = 0.6180339887; // constante
        return (int) ((tamanhoTabela * (chave * A - Math.floor(chave * A))) % tamanhoTabela + tamanhoTabela) % tamanhoTabela;
    }

    public static int hashDobramento(int chave, int tamanhoTabela) {
        int parte1 = chave / 1000;       // primeiros 3 digitos
        int parte2 = (chave / 100) % 10; // digito do meio
        int parte3 = chave % 1000;       // ultimos 3 digitos
        return (int) ((parte1 + parte2 + parte3) % tamanhoTabela + tamanhoTabela) % tamanhoTabela;
    }
}

