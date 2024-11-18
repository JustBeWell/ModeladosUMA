import java.util.*;

// Clase componente de Refugio
public class Animal{
    
    private int ID;
    private Date nacimiento;
    private EstadoAnimal estado;

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setNacimiento(Date nacimiento){
        this.nacimiento = nacimiento;
    }

    public Date getNacimiento(){
        return nacimiento;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return estado;
    }

}