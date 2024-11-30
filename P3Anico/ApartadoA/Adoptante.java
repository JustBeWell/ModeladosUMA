
import java.util.*;

public class Adoptante extends Socio {
    List<Adopcion> adopciones;

    public Adoptante(int ID, Date date, Refugio r) {
        super(ID, date,r);
        adopciones = new ArrayList<>();
    }

    public void adoptar(Animal a, Voluntario v) {
        assert !adopciones.stream().anyMatch(ad -> ad.getAnimal().equals(a)) : "El adoptante ya tiene registrado este animal";
        v.tramitarAdopcion(a, this);
    }

    public void addAdopcion(Adopcion a){
        if (!adopciones.contains(a)) adopciones.add(a);
        else System.out.println("Este animal ya está adoptado");
    }

    public void removeAdopcion(Adopcion a){
        if (!adopciones.contains(a)) adopciones.add(a);
        else System.out.println("Este animal ya no está asociado al adoptante");
    }
    public Enumeration<Adopcion> getAdopciones(){
        return Collections.enumeration(adopciones);
    }

    @Override
    public String toString() {
        return "Adoptante{}";
    }

    
}
