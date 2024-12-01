
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
public class Animal {
    private int ID;    // Identificaión
    private Date nacimiento; // Fecha del nacimiento del animal
    private EstadoAnimal estadoAnimal; // El estado en el que se encuentra el animal
    final private Refugio refugio; // Refugio donde está el animal o por el que ha pasado
    private Adopcion adopcion;   //

    public Animal(int ID, Date nacimiento, EstadoAnimal estadoAnimal,Refugio refugio, Adopcion adopcion) {
        this.ID = ID;
        this.nacimiento = nacimiento;
        this.estadoAnimal = estadoAnimal;
        this.refugio = refugio;
        //this.adopcion = adopcion;  Un animal no tiene porque estar adoptado del tirón
     }

    // Los getters para todos los atributos
    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public Refugio getRefugio() {
        return refugio;
    }
    public Adopcion getAdopcion() {
        return this.adopcion;
    }

    //Los setters para todos los atributos
    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    public void setAdopcion(Adopcion adopcion){
        this.adopcion = adopcion;
    }

    //public void setRefugio(Refugio refugio) {     this.refugio = refugio;   }
    @Override
    public String toString() {
        return String.format("Animal %d: { nacimiento: %tY-%tB-%td, estado: %s, refugio: %s, Adoptante: %s",
                this.ID,
                this.nacimiento,
                this.nacimiento,
                this.nacimiento,
                estadoAnimal.toString(),
                this.refugio.getNombre(),
                adopcion != null ? adopcion.getAdoptante().getSocio().getID() : " ");
    }

    
}
