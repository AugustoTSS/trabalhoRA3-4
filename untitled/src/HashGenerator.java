public class HashGenerator {

    // Hash por Dobramento: divide o código em blocos e soma esses blocos
    public static Registro[] foldHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int hashValue = 0;
            int num = registros[i].codigo;  // Usa o código do registro

            // Divide o código em blocos de dois dígitos e soma cada bloco
            while (num > 0) {
                hashValue += num % 100;  // Pega os últimos dois dígitos
                num /= 100;              // Remove os dois últimos dígitos
            }

            // Garante que o hashValue fique dentro dos limites da tabela
            hashValue = hashValue % tableSize;
            registros[i].hash = hashValue;  // Atribui o hash calculado ao objeto Registro
        }
        return registros;
    }

    // Hash por Módulo: utiliza o código diretamente com o operador de módulo
    public static Registro[] moduloHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int hashValue = registros[i].codigo % tableSize;  // Calcula o hash pelo módulo da tabela
            
            // Garante que o hash seja positivo (em caso de números negativos)
            registros[i].hash = (hashValue < 0) ? hashValue + tableSize : hashValue;
        }
        return registros;
    }

    // Hash por Multiplicação: usa uma constante A para gerar a parte fracionária do código
    public static Registro[] multiplicationHash(Registro[] registros, int tableSize, int size) {
        double A = 0.6180339887;  // Constante sugerida (padrão no método de multiplicação)
        for (int i = 0; i < size; i++) {
            // Multiplica o código por A e extrai a parte fracionária
            double fractionalPart = (registros[i].codigo * A) % 1;
            
            // Multiplica a parte fracionária pelo tamanho da tabela para gerar o índice do hash
            int hashValue = (int) (tableSize * fractionalPart);
            registros[i].hash = hashValue;  // Atribui o hash calculado ao objeto Registro
        }
        return registros;
    }
}
