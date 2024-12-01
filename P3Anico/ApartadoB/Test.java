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
        Refugio r = new Refugio("Refugio 1", 0);
        Animal a = new Animal(1, new Date(), EstadoAnimal.DISPONIBLE, r, null);
        Animal b = new Animal(2, new Date(),EstadoAnimal.DISPONIBLE, r, null);
        Socio Pepe = new Socio(1, new Date(), r);
        Socio Mavi = new Socio(2, new Date(), r);
        Socio Tolo = new Socio(3, new Date(), r);
        Socio Paco = new Socio(4, new Date(), r);

        System.out.println(r.toString());
        System.out.println("///////// ------- ////////");
        Paco.getOperacionesDonante(100.00);
        Pepe.getOperacionesAdoptante().adoptar(a, Pepe.getOperacionesVoluntario());
        System.out.println(r.toString());
        System.out.println(Pepe.esDonante());
        System.out.println("///////// ------- ////////");
        Mavi.getOperacionesDonante(0.00).donar(200.00);
        Pepe.getOperacionesVoluntario().registrar(b);
        Mavi.getOperacionesAdoptante().adoptar(b, Pepe.getOperacionesVoluntario());
        System.out.println(r.toString());
    }
}
