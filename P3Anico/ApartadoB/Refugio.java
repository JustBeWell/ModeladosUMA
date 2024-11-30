/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author byani
 */
public class Refugio {
    //Guarda la cantidad total de los animales
    private double liquidez;
    //Lista para guardar a los animales registrados
    private List<Animal> animalesRegistrados;
    //Lista para guardar los animales refugiados
    private List<Animal> animalesRefugiados;
    // Lista para guardar a los adoptantes
    private List<Socio> adoptantes;
    // Lista para guardar a los voluntarios
    private List<Socio> voluntarios;
    //Lista para guardar a los donantes
    private List<Socio> donantes;

    public Refugio(double liquidez, Animal a) {
        this.liquidez = liquidez;
        animalesRefugiados = new ArrayList<>();
        animalesRegistrados = new ArrayList<>();
        adoptantes = new ArrayList<>();
        voluntarios = new ArrayList<>();
        donantes = new ArrayList<>();

        //Añadimos un animal a la lista de los registrados.
        registrar(a);

        //Añadimos un animal a la lista de los refugiados

    }

    public double getLiquidez() {
        return liquidez;
    }
    
    public void setLiquidez(double liquidez) {
        this.liquidez = liquidez;
    }

    public Enumeration<Socio> getAdoptantes() {return Collections.enumeration(adoptantes);}

    public Enumeration<Socio> getVoluntarios() {
        return Collections.enumeration(voluntarios);
    }

    public Enumeration<Socio> getDonantes() {
        return Collections.enumeration(donantes);
    }
    
    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }

    public void registrar(Animal a){
        this.addAnimalesRegistrados(a);
    }

    public void addAdoptante(Socio a){
        if(a.esAdoptante() && !adoptantes.contains(a)){
            adoptantes.add(a);
        }
    }

    public void removeAdoptante(Socio a){
        if(a.esAdoptante() && adoptantes.contains(a))    adoptantes.remove(a);
        else System.out.println("El socio no está asociado al refugio");

    }
    public void addVoluntario(Socio v){
        if(v.esVoluntario() && !voluntarios.contains(v)) voluntarios.add(v);
        else System.out.println("El voluntario ya está asociado al refugio");
    }
    public void removeVoluntario(Socio v){
        if(v.esVoluntario() && voluntarios.contains(v))    adoptantes.remove(v);
        else System.out.println("El voluntario no está asociado al refugio");
    }
    public void addDonante(Socio d){
        if(d.esDonante() && !donantes.contains(d) && d.esDonante()) donantes.add(d);
        else System.out.println("Este donante ya está asociado al refugio");
    }
    public void removeDonante(Socio d){
        if(d.esDonante() && donantes.contains(d))    donantes.remove(d);
        else System.out.println("Este donante no ha realizado ninguna doncación al refugio");
    }
    public void addAnimalesRefugiados(Animal a){
        if(!animalesRefugiados.contains(a)){
            animalesRefugiados.add(a);
            this.addAnimalesRegistrados(a);
        }else System.out.println("Este animal ya está refugiado");
    }
    public void removeAnimalesRefugiados(Animal a){
        if(animalesRefugiados.contains(a))    animalesRefugiados.remove(a);
        else System.out.println("Este animal no está refugiado");
    }
    private void addAnimalesRegistrados(Animal a){
        animalesRegistrados.add(a);
    }
//    public void removeAnimalesRegistrados(Animal a){
//        if(animalesRegistrados.contains(a))    animalesRegistrados.remove(a);
//        else System.out.println("Este animal no está refugiado");
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animales Registrados: ").append(animalesRegistrados).append("\n");
        sb.append("Animales Refugiados: ").append(animalesRefugiados).append("\n");
        sb.append("Adoptantes: ").append(adoptantes).append("\n");
        sb.append("Voluntarios: ").append(voluntarios).append("\n");
        sb.append("Donantes: ").append(donantes).append("\n");
        sb.append("Liquidez: ").append(liquidez);
        return sb.toString();
    }

    public void mostrarAdoptantes(){
        System.out.println(adoptantes.toString());
    }

    public void mostrarVoluntarios(){
        System.out.println(voluntarios.toString());
    }

    public void mostrarDonantes(){
        System.out.println(donantes.toString());
    }
}
