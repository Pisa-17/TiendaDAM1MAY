package es.cifplalaboral.eduardol.tienda;
import java.util.Comparator;

public class ComparaArticulosporUNIDADES implements Comparator<Articulo> {
    public int compare(Articulo a1, Articulo a2){
        return Double.compare(a2.getExistencias(), a1.getExistencias());
    }
}
