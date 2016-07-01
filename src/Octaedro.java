/**
 * Created by Dimple on 16/06/2016.
 */
public class Octaedro extends Poliedro
{
    public Octaedro (long id, String color, double arista)

    {
        super(id,color, arista);
    }

    @Override
    public double calcularVolumen()
    {
        return (Math.sqrt(2)/3)*(Math.pow(arista,3));
    }

    public double calcularArea()
    {
        return 2*Math.sqrt(3)*Math.pow(arista,2);
    }

    @Override
    public String toString()
    {
        return "Octaedro{" +
                "id=" +id+
                ",arista=" +arista +
                ",color=" +color+
                "}" + System.lineSeparator();
    }

}
