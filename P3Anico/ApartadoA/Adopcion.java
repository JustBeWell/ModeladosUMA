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

    public Adopcion(Animal a, Adoptante ad, Date fecha) {
        this.animal = a;
        this.adoptante = ad;
        this.fecha = fecha;
    }
    public Date getDate() {
        return this.fecha;
    }
    public Animal getAnimal(){
        return this.animal;
    }
    public Adoptante getAdoptante(){
        return this.adoptante;
    }
    @Override
    public String toString() {
        return String.format("Adopcion: %tY-%tB-%td, %s, %s", fecha, fecha, fecha, animal, adoptante);
    }
}
