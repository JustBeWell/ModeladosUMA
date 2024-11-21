
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
    List<Animal> animales;

    public Adoptante(Date date, Refugio r) {
        super(date,r);
        animales = new ArrayList<>();
        //this.r = super.getR();
    }

    public void adoptar(Animal a, Voluntario v) {
        v.tramitarAdopcion(a, this);
    }

    public void addAnimal(Animal a){
        if (!animales.contains(a)) animales.add(a);
        else System.out.println("Este animal ya está adoptado");
    }

    public void removeAnimal(Animal a){
        if (!animales.contains(a)) animales.add(a);
        else System.out.println("Este animal ya no está asociado al adoptante");
    }

    @Override
    public String toString() {
        return "Adoptante{}";
    }

    
}
