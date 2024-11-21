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
    private double liquidez;
    private List<Animal> animalesRegistrados;
    private List<Animal> animalesRefugiados;
    private List<Adoptante> adoptantes;
    private List<Voluntario> voluntarios;
    private List<Donante> donantes;
    public Refugio(double liquidez) {
        this.liquidez = liquidez;
        animalesRefugiados = new ArrayList<>();
        animalesRegistrados = new ArrayList<>();
        adoptantes = new ArrayList<>();
        voluntarios = new ArrayList<>();
        donantes = new ArrayList<>();
    }

    public double getLiquidez() {
        return liquidez;
    }
    
    public void setLiquidez(double liquidez) {
        this.liquidez = liquidez;
    }

    public Enumeration<Adoptante> getAdoptantes() {
        return Collections.enumeration(adoptantes);
    }

    public Enumeration<Voluntario> getVoluntarios() {
        return Collections.enumeration(voluntarios);
    }

    public Enumeration<Donante> getDonantes() {
        return Collections.enumeration(donantes);
    }
    
    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }

    public void registrar(Animal a){
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
    }
    public void addAdoptante(Adoptante a){
        adoptantes.add(a);
    }
    public void removeAddoptante(Adoptante a){
        if(adoptantes.contains(a))    adoptantes.remove(a);
        else System.out.println("El adoptante no está asociado al refugio");

    }
    public void addVoluntario(Voluntario v){
        if(!voluntarios.contains(v)) voluntarios.add(v);
        else System.out.println("El voluntario ya está asociado al refugio");
    }
    public void removeVoluntario(Voluntario v){
        if(voluntarios.contains(v))    adoptantes.remove(v);
        else System.out.println("El voluntario no está asociado al refugio");

    }
    public void addDonante(Donante d){
        if(!donantes.contains(d)) donantes.add(d);
        else System.out.println("Este donante ya está asociado al refugio");
    }
    public void removeDonante(Donante d){
        if(donantes.contains(d))    donantes.remove(d);
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
    public void addAnimalesRegistrados(Animal a){
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
