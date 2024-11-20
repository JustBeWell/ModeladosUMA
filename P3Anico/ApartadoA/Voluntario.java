
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
public class Voluntario extends Socio{
    private Refugio r;
    public Voluntario(Date date,Refugio r) {
        super(date,r);
        this.r = super.getR();
    }

    public void tramitarAdopcion(Animal a, Adoptante ad){
        if(!r.getAnimalesRegistrados().contains(a)){
            registrar(a);
            if(!r.getAdoptantes().contains(ad)) r.añadirAdoptante(ad);
            r.añadirAnimalesRefugiados(a);
        }
    }

    public void registrar(Animal a){
        if(!r.getAnimalesRegistrados().contains(a)){
            r.registrar(a);
            a.setRefugio(r);
            if(!(r.getVoluntarios().contains(this))) r.añadirVoluntario(this);
            r.añadirAnimalesRegistrados(a);
        }
    }

    @Override
    public String toString() {
        return "Voluntario{}";
    }
}
