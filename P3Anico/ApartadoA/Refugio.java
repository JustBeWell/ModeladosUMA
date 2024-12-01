/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

public class Refugio {
    // Representa el capital financiero del refugio
    private double liquidez;
    //Lista para guardar a los animales registrados
    private Set<Animal> animalesRegistrados;
    //Lista para guardar los animales refugiados
    private Set<Animal> animalesRefugiados;
    // Lista para guardar a los adoptantes
    private Set<Socio> socios;
    public Refugio(double liquidez) {
        assert liquidez >= 0 : "La liquidez debe ser no negativa.";

        this.liquidez = liquidez;
        animalesRefugiados = new HashSet<>();
        animalesRegistrados = new HashSet<>();
        socios = new HashSet<>();

    }

    public double getLiquidez() {
        return liquidez;
    }
    public void setLiquidez(double liquidez) {
        assert liquidez >= 0 : "La liquidez debe ser no negativa";
        this.liquidez = liquidez;
    }
    public void addSocio(Socio s) {
        assert s != null : "El socio no puede ser nulo.";
            socios.add(s);

    }

    public void removeSocio(Socio s) {
        assert s != null : "El socio no puede ser nulo.";
        if (socios.contains(s)) {
            socios.remove(s);
        } else {
            System.out.println("Este socio no está registrado en el refugio.");
        }
    }

    /** CREACIÓN DE LAS LISTAS DE OBJETOS */

    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }
    public Enumeration<Socio> getSocios() {
        return Collections.enumeration(socios);
    }
    /** MÉTODOS PARA AÑADIR OBJETOS AL REFUGIO */
    public List<Adoptante> getAdoptantes() {
        List<Adoptante> adoptantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s instanceof Adoptante) {
                adoptantes.add((Adoptante) s);
            }
        }
        return adoptantes;
    }

    public List<Voluntario> getVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        for (Socio s : socios) {
            if (s instanceof Voluntario) {
                voluntarios.add((Voluntario) s);
            }
        }
        return voluntarios;
    }

    public List<Donante> getDonantes() {
        List<Donante> donantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s instanceof Donante) {
                donantes.add((Donante) s);
            }
        }
        return donantes;
    }

    public void registrar(Animal a){
        this.addAnimalesRegistrados(a);
    }


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


    /** MÉTODOS PARA ELIMINAR OBJETOS DEL REFUGIO */

    public void removeAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (animalesRefugiados.contains(a)) {
            animalesRefugiados.remove(a);
        } else {
            System.out.println("El animal ya fue eliminado de este refugio.");
        }
    }


    /** MÉTODOS AUXILIARES PARA MOSTRAR DATOS EN CONCRETO */
    public void mostrarAnimalesRefugiados(){
        System.out.println(animalesRefugiados.toString());
    }
    public void mostrarAnimalesRegistrados(){
        System.out.println(animalesRegistrados.toString());
    }
    public void mostrarSocios() {
        for (Socio s : socios) {
            System.out.println(s);
        }
    }

    public void mostrarSociosPorTipo() {
        System.out.println("Adoptantes: " + getAdoptantes());
        System.out.println("Voluntarios: " + getVoluntarios());
        System.out.println("Donantes: " + getDonantes());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animales Registrados: ").append(animalesRegistrados).append("\n");
        sb.append("Animales Refugiados: ").append(animalesRefugiados).append("\n");
        sb.append("Socios: ").append(socios).append("\n");
        sb.append("Liquidez: ").append(liquidez);
        return sb.toString();
    }
}
