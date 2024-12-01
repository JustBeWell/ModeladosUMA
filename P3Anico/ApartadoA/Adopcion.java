/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
import java.util.Collections;
import java.util.Date;


public class Adopcion {
    //Variables que va a contener una adopcion
    private Date fecha;
    final private Animal animal;
    final private Adoptante adoptante;
    final private Voluntario voluntario;

    //Constructor para una adopcion
    public Adopcion(Animal a, Adoptante ad, Voluntario v, Date fecha) {
        // Asegurar que los parámetros no son nulos y que los datos son válidos
        assert a != null : "El animal no puede ser nulo."; 
        assert ad != null : "El adoptante no puede ser nulo.";
        assert v != null : "El voluntario no puede ser nulo.";
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE : "El animal debe estar disponible para adopción.";
        assert fecha != null && !fecha.after(new Date()) : "La fecha no puede ser nula ni estar en el futuro.";
        //Tras las comprobaciones asignamos a los valores de nuestro objetos los valores previamente comprobados
        this.animal = a;
        this.adoptante = ad;
        this.voluntario = v;
        this.fecha = fecha;

        // Asegurar bidireccionalidad: Cada acción en esta clase repercute en las otras relacionadas
        // Actualiza el estado del animal
        a.setEstadoAnimal(EstadoAnimal.ADOPTADO);

        // Añade esta adopción a las estructuras de las otras clases
        ad.addAdopcion(this);
        assert Collections.list(ad.getAdopciones()).contains(this) : "La adopción no fue añadida correctamente al adoptante.";

        v.addTramite(this);
        assert Collections.list(v.getTramites()).contains(this) : "La adopción no fue añadida correctamente al voluntario.";

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
    
    //Metodo para comprobar que dos adopciones sean iguales
        //Dos adopciones se consideran iguales si y solo si sus adoptantes y animales asociados son los mismos
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
