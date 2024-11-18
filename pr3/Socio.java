import java.util.*;

abstract class Socio {
    private int ID;
    private String nombre;
    private Date registro;

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDate(Date registro){
        this.registro = registro;
    }

    public Date getRegistro(){
        return registro;
    }
}