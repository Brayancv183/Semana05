import java.util.ArrayList;
import java.util.Random;

public class Semana4_Ordenamientos {
    //meoto burbuja, va elemento por elemento en la lista y va comparando con el siguiente, si es mayor, los intercambia
    public static void Metodoburbuja(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambiamos los elementos
                    int temporal = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temporal);
                }
            }
        }
    }
    //metodo seleccion, busca el elemento minimo en la lista y lo intercambia con el primer elemento, luego repite el proceso con el resto de la lista
    public static void MetodoSeleccion(ArrayList<Integer> lista) {
        int n = lista.size();
        // Encontramos el elemento mínimo en el subarray no ordenado
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) < lista.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }

            // Intercambiamos el elemento mínimo con el primer elemento del subarray no ordenado
            if (indiceMinimo != i) {
                int temporal = lista.get(i);
                lista.set(i, lista.get(indiceMinimo));
                lista.set(indiceMinimo, temporal);
            }
        }
    }
    //metodo insercion, toma un elemento y lo inserta en la posicion correcta dentro de la lista ordenada
    public static void MetodoInsercion(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            int clave = lista.get(i); // Elemento actual a insertar
            int j = i - 1;
            //se mueven los elementos mayores que la clave una posición adelante
            while (j >= 0 && lista.get(j) > clave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }

            // Insertar la clave en la posición correcta
            lista.set(j + 1, clave);
        }
    }

    public static void main(String[] args) {
        // Creamos 3 listas de 100 números aleatorios entre 1 y 100
        ArrayList<Integer> lista_desordenada1 = new ArrayList<>();
        Random random1 = new Random();

        ArrayList<Integer> lista_desordenada2 = new ArrayList<>();
        Random random2 = new Random();

        ArrayList<Integer> lista_desordenada3 = new ArrayList<>();
        Random random3 = new Random();

        // Llenar la lista con números aleatorios
        for (int i = 0; i < 100; i++) {
            lista_desordenada1.add(random1.nextInt(100) + 1);
            lista_desordenada2.add(random2.nextInt(100) + 1);
            lista_desordenada3.add(random3.nextInt(100) + 1);
        }

        System.out.println("\nListas desordenadas:");

        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________\nLista desordenada 1: Lista desordenada para metodo burbuja." );
            for (int x = 0; x < 100; x++) {
                System.out.print(lista_desordenada1.get(x) + " ");
            }

        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________\nLista desordenada 2: Lista desordenada para metodo seleccion." );
            for (int y = 0; y < 100; y++) {
                System.out.print(lista_desordenada1.get(y) + " ");
            }

        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________\nLista desordenada 1: Lista desordenada para metodo insercion." );
            for (int z = 0; z < 100; z++) {
                System.out.print(lista_desordenada1.get(z) + " ");
            }

        // Hacemos copias para cada método
        ArrayList<Integer> lista_burbuja = new ArrayList<>(lista_desordenada1);
        ArrayList<Integer> lista_seleccion = new ArrayList<>(lista_desordenada2);
        ArrayList<Integer> lista_insercion = new ArrayList<>(lista_desordenada3);

        // ======= MÉTODO BURBUJA =======
        System.out.println("\n\n====== MÉTODO BURBUJA ======");

        long tiempo_inicial_burbuja = System.nanoTime();
        Metodoburbuja(lista_burbuja);
        long tiempo_final_burbuja = System.nanoTime();
        long lapso_tiempo_burbuja = tiempo_final_burbuja - tiempo_inicial_burbuja;

        System.out.println("elementos ordenados con metodo burbuja:");
        for (int i = 0; i < lista_burbuja.size(); i++) {
            System.out.print(lista_burbuja.get(i) + " ");
        }

        System.out.println("\nTiempo de ejecución (burbuja): " + lapso_tiempo_burbuja + " nanosegundos");

        // ======= MÉTODO SELECCIÓN =======
        System.out.println("\n\n====== MÉTODO SELECCIÓN ======");

        long tiempo_inicial_seleccion = System.nanoTime();
        MetodoSeleccion(lista_seleccion);
        long tiempo_final_seleccion = System.nanoTime();
        long lapso_tiempo_seleccion = tiempo_final_seleccion - tiempo_inicial_seleccion;

        System.out.println("elementos ordenados con meotodo selección:");
        for (int i = 0; i < lista_seleccion.size(); i++) {
            System.out.print(lista_seleccion.get(i) + " ");
        }

        System.out.println("\nTiempo de ejecución (selección): " + lapso_tiempo_seleccion + " nanosegundos");

        // ======= MÉTODO INSERCIÓN =======
        System.out.println("\n\n====== MÉTODO INSERCIÓN ======");

        long tiempo_inicial_insercion = System.nanoTime();
        MetodoInsercion(lista_insercion);
        long tiempo_final_insercion = System.nanoTime();
        long lapso_tiempo_insercion = tiempo_final_insercion - tiempo_inicial_insercion;

        System.out.println("elementos ordenados con metodo inserción:");
        for (int i = 0; i < lista_insercion.size(); i++) {
            System.out.print(lista_insercion.get(i) + " ");
        }

        System.out.println("\nTiempo de ejecución (inserción): " + lapso_tiempo_insercion + " nanosegundos");

        // ======= VERIFICACIÓN =======
        System.out.println("\n\n====== VERIFICACIÓN DE ORDENAMIENTO ======");

        boolean ordenado_burbuja = estaOrdenado(lista_burbuja);
        boolean ordenado_seleccion = estaOrdenado(lista_seleccion);
        boolean ordenado_insercion = estaOrdenado(lista_insercion);

        System.out.println("¿Burbuja ordenó correctamente? " + ordenado_burbuja);
        System.out.println("¿Selección ordenó correctamente? " + ordenado_seleccion);
        System.out.println("¿Inserción ordenó correctamente? " + ordenado_insercion);

        // ======= COMPARACIÓN FINAL =======
        System.out.println("\n\n====== COMPARACIÓN DE TIEMPOS ======");
        System.out.println("Burbuja:    " + lapso_tiempo_burbuja + " nanosegundos");
        System.out.println("Selección:  " + lapso_tiempo_seleccion + " nanosegundos");
        System.out.println("Inserción:  " + lapso_tiempo_insercion + " nanosegundos");


        // Determinar el método más rápido
        System.out.println("\n====== MÉTODO MÁS RÁPIDO ======");
        String metodoMasRapido = "";
        long tiempoMasRapido = Math.min(lapso_tiempo_burbuja, Math.min(lapso_tiempo_seleccion, lapso_tiempo_insercion));

        if (tiempoMasRapido == lapso_tiempo_burbuja) {
            metodoMasRapido = "Burbuja";
        } else if (tiempoMasRapido == lapso_tiempo_seleccion) {
            metodoMasRapido = "Selección";
        } else {
            metodoMasRapido = "Inserción";
        }

        System.out.println("\nMétodo más rápido: " + metodoMasRapido);
    }

    // Método auxiliar para verificar si una lista está ordenada
    public static boolean estaOrdenado(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i) > lista.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}