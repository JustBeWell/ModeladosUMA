import java.time.ZoneId;
import java.util.*;
import java.time.*;

public class Donante extends Socio{

    private List<Donacion> donaciones = new LinkedList<Donacion>();

    public Enumeration<Donacion> getDonacion(){
        return Collections.enumeration(donaciones);
    }

    public void addDonacion (Donacion d){
        donaciones.add(d);
    }

    public void removeDonacion (Donacion d){
        donaciones.remove(d);
    }

    public Donante(int ID, String nombre, Date registro) {
        super(ID, nombre, registro);
    }

    public void donar (double cantidad){
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zoneDateTime = localDate.atStartOfDay(zoneId);

        Donacion d = new Donacion (cantidad, Date.from(zoneDateTime.toInstant()), this);

        this.addDonacion(d);
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