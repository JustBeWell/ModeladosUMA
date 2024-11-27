
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
    private Date nacimiento;
    private EstadoAnimal estadoAnimal;
    final private Refugio refugio;
    private Adopcion adopcion;

    public Animal(int ID, Date nacimiento, EstadoAnimal estadoAnimal,Refugio refugio, Adopcion adopcion) {
        this.ID = ID;
        this.nacimiento = nacimiento;
        this.estadoAnimal = estadoAnimal;
        this.refugio = refugio;
        this.adopcion = adopcion;
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
        return "Animal{" + "nacimiento=" + nacimiento + ", estadoAnimal=" + estadoAnimal + '}';
    }

    
}
