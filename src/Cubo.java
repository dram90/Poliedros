/**
 * Created by Dimple on 16/06/2016.
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class Cubo extends Poliedro {


    public Cubo (long id, String color, double arista)

    {
        super(id,color, arista);
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(arista,3);
    }

    public double calcularDiagonal()
    {
        return Math.sqrt(3)*arista;
    }

    public double calcularAreaLateral()
    {
        return 4*Math.pow(arista,2);
    }


    public double calcularAreaTotal()
    {
        return 6*Math.pow(arista,2);
    }

    @Override
    public String toString()
    {
        return "Cubo{" +
                "id=" +id+
                ",arista=" +arista +
                ",color=" +color+
                "}" +System.lineSeparator();
    }


}
