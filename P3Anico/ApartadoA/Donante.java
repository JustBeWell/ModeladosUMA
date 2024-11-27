
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
public class Donante extends Socio{
    private List<Donacion> donaciones;
    public Donante(int ID, Date date,Refugio r, Double cantidad) {
        super(ID,date,r);
        donaciones = new ArrayList<>();
        this.donar(cantidad);
    }

    public void donar(Double cantidad){
        if(cantidad > 0) {
            LocalDate fechaDonacion = LocalDate.now();
            Donacion d = new Donacion(cantidad,  Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this);
            donaciones.add(d);
            Refugio r = super.getRefugio();
            r.setLiquidez(r.getLiquidez() + cantidad);
            if (!Collections.list(r.getDonantes()).contains(d)) r.addDonante(this);
        }else{
            System.out.println("La cantidad donada tiene que ser mayor que cero");
        }
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
