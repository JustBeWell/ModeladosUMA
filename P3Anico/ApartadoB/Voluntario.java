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
    public Voluntario(int ID, Date date,Refugio r) {
        super(ID, date,r);
        tramites = new ArrayList<>();
    }
    public void tramitarAdopcion(Animal a, Adoptante ad){
         LocalDate fechaAdopcion = LocalDate.now();
         // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
         Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
         this.addTramite(adopcion);
         ad.addAdopcion(adopcion);
    }
    public void registrar(Animal a){
            Refugio r = super.getRefugio();
            // Un animal se añade al refugio con el estado disponible
            a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
            r.addAnimalesRefugiados(a);
    }
    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    private void addTramite(Adopcion d){
        if(!tramites.contains(d)){
            tramites.add(d);
        }else System.out.println("Este voluntario ya ha realizado este trámite");
    }
    /*public void removeTramite(Adopcion d){
        if(tramites.contains(d))    tramites.remove(d);
        else System.out.println("Este voluntario no ha realizado este trámite");
    }

     */

    @Override
    public String toString() {
        return "Voluntario{}";
    }
}
