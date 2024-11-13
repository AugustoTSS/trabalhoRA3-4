public class HashGenerator {

    // Hash por Dobramento (para Registro[])
    public static Registro[] foldHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int hashValue = 0;
            int num = registros[i].codigo;  // Usa o código do registro
            
            // Dobramento: somar blocos de dois dígitos
            while (num > 0) {
                hashValue += num % 100;  // Pega os últimos dois dígitos
                num /= 100;              // Remove os últimos dois dígitos
            }
            // Evitar valores maiores que o tamanho da tabela
            hashValue = hashValue - (hashValue / tableSize) * tableSize;
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }

    // Hash por Módulo (para Registro[])
    public static Registro[] moduloHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int codigo = registros[i].codigo;
            
            // Operação de módulo manual para garantir o valor positivo
            int hashValue = codigo - (codigo / tableSize) * tableSize;
            if (hashValue < 0) hashValue += tableSize;  // Garante que o valor seja positivo
            
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }

    // Hash por Multiplicação (para Registro[])
    public static Registro[] multiplicationHash(Registro[] registros, int tableSize, int size) {
        double A = 0.6180339887;  // Constante usada no método de multiplicação
        for (int i = 0; i < size; i++) {
            int codigo = registros[i].codigo;
            
            // Calcula hash pela multiplicação sem métodos prontos
            double fractionalPart = (codigo * A) - Math.floor(codigo * A);  // Parte fracionária de (codigo * A)
            int hashValue = (int) (tableSize * fractionalPart);  // Calcula o índice usando o tamanho da tabela
            
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }
}
