
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        this.r = super.getR();
    }

    public void donar(Double amount){
        Donacion d = new Donacion(amount,new Date());
        donaciones.add(d);
        r.setLiquidez(r.getLiquidez() + amount);
        if(!r.getDonantes().contains(this)) r.añadirDonante(this);
        System.out.println(d.toString());
    }

    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
