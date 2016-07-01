import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.*;

/**
 * Created by professor on 27/06/2016.
 */
public class MapColoresUnFor {


    private static Scanner sc = new Scanner(System.in);
    private static Map<String, List<? extends Poliedro>> mapColores = new HashMap<>();
    private static List<Poliedro> arrayList = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Introduce el numero de cubos verdes");
        int numeroVerdes = sc.nextInt();
        System.out.println("Introduce el numero de cubos rojos");
        int numeroRojos = sc.nextInt();
        System.out.println("Introduce el numero de cubos amarillos");
        int numeroAmarillos = sc.nextInt();


        obtenerCubosColor(numeroVerdes, "Verde");
        obtenerCubosColor(numeroRojos, "Rojo");
        obtenerCubosColor(numeroAmarillos, "Amarillos");


        List<Poliedro> poliedroListVerde = (List<Poliedro>) mapColores.get("Verdes");
        List<Poliedro> poliedroListRojo = (List<Poliedro>) mapColores.get("Rojos");
        List<Poliedro> poliedroListAmarillo = (List<Poliedro>) mapColores.get("Amarillos");


        System.out.println("La lista de cubos verdes es: ");

        System.out.println(poliedroListVerde);

        System.out.println("La lista de cubos rojos es: ");

        System.out.println(poliedroListRojo);

        System.out.println("La lista de cubos amarillos es: ");

        System.out.println(poliedroListAmarillo);


    }

    private static void obtenerCubosColor(int numeroCubos, String color) {
        List<Cubo> cuboList = new ArrayList<>();
        for (int i = 1; i <= numeroCubos; i++) {

            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();


            Cubo cubo = new Cubo(i, color, arista);

            cuboList.add(cubo); // añadimos al arrayList particular


        }
        mapColores.put(color, cuboList);
    }

}



