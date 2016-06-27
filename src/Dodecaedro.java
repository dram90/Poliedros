/**
 * Created by Dimple on 16/06/2016.
 */
public class Dodecaedro extends Poliedro {

    private double apotema;
    public Dodecaedro(long id, String color, double arista, double apotema)
    {
        super(id,color, arista);
        this.apotema = apotema;
    }

    public double calcularVolumen()
    {
        return (Math.pow(arista,3)*(15+(7*Math.sqrt(5))))/4;
    }

    public double calcularArea()
    {
        return 30*arista*apotema;
    }

    @Override
    public String toString() {
        return "Dodecaedro{" +
                "id="+id+
                ",arista="+arista+
                ",apotema=" + apotema +
                ",color=" +color+
                '}';
    }
}
