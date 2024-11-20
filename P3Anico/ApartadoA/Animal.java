
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
    private Date nacimiento;
    private EstadoAnimal estadoAnimal;
    private Refugio refugio;
    public Animal(Date nacimiento, EstadoAnimal estadoAnimal,Refugio refugio) {
        this.nacimiento = nacimiento;
        this.estadoAnimal = estadoAnimal;
        this.refugio = refugio;
    }
    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    public Refugio getRefugio() {
        return refugio;
    }
    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }
    @Override
    public String toString() {
        return "Animal{" + "nacimiento=" + nacimiento + ", estadoAnimal=" + estadoAnimal + '}';
    }

    
}
