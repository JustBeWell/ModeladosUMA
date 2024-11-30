/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Refugio {
    // Representa el capital financiero del refugio
    private double liquidez;
    //Lista para guardar a los animales registrados
    private List<Animal> animalesRegistrados;
    //Lista para guardar los animales refugiados
    private List<Animal> animalesRefugiados;
    // Lista para guardar a los adoptantes
    private List<Adoptante> adoptantesEnRefugio;
    // Lista para guardar a los voluntarios
    private List<Voluntario> voluntariosEnRefugio;
    //Lista para guardar a los donantes
    private List<Donante> donantesEnRefugio;

    public Refugio(double liquidez) {
        assert liquidez >= 0 : "La liquidez debe ser no negativa.";

        this.liquidez = liquidez;
        animalesRefugiados = new ArrayList<>();
        animalesRegistrados = new ArrayList<>();
        adoptantesEnRefugio = new ArrayList<>();
        voluntariosEnRefugio = new ArrayList<>();
        donantesEnRefugio = new ArrayList<>();
    }

    public double getLiquidez() {
        return liquidez;
    }
    public void setLiquidez(double liquidez) {
        assert liquidez >= 0 : "La liquidez debe ser no negativa";
        this.liquidez = liquidez;
    }

    /** CREACIÓN DE LAS LISTAS DE OBJETOS */

    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }
    public Enumeration<Adoptante> getAdoptantesEnRefugio() {
        return Collections.enumeration(adoptantesEnRefugio);
    }
    public Enumeration<Voluntario> getVoluntariosEnRefugio() {
        return Collections.enumeration(voluntariosEnRefugio);
    }
    public Enumeration<Donante> getDonantesEnRefugio() {
        return Collections.enumeration(donantesEnRefugio);
    }

    /** MÉTODOS PARA AÑADIR OBJETOS AL REFUGIO */

    /*
     * Este método no lo veo necesario ya que la función la cumple addAnimalesRegistrados
    public void registrar(Animal a){
        this.addAnimalesRegistrados(a);
    }
    */

    public void addAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if(!animalesRefugiados.contains(a)){
            animalesRefugiados.add(a);
            this.addAnimalesRegistrados(a);
        } else System.out.println("Este animal ya está refugiado.");
    }

    private void addAnimalesRegistrados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (!animalesRegistrados.contains(a)) {
            animalesRegistrados.add(a);
        } else {
            System.out.println("El animal ya está registrado.");
        }
    }
    public void addAdoptante(Adoptante a){
        assert a != null : "El adoptante no puede ser nulo.";
        if (!adoptantesEnRefugio.contains(a)) {
            adoptantesEnRefugio.add(a);
        } else {
            System.out.println("El adoptante ya está registrado.");
        }
    }
    public void addVoluntario(Voluntario v){
        assert v != null : "El voluntario no puede ser nulo.";
        if (!voluntariosEnRefugio.contains(v)) {
            voluntariosEnRefugio.add(v);
        } else {
            System.out.println("El voluntario ya está registrado.");
        }
    }
    public void addDonante(Donante d){
        assert d != null : "El donante no puede ser nulo.";
        if (!donantesEnRefugio.contains(d)) {
            donantesEnRefugio.add(d);
        } else {
            System.out.println("El donante ya está registrado.");
        }
    }

    /** MÉTODOS PARA ELIMINAR OBJETOS DEL REFUGIO */

    public void removeAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (animalesRefugiados.contains(a)) {
            animalesRefugiados.remove(a);
        } else {
            System.out.println("El animal ya fue eliminado de este refugio.");
        }
    }
    public void removeAddoptante(Adoptante a){
        assert a != null : "El adoptante no puede ser nulo.";
        if (adoptantesEnRefugio.contains(a)) {
            adoptantesEnRefugio.remove(a);
        } else {
            System.out.println("Este adoptante no está registrado en el refugio.");
        }
    }
    public void removeVoluntario(Voluntario v){
        assert v != null : "El voluntario no puede ser nulo.";
        if (voluntariosEnRefugio.contains(v)) {
            voluntariosEnRefugio.remove(v);
        } else {
            System.out.println("Este voluntario ya no está registrado en el refugio.");
        }
    }
    public void removeDonante(Donante d){
        assert d != null : "El donante no puede ser nulo.";
        if (donantesEnRefugio.contains(d)) {
            donantesEnRefugio.remove(d);
        } else {
            System.out.println("Este donante ya no está registrado en este refugio.");
        }
    }

    /** MÉTODOS AUXILIARES PARA MOSTRAR DATOS EN CONCRETO */
    public void mostrarAnimalesRefugiados(){
        System.out.println(animalesRefugiados.toString());
    }
    public void mostrarAnimalesRegistrados(){
        System.out.println(animalesRegistrados.toString());
    }
    public void mostrarAdoptantes(){
        System.out.println(adoptantesEnRefugio.toString());
    }
    public void mostrarVoluntarios(){
        System.out.println(voluntariosEnRefugio.toString());
    }
    public void mostrarDonantes(){
        System.out.println(donantesEnRefugio.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animales Registrados: ").append(animalesRegistrados).append("\n");
        sb.append("Animales Refugiados: ").append(animalesRefugiados).append("\n");
        sb.append("Adoptantes: ").append(adoptantesEnRefugio).append("\n");
        sb.append("Voluntarios: ").append(voluntariosEnRefugio).append("\n");
        sb.append("Donantes: ").append(donantesEnRefugio).append("\n");
        sb.append("Liquidez: ").append(liquidez);
        return sb.toString();
    }
}
