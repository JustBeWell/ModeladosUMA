package sistema;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Voluntario {
    private Set<Adopcion> tramites; //Utilizamos un set para no permitir elementos repetidos
    private final Socio socio;
    //Contructor para un voluntario
    public Voluntario(Socio socio) {
         //Asignamos los valores a partir de la clase padre de la que heredado
        tramites = new HashSet<>(); //Instanciamos con un hashset para que la busqueda tenga una eficiencia lineal
        this.socio = socio;
    }
    //Metodo que simula el tramite de una adopcion en el sistema a partir de un animal a y un adoptante ad
    public void tramitarAdopcion(Animal a, Adoptante ad){
        //Comprobamos que los valores sean validos
        assert ad != null : "El adoptante no puede ser nulo.";
        LocalDate fechaAdopcion = LocalDate.now();
        // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
        Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant())); //Instanciamos una adopcion
        addTramite(adopcion);
        ad.addAdopcion(adopcion);
    }
    //Metodo que simula el registro de un animal en el sistema a paritr de un voluntario
    public void registrar(Animal a){
        //Como heredamos de la clase Socio, obtenemos el refugio a traves de el
        Refugio r = getSocio().getRefugio();
        //Comprobamos que los valores sean validos
        assert r != null : "El refugio asociado no puede ser nulo.";
        assert a != null : "El animal no puede ser nulo.";
        //assert !Collections.list(getRefugio().getAnimalesRefugiados()).contains(a); Al ser un set no hace falta
        // Un animal se añade al refugio con el estado disponible
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
        r.addAnimalesRefugiados(a); //No se llama al addAnimalesRegistrados, porque se ha decidido, debido a que al refugiar un animal en un refugio, este también debe quedar registrado, hacer que el méto do
        //  addAnimalesRegistrados sea un méto do privado que se llama al añadir un animal al refugio de forma automática.

    }
    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    protected void addTramite(Adopcion ad){
        assert ad != null : "El trámite de adopción no puede ser nulo.";
        tramites.add(ad); //Como estamos utilizando un HashSet no necesitamos comprobar que existan elementos repetidos

    }
    protected void removeTramite(Adopcion ad){
        assert  ad != null: "El trámite de adopción no puede ser nulo.";
        tramites.remove(ad);
    }

    public Socio getSocio() {
        return socio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj instanceof Voluntario ){
            Voluntario adoptante = (Voluntario) obj;
            return getSocio().getID() == this.getSocio().getID(); // Con que sea una instancia del tipo Adoptante y su socio asociado tenga el mismo ID se consideran el mismo objeto
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(getSocio().getID());
    }

    @Override
    public String toString() {
        return "Voluntario " + getSocio().getID();
    }
}
