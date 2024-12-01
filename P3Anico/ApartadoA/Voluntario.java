import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Voluntario extends Socio{
    Set<Adopcion> tramites; //Considerar usar un sets
    public Voluntario(int ID, Date date,Refugio r) {
        super(ID, date,r);



        tramites = new HashSet<>();
    }
    public void tramitarAdopcion(Animal a, Adoptante ad){
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE : "El animal ya está adoptado.";
        assert ad != null : "El adoptante no puede ser nulo.";
        LocalDate fechaAdopcion = LocalDate.now();
        // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
        Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.addTramite(adopcion);
        ad.addAdopcion(adopcion);
    }
    public void registrar(Animal a){
        Refugio r = super.getRefugio();
        assert r != null : "El refugio asociado no puede ser nulo.";
        assert a != null : "El animal no puede ser nulo.";
        Enumeration<Animal> animales = r.getAnimalesRefugiados();

        // Un animal se añade al refugio con el estado disponible
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
        r.addAnimalesRefugiados(a);
    }
    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    public void addTramite(Adopcion ad){
        assert ad != null : "El trámite de adopción no puede ser nulo.";
        tramites.add(ad); //Explicar en la memoria que como queríamos evitar duplicados se ha utilizado directamente un hashSet

    }


    @Override
    public String toString() {
        return "Voluntario{}";
    }
}
