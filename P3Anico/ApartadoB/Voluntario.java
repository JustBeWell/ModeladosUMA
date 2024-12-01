import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Voluntario{
    private Set<Adopcion> tramites; //Utilizamos un set para no permitir elementos repetidos
    private final Socio socio;
    //Contructor para un voluntario
    public Voluntario(Socio socio){
        this.socio = socio;
        tramites = new HashSet<>(); //Instanciamos con un hashset para que la busqueda tenga una eficiencia lineal
    }

    public Socio getSocio(){
        return this.socio;
    }

    //Metodo que simula el tramite de una adopcion en el sistema a partir de un animal a y un adoptante ad
    public void tramitarAdopcion(Animal a, Adoptante ad){
        //Comprobamos que los valores sean validos
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE : "El animal ya está adoptado.";
        assert ad != null : "El adoptante no puede ser nulo.";
        LocalDate fechaAdopcion = LocalDate.now();
        // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
        // Ahora usamos los atributos de socio tanto en las clases de Voluntario y de Adoptante
        Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant())); //Instanciamos una adopcion
        this.addTramite(adopcion);
        ad.addAdopcion(adopcion);
    }
    //Metodo que simula el registro de un animal en el sistema a paritr de un voluntario
    public void registrar(Animal a){
        //Obtenemos la instancia de la clase refugio asociada al Socio
        Refugio r = socio.getRefugio();
        //Comprobamos que los valores sean validos
        assert r != null : "El refugio asociado no puede ser nulo.";
        assert a != null : "El animal no puede ser nulo.";
        //Enumeration<Animal> animales = r.getAnimalesRefugiados();
        // Un animal se añade al refugio con el estado disponible
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
        r.addAnimalesRefugiados(a);
    }
    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    public void addTramite(Adopcion ad){
        assert ad != null : "El trámite de adopción no puede ser nulo.";
        tramites.add(ad); //Como estamos utilizando un HashSet no necesitamos comprobar que existan elementos repetidos
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tramites: ").append(tramites).append("\n");
        sb.append("Datos del voluntario: ").append(this.socio.toString()).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        return obj == socio || ((obj instanceof Socio) && ((Socio)obj).getID() == this.socio.getID());
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(socio.getID());
    }
}
