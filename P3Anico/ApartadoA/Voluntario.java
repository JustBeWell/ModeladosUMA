import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Voluntario extends Socio{
    List<Adopcion> tramites;
    public Voluntario(int ID, Date date,Refugio r) {
        super(ID, date,r);
        tramites = new ArrayList<>();
    }
    public void tramitarAdopcion(Animal a, Adoptante ad){
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE : "El animal ya está adoptado.";
        LocalDate fechaAdopcion = LocalDate.now();
        // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
        Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.addTramite(adopcion);
        ad.addAdopcion(adopcion);
    }
    public void registrar(Animal a){
        Refugio r = super.getRefugio();
        Enumeration<Animal> animales = r.getAnimalesRefugiados();
        boolean encontrado = false;
        while (animales.hasMoreElements()) {
            if (animales.nextElement().equals(a)) {
                encontrado = true;
                break;
            }
        }
        assert !encontrado : "El animal ya está registrado en el refugio";
        // Un animal se añade al refugio con el estado disponible
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
        r.addAnimalesRefugiados(a);
    }
    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    public void addTramite(Adopcion ad){
        if(!tramites.contains(ad)){
            tramites.add(ad);
        } else System.out.println("Este voluntario ya ha realizado este trámite");
    }


    @Override
    public String toString() {
        return "Voluntario{}";
    }
}
