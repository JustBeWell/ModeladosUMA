
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Donante extends Socio{
    private Set<Donacion> donaciones; //Set?
    public Donante(int ID, Date date,Refugio r, Double cantidad) { //Se ha decidido meter la cantidad en el constructor, ya que es una condición necesaria y suficiente para ser donante.
        super(ID,date,r);
        assert cantidad > 0 : "La cantidad inicial donada debe ser mayor a cero.";


        donaciones = new HashSet<>(); //Se ha decicido utilizar un set en vez de una lista ya que no queremos donantes duplicados
        this.donar(cantidad);
    }

    public void donar(Double cantidad){
        assert cantidad > 0 : "La cantidad donada debe ser mayor a cero.";
        LocalDate fechaDonacion = LocalDate.now();
        Donacion d = new Donacion(cantidad, Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this);
        donaciones.add(d);
        Refugio r = super.getRefugio();
        assert r != null : "El refugio asociado no puede ser nulo.";
        r.setLiquidez(r.getLiquidez() + cantidad);
        r.addDonante(this);
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
