
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
public class Adoptante extends Socio {
    //private Refugio r;
    List<Adopcion> adopciones;

    public Adoptante(Date date, Refugio r) {
        super(date,r);
        adopciones = new ArrayList<>();
        //this.r = super.getR();
    }

    public void adoptar(Animal a, Voluntario v) {
        v.tramitarAdopcion(a, this);
    }

    public void addAdopcion(Adopcion a){
        if (!adopciones.contains(a)) adopciones.add(a);
        else System.out.println("Este animal ya está adoptado");
    }

    public void removeAdopcion(Adopcion a){
        if (!adopciones.contains(a)) adopciones.add(a);
        else System.out.println("Este animal ya no está asociado al adoptante");
    }

    @Override
    public String toString() {
        return "Adoptante{}";
    }

    
}
