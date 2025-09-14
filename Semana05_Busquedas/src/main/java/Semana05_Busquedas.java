import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Semana05_Busquedas {

    // Variables para contar comparaciones
    private static int comparacionesLineal = 0;
    private static int comparacionesBinaria = 0;

    // Creamos la funcion de búsqueda lineal
    public static int busquedaLineal(int[] arr, int valor) {
        comparacionesLineal = 0; // Reiniciar contador
        for (int i = 0; i < arr.length; i++) {
            comparacionesLineal++; // Contar cada comparación
            if (arr[i] == valor) {
                return i; // Retornamos el índice donde se encontró el valor
            }
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // creamos la funcion de búsqueda binaria (solo si el array está ordenado)
    public static int busquedaBinaria(int[] arr, int valor) {
        comparacionesBinaria = 0; // Reiniciar contador
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            comparacionesBinaria++; // Contar cada iteración del ciclo

            int medio = izquierda + (derecha - izquierda) / 2;

            comparacionesBinaria++; // Contar la comparación del if
            if (arr[medio] == valor) {
                return medio; // Valor encontrado
            }

            comparacionesBinaria++; // Contar la comparación del segundo if
            if (arr[medio] < valor) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // El valor no se encontro
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Funcion para hacer un arreglo de 20 números enteros aleatorios (entre 1 y 100)
        int[] numeros = new int[20];
        System.out.print("Arreglo generado: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Números entre 1 y 100
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // pedimos al usuario el valor a buscar en el arreglo
        System.out.print("\nIngrese el número que desea buscar: ");
        int valorBuscado = scanner.nextInt();

        // Búsqueda lineal
        System.out.println("\n--- BÚSQUEDA LINEAL ---");
        int resultadoLineal = busquedaLineal(numeros, valorBuscado);
        if (resultadoLineal != -1) {
            System.out.println("El valor " + valorBuscado + " se encontró en la posición: " + resultadoLineal);
        } else {
            System.out.println("El valor " + valorBuscado + " no se encontró en el arreglo");
        }
        System.out.println("Comparaciones realizadas: " + comparacionesLineal);

        // Ordenar el arreglo para la funcion de la búsqueda binaria
        int[] numerosOrdenados = numeros.clone();
        Arrays.sort(numerosOrdenados);
        System.out.print("\nArreglo ordenado: ");
        for (int num : numerosOrdenados) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Búsqueda binaria
        System.out.println("\n--- BÚSQUEDA BINARIA ---");
        int resultadoBinaria = busquedaBinaria(numerosOrdenados, valorBuscado);
        if (resultadoBinaria != -1) {
            System.out.println("El valor " + valorBuscado + " se encontró en la posición: " + resultadoBinaria + " (del arreglo ordenado)");
        } else {
            System.out.println("El valor " + valorBuscado + " no se encontró en el arreglo");
        }
        System.out.println("Comparaciones realizadas: " + comparacionesBinaria);

        // Mostrar eficiencia comparativa
        System.out.println("\n--- COMPARATIVA DE EFICIENCIA ---");
        System.out.println("Diferencia de comparaciones: " + (comparacionesLineal - comparacionesBinaria));

        if (comparacionesBinaria < comparacionesLineal) {
            System.out.println("La búsqueda binaria fue " +
                    (comparacionesLineal / comparacionesBinaria) + " veces más eficiente");
        }

        scanner.close();
    }
}