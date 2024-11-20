
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
public class Adoptante extends Socio {
    private Refugio r;
    public Adoptante(Date date, Refugio r) {
        super(date,r);
        this.r = super.getR();
    }

    public void adoptar(Animal a, Voluntario v) {
        v.tramitarAdopcion(a, this);
    }

    @Override
    public String toString() {
        return "Adoptante{}";
    }

    
}
