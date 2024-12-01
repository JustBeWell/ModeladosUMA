
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Donante extends Socio{
    private List<Donacion> donaciones;
    public Donante(int ID, Date date,Refugio r, Double cantidad) {
        super(ID,date,r);
        donaciones = new ArrayList<>();
        this.donar(cantidad);
    }

    public void donar(Double cantidad){
        assert cantidad > 0 : "La cantidad donada debe ser mayor a cero.";
        LocalDate fechaDonacion = LocalDate.now();
        Donacion d = new Donacion(cantidad, Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this);
        donaciones.add(d);
        Refugio r = super.getRefugio();
        r.setLiquidez(r.getLiquidez() + cantidad);
        if (!Collections.list(r.getDonantesEnRefugio()).contains(this)) r.addDonante(this);
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
