
import java.util.*;

public class Adoptante {
    private Set<Adopcion> adopciones; //Para poder guardar las Adopciones en un adoptante hemos decidido utilizar un set para no permitir elementos repetidos en los datos del sistema
    private final Socio socio;  // El socio que desempeña el rol del Adoptante
    //Constructor para un adoptante
    public Adoptante(Socio socio) {
        adopciones = new HashSet<>(); //Por terminos de eficiencia en ejecucion utilizamos Hashset que permiten el accesso en tiempo O(1)
        this.socio = socio;
    }

    public Socio getSocio(){
        return this.socio;
    }

    //Metodo que simula una adopcion en el sistema a partir de un voluntario y un animal
    public void adoptar(Animal a, Voluntario v) {
        //Comprobamos si previamente el animal a ya se encontraba adoptado en el sistema
        assert !adopciones.stream().anyMatch(ad -> ad.getAnimal().equals(a)) : "El adoptante ya tiene registrado este animal";
        //Si no, se tramita la adopcion
        v.tramitarAdopcion(a, this);
    }

    public void addAdopcion(Adopcion a){
        this.adopciones.add(a); //En caso de que ya exista la adopción directamente no se insertará
    }

    public void removeAdopcion(Adopcion a){
        if (adopciones.contains(a)) adopciones.remove(a); //Comprobamos si previamente el animal a ya se encontraba en el sistema
        System.out.println("Este animal ya no está asociado al adoptante");
    }
    public Enumeration<Adopcion> getAdopciones(){
        return Collections.enumeration(adopciones);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adopciones: ").append(this.adopciones).append("\n");
        sb.append("Datos del adoptante: ").append(this.socio).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Socio && ((Socio) obj).getID() == this.socio.getID());
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(socio.getID());
    }
}
