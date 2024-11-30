/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Date;

/**
 *
 * @author byani
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Animal(1, new Date(), null, null, null);
        Animal b = new Animal(2, new Date(),null,null, null);
        Refugio r = new Refugio(0, a);
        Socio Pepe = new Socio(1, new Date(), r, true, true);
        Socio Mavi = new Socio(1, new Date(), r, false, true);
        Socio Tolo = new Socio(1, new Date(), r, true, false);
        Socio Paco = new Socio(1, new Date(), r, false, false);

        System.out.println(r.toString());
        System.out.println("///////// ------- ////////");
        Paco.donar(100.00);
        Pepe.adoptar(a, Pepe);
        System.out.println(r.toString());
        System.out.println(Pepe.esDonante());
        System.out.println("///////// ------- ////////");
        Mavi.donar(200.00);
        Pepe.registrar(b);
        Mavi.adoptar(b, Pepe);
        System.out.println(r.toString());
    }
}
