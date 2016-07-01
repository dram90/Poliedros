/**
 * Created by Dimple on 17/06/2016.
 */
public class Icosaedro extends Poliedro {

    public Icosaedro(long id, String color, double arista) {
        super(id,color,arista);
    }

    @Override
    public double calcularVolumen() {
        return (5/12)*Math.pow(arista,3)*(3+Math.sqrt(5));
    }

    public double calcularArea(){
        return 5*Math.sqrt(3)*Math.pow(arista,2);
    }

    public String toString() {
        return "Icosaedro{" +
                "id="+id+
                ",arista="+arista+
                ",color=" +color+
                '}' + System.lineSeparator();
    }

}
