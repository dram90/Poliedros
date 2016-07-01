import java.util.*;

/**
 * Created by professor on 27/06/2016.
 */
public class MapColores {

    private static Scanner sc = new Scanner(System.in);
    private static Map<String, List<? extends Poliedro>> mapColores = new HashMap<>();
    private static List<Poliedro> arrayList = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Introduce el numero de cubos verdes");
        int numeroVerdes = sc.nextInt();
        List<Cubo> cuboListVerde = new ArrayList<>();




        for (int i = 1; i <= numeroVerdes; i++) {

            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();


            Cubo cubo = new Cubo(i,"Verde", arista);

            cuboListVerde.add(cubo); // añadimos al arrayList particular
            arrayList.add(cubo); //añadimos el cubo al arrayList gral
        }
        mapColores.put("Verdes",cuboListVerde);




        System.out.println("Introduce el numero de cubos rojos");
        int numeroRojos = sc.nextInt();
        List<Cubo> cuboListRojo = new ArrayList<>();

        for (int i = 1; i <= numeroRojos; i++) {

            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();


            Cubo cubo = new Cubo(i,"Rojo", arista);

            cuboListRojo.add(cubo); // añadimos al arrayList particular
            arrayList.add(cubo); //añadimos el cubo al arrayList gral
        }
        mapColores.put("Rojos",cuboListRojo);


        List<Poliedro> poliedroListVerde = (List<Poliedro>) mapColores.get("Verdes");
        List<Poliedro> poliedroListRojo = (List<Poliedro>) mapColores.get("Rojos");


        System.out.println("La lista de cubos verdes es: ");

        System.out.println(poliedroListVerde);

        System.out.println("La lista de cubos rojos es: ");

        System.out.println(poliedroListRojo);


    }

}