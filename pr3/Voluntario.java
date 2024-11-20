import java.util.*;

public class Voluntario extends Socio{
    public Voluntario(int ID, String nombre, Date registro) {
        super(ID, nombre, registro);
    }

    public void tramitarAdopcion(Animal a, Adoptante ad){
        
    }
    public void registrar(Animal a, Refugio r){
        
    }

    public void setID(int ID){
        super.setID(ID);
    }

    public int getID(){
         return super.getID();
    }

    public void setNombre(String nombre){
       super.setNombre(nombre);
    }

    public String getNombre(){
        return super.getNombre();
    }

    
}