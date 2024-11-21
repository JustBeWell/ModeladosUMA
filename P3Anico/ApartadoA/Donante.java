
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

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
    Refugio r;
    public Donante(Date date,Refugio r) {
        super(date,r);
        donaciones = new ArrayList<>();
        this.r = super.getRefugio();
    }

    public void donar(Double cantidad){
        Donacion d = new Donacion(cantidad,new Date());
        donaciones.add(d);
        r.setLiquidez(r.getLiquidez() + cantidad);
        if(!Collections.list(r.getDonantes()).contains(d)) r.addDonante(this);
    }

    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
