import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//primer punto: crear una lista de numeros (debe ser de 6) y sumar los valores usando un for each

        ArrayList<Integer> numeros = new ArrayList<>();

        //numeros

        numeros.add(682945);
        numeros.add(993750);
        numeros.add(557295);
        numeros.add(928428);
        numeros.add(153850);
        numeros.add(650294);
        numeros.add(402850);

        int suma = 0;

        for (int x : numeros) {
            suma = suma + x;
        }
        System.out.println("La suma total de:" + numeros + " es de : " + suma);




//Segundo punto: crear una lista de nombres y imprimirlos con for, foreach y while


        ArrayList<String> nombres = new ArrayList<>();

        //nombres

        nombres.add("Maria");
        nombres.add("Felipe");
        nombres.add("Castro");
        nombres.add("Ashly");
        nombres.add("Julian");
        nombres.add("Sebastian");
//foreach
        System.out.println("CON CICLO FOR-EACH");
        int j = 1;
        for (String nombre : nombres) {
            System.out.println(j + ": " + nombre);
            j++;
        }
//for
        System.out.println("CON CICLO FOR");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println ((i + 1) +": " + nombres.get(i));
        }
//while
        System.out.println("CON CICLO WHILE");
        int i = 0;
        while (i < nombres.size()) {
            System.out.println((i + 1)+": " + nombres.get(i));
            i++;
        }
    }
}