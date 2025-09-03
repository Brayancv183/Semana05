import java.util.ArrayList;

public class Demolist {

    public static void main(String[] args) {

        ArrayList<String> Nombres = new ArrayList<>();

        //agregamos

        Nombres.add("Brayan");
        Nombres.add("Ana");
        Nombres.add("Luis");
        Nombres.add("pedro");
        Nombres.add("Maria");
        //eliminamos

        Nombres.remove("Maria");

        //imprimimos

        for (int i = 1; i < Nombres.size(); i++) {
            System.out.println(i + ":" + Nombres.get(i));
        }





        //crear lista
        ArrayList<Integer> Suma_edades = new ArrayList<>();

        //agregar
        Suma_edades.add(22);
        Suma_edades.add(17);
        Suma_edades.add(19);
        Suma_edades.add(20);
        Suma_edades.add(21);
        Suma_edades.add(18);
        Suma_edades.add(25);

        int promedio_edades = 0;

        for ( int i = 0; i < Suma_edades.size(); i++) {
            promedio_edades = promedio_edades + Suma_edades.get(i);
            }

        System.out.println("el promedio de de edad de la clase es de " + (promedio_edades/Suma_edades.size()) + " años");

    }

}

