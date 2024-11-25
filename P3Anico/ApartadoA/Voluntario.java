import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author byani
 */
public class Voluntario extends Socio{
    List<Adopcion> tramites;
    public Voluntario(Date date,Refugio r) {
        super(date,r);
        tramites = new ArrayList<>();
    }
    public void tramitarAdopcion(Animal a, Adoptante ad){

         LocalDate fechaAdopcion = LocalDate.now();
         // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
         Adopcion adopcion = new Adopcion(a, ad, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
         tramites.add(adopcion);
         ad.addAdopcion(adopcion);
    }
    public void registrar(Animal a){
            Refugio r = super.getRefugio();
            // Un animal se añade al refugio con el estado disponible
            a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
            r.addAnimalesRefugiados(a);
    }
    @Override
    public String toString() {
        return "Voluntario{}";
    }
}
