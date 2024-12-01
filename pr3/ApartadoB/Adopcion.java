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
    final private Socio adoptante;
    final private Socio voluntario;

    public Adopcion(Animal a, Socio ad, Socio voluntario, Date fecha) {
        this.animal = a;
        this.adoptante = ad;
        this.voluntario = voluntario;
        this.fecha = fecha;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public Animal getAnimal(){
        return this.animal;
    }
    public Socio getVoluntario(){
        return this.voluntario;
    }
    public Socio getAdoptante(){
        return this.adoptante;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return String.format("Adopcion: %tY-%tB-%td, %s, %s", fecha, fecha, fecha, animal, adoptante);
    }
}
