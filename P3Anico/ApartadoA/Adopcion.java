/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
import java.util.Date;


public class Adopcion {
    private Date fecha;
    final private Animal animal;
    final private Adoptante adoptante;
    final private Voluntario voluntario;

    public Adopcion(Animal a, Adoptante ad, Voluntario v, Date fecha) {
        assert a != null : "El animal no puede ser nulo.";
        assert ad != null : "El adoptante no puede ser nulo.";
        assert v != null : "El voluntario no puede ser nulo.";
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE : "El animal debe estar disponible para adopción.";
        assert fecha != null && !fecha.after(new Date()) : "La fecha no puede ser nula ni estar en el futuro.";

        this.animal = a;
        this.adoptante = ad;
        this.voluntario = v;
        this.fecha = fecha;

        // Asegurar bidireccionalidad: Cada acción en esta clase repercute en las otras relacionadas
        a.setEstadoAnimal(EstadoAnimal.ADOPTADO);
        ad.addAdopcion(this);
        v.addTramite(this);
    }
    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha){
        assert fecha != null && !fecha.after(new Date()) : "La fecha no puede ser nula ni estar en el futuro";
        this.fecha = fecha;
    }
    public Animal getAnimal(){
        return this.animal;
    }
    public Voluntario getVoluntario(){
        return this.voluntario;
    }
    public Adoptante getAdoptante(){
        return this.adoptante;
    }
    

    @Override
    public boolean equals(Object obj) {
        if( this == obj ) return true;
        if(obj instanceof Adopcion ){
            Adopcion adopcion = (Adopcion) obj;
            boolean ok = this.adoptante.equals(adopcion.adoptante) && animal.equals(adopcion.animal);
            return ok;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return adoptante.hashCode() + animal.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Adopcion: %tY-%tB-%td, %s, %s", fecha, fecha, fecha, animal, adoptante);
    }
}
