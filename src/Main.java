import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.*;

public class Main {

    public static final String CUBOS = "Cubos";
    public static final String TETRAEDROS = "Tetraedros";
    public static final String OCTAEDROS = "Octaedros";
    public static final String ICOSAEDROS = "Icosaedros";
    public static final String DODECAEDROS = "Dodecaedros";
    static ListMultimap<String, Poliedro> colorPoliedroMultiMap = ArrayListMultimap.create();
    static ListMultimap<String, Poliedro> tipoPoliedroMultiMap = ArrayListMultimap.create();

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);

        List<Poliedro> arrayList = new ArrayList<>();
        System.out.println("Introduce el numero de poliedros para cada tipo:  ");
        int numero = sc.nextInt();



        obtenerCubos(sc, arrayList, numero);

        obtenerTetraedros(sc, arrayList, numero);

        obtenerOctaedros(sc, arrayList, numero);

        obtenerDodecaedros(sc, arrayList, numero);

        obtenerIcosaedros(sc, arrayList, numero);


        procesarPoliedros(arrayList, numero);

        mostrarMultiMapPoliedros();


        consultarMultiMapPoliedros(CUBOS);
        consultarMultiMapPoliedros(TETRAEDROS);
        consultarMultiMapPoliedros(OCTAEDROS);
        consultarMultiMapPoliedros(DODECAEDROS);
        consultarMultiMapPoliedros(ICOSAEDROS);
    }

    private static void consultarMultiMapPoliedros(String tipoPoliedro) {

        List<Poliedro> poliedroList = tipoPoliedroMultiMap.get(tipoPoliedro);

        System.out.println("La lista de " +tipoPoliedro+ " es: ");
        System.out.println(poliedroList);
    }

    private static void mostrarMultiMapPoliedros() {

        System.out.println("MultiMap de tipos de poliedros: ");
        System.out.println(tipoPoliedroMultiMap);
        System.out.println("MultiMap de colores de poliedros");
        System.out.println(colorPoliedroMultiMap);
    }

    private static void procesarPoliedros(List<Poliedro> arrayList, int numero) {
        Poliedro min = null;
        Poliedro max = null;
        double totalVolumen = 0;
        int cont1 = 0; // cuenta los poliedros de volumen menor que 20
        int cont2 = 0; // cuenta los poliedros de volumen comprendida entre 20 y 100
        int cont3 = 0; // cuenta los poliedros con volumen mayor que 100
        //contadores que cuentan el num de poliedros de cada color
        int colorPorDefecto=0;
        int color1=0;
        int color2=0;
        int color3=0;
        int color4=0;
        int color5=0;
        int color6=0;
        int color7 =0;
        int color8=0;
        int color9=0;
        int color10 =0;


        for (Poliedro poliedro : arrayList) {
            double volumenActual = poliedro.calcularVolumen();
            String colorActual = poliedro.getColor();
            System.out.println("El volumen del poliedro " + poliedro.getId() + " es = " + volumenActual);
            totalVolumen = totalVolumen + volumenActual;
            System.out.println("El color del poliedro es: " +poliedro.getColor());

            if (volumenActual < 20) {
                cont1++;
            } else if ((volumenActual >= 20) && (volumenActual <= 100)) {
                cont2++;
            } else {
                cont3++;
            }



            switch(colorActual)
            {

                case ("Amarillo"):
                    color1 ++;
                    break;
                case ("Azul"):
                    color2 ++;
                    break;
                case ("Blanco"):
                    color3 ++;
                    break;
                case ("Lila"):
                    color4 ++;
                    break;
                case ("Marron"):
                    color5 ++;
                    break;
                case ("Naranja"):
                    color6 ++;
                    break;
                case ("Negro"):
                    color7 ++;
                    break;
                case ("Rojo"):
                    color8 ++;
                    break;
                case ("Rosa"):
                    color9 ++;
                    break;
                case ("Verde"):
                    color10 ++;
                    break;

                default: colorPorDefecto++;
                        break;
            }


            invocarMetodosEspecificos(poliedro);

            if (max == null) {
                max = poliedro;
                min = poliedro;
            } else {
                if (volumenActual > max.calcularVolumen()) {
                    max = poliedro;
                }
                if (volumenActual < min.calcularVolumen()) {
                    min = poliedro;
                }

            }

        }
        int totalPoliedros = numero * 3;
        double media = totalVolumen / totalPoliedros;
        System.out.println("La media de los volumenes es = " + media);
        System.out.println("El poliedro de volumen maximo es " + max);
        System.out.println("El poliedro de volumen minimo es " + min);
        System.out.println("El numero de poliedros con volumen menor a 20 es " + cont1);
        System.out.println("El numero de poliedros con volumen entre 20 y 100 ambos incluidos es " + cont2);
        System.out.println("El numero de poliedros con volumen mayor a 100 es " + cont3);

        System.out.println("El numero de poliedros de color Amarillo es: "+ color1);
        System.out.println("El numero de poliedros de color Azul es: "+ color2);
        System.out.println("El numero de poliedros de color Blanco es: "+ color3);
        System.out.println("El numero de poliedros de color Lila es: "+ color4);
        System.out.println("El numero de poliedros de color Marron es: "+ color5);
        System.out.println("El numero de poliedros de color Naranja es: "+ color6);
        System.out.println("El numero de poliedros de color Negro es: "+ color7);
        System.out.println("El numero de poliedros de color Rojo es: "+ color8);
        System.out.println("El numero de poliedros de color Rosa es: "+ color9);
        System.out.println("El numero de poliedros de color Verde es: "+ color10);
    }

    private static void obtenerCubos(Scanner sc, List<Poliedro> arrayList, int numero) {

        for (int i = 1; i <= numero; i++) {
            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();


            Cubo cubo = new Cubo(i, colorSeleccionado, arista);
            //guardamos el cubo una sola vez. No está por duplicado.
            arrayList.add(cubo);
            colorPoliedroMultiMap.put(colorSeleccionado, cubo);
            tipoPoliedroMultiMap.put(CUBOS, cubo);
        }
    }

    private static void obtenerTetraedros(Scanner sc, List<Poliedro> arrayList, int numero) {


        for (int i = 1; i <= numero; i++) {
            System.out.println("Introduce los datos del tetraedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            Tetraedro tetraedro =new Tetraedro(i + numero, colorSeleccionado, arista);
            arrayList.add(tetraedro);
            colorPoliedroMultiMap.put(colorSeleccionado, tetraedro);
            tipoPoliedroMultiMap.put(TETRAEDROS, tetraedro);
        }


    }

    private static void obtenerOctaedros(Scanner sc, List<Poliedro> arrayList, int numero) {


        for (int i = 1; i <= numero; i++) {
            System.out.println("Introduce los datos del octaedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            Octaedro octaedro = new Octaedro(i + 2 * numero, colorSeleccionado, arista);
            arrayList.add(octaedro);
            colorPoliedroMultiMap.put(colorSeleccionado, octaedro);
            tipoPoliedroMultiMap.put(OCTAEDROS, octaedro);
        }


    }

    private static void obtenerIcosaedros(Scanner sc, List<Poliedro> arrayList, int numero) {


        for (int i = 1; i <= numero; i++) {
            System.out.println("Introduce los datos del icosaedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            Icosaedro icosaedro =new Icosaedro(i + 4 * numero, colorSeleccionado, arista);
            arrayList.add(icosaedro);
            colorPoliedroMultiMap.put(colorSeleccionado, icosaedro);
            tipoPoliedroMultiMap.put(ICOSAEDROS, icosaedro);

        }


    }

    private static void obtenerDodecaedros(Scanner sc, List<Poliedro> arrayList, int numero) {


        for (int i = 1; i <= numero; i++) {
            System.out.println("Introduce los datos del dodecaedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            System.out.println("Introduce el apotema:");
            double apotema = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            Dodecaedro dodecaedro =new Dodecaedro(i + 3 * numero, colorSeleccionado, arista, apotema);
            arrayList.add(dodecaedro);
            colorPoliedroMultiMap.put(colorSeleccionado, dodecaedro);
            tipoPoliedroMultiMap.put(DODECAEDROS, dodecaedro);
        }

    }


    private static void invocarMetodosEspecificos(Poliedro poliedro) {
        if (poliedro instanceof Cubo) {
            System.out.println("La diagonal del cubo es = " + ((Cubo) poliedro).calcularDiagonal());
            System.out.println("El area lateral es = " + (((Cubo) poliedro).calcularAreaLateral()));
            System.out.println("El area lateral total es = " + ((Cubo) poliedro).calcularAreaTotal());
        }

        if (poliedro instanceof Tetraedro) {
            System.out.println("El area del tetraedro es = " + ((Tetraedro) poliedro).calcularArea());
        }

        if (poliedro instanceof Octaedro) {
            System.out.println("El area del octaedro es = " + ((Octaedro) poliedro).calcularArea());
        }

        if (poliedro instanceof Dodecaedro) {
            System.out.println("El area del dodecaedro es = " + ((Dodecaedro) poliedro).calcularArea());
        }

        if (poliedro instanceof Icosaedro) {
            System.out.println("El area del dodecaedro es = " + ((Icosaedro) poliedro).calcularArea());
        }
    }


    private static String solicitarColor() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduce el color \n " +
                "1.Amarillo 2.Azul 3.Blanco 4.Lila 5.Marron \n" +
                "6.Naranja 7.Negro 8.Rojo 9.Rosa 10.Verde");
        int numColor = sc.nextInt();

        switch (numColor) {

            case (1):
                return "Amarillo";

            case (2):
                return "Azul";

            case (3):
                return "Blanco";

            case (4):
                return "Lila";

            case (5):
                return "Naranja";

            case (6):
                return "Negro";

            case (7):
                return "Lila";

            case (8):
                return "Rojo";

            case (9):
                return "Rosa";

            case (10):
                return "Verde";

            default: return "Gris";

        }

    }

}



