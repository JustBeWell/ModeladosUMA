
import java.util.*;

public class Adoptante extends Socio {
    private Set<Adopcion> adopciones;

    public Adoptante(int ID, Date date, Refugio r) {
        super(ID, date,r);
        adopciones = new HashSet<>();

    }

    public void adoptar(Animal a, Voluntario v) {
        assert !adopciones.stream().anyMatch(ad -> ad.getAnimal().equals(a)) : "El adoptante ya tiene registrado este animal";
        v.tramitarAdopcion(a, this);
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a); //En caso de que ya exista la adopción directamente no se insertará

    }

    public void removeAdopcion(Adopcion a){
        if (adopciones.contains(a)) adopciones.remove(a);
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
