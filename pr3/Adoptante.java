import java.util.Date;

public class Adoptante extends Socio{

    public Adoptante(int ID, String nombre, Date registro) {
        super(ID, nombre, registro);
    }

    public void adoptar(Animal a){
        
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