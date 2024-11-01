public class HashGenerator {

    // Hash por Dobramento (para Registro[])
    public static Registro[] foldHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int hashValue = 0;
            int num = registros[i].codigo;  // Usa o código do registro
            while (num > 0) {
                hashValue += num % 100;
                num /= 100;
            }
            hashValue %= tableSize;
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }

    // Hash por Módulo (para Registro[])
    public static Registro[] moduloHash(Registro[] registros, int tableSize, int size) {
        for (int i = 0; i < size; i++) {
            int hashValue = Math.abs(registros[i].codigo % tableSize);  // Garante que o valor do hash seja positivo
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }

    // Hash por Multiplicação (para Registro[])
    public static Registro[] multiplicationHash(Registro[] registros, int tableSize, int size) {
        double A = 0.6180339887;  // Constante usada no método de multiplicação
        for (int i = 0; i < size; i++) {
            int hashValue = (int) (tableSize * ((registros[i].codigo * A) % 1));
            registros[i].hash = hashValue;  // Atribui o hash gerado ao objeto Registro
        }
        return registros;
    }
}
