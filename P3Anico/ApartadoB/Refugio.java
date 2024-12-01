/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

public class Refugio {
    private String nombre;
    //Representa el capital financiero del refugio
    private double liquidez;
    //Lista para guardar a los animales registrados
    private Set<Animal> animalesRegistrados;
    //Lista para guardar los animales refugiados
    private Set<Animal> animalesRefugiados;
    // Lista para guardar a los adoptantes
    private Set<Socio> socios;

    public Refugio(String nombre, double liquidez) {
        //Comprobamos que la liquidez sea valida
        assert liquidez >= 0 : "La liquidez debe ser no negativa.";
        //assert a != null : "El refugio tiene que ser creado con un animal dentro";
        assert nombre != "" : "El nombre del refugio no puede estar vacío";
        //Asignamos un nombre al refugio
        this.nombre = nombre;
        //Asignamos las variables al refugio
        this.liquidez = liquidez;
        //Instanciamos las colecciones como hashset dado a que nos permite hacer una busqueda en tiempos de ejecucion lineales haciendo el sistema mas eficiente
        animalesRefugiados = new HashSet<>();
        animalesRegistrados = new HashSet<>();
        socios = new HashSet<>();
    }

    public String getNombre(){
        return this.nombre;
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
        socios.add(s); //Como es un set no necesitamos comprobar que existan elementos repetidos
    }

    public void removeSocio(Socio s) {
        assert s != null : "El socio no puede ser nulo.";
        if (socios.contains(s)) { //Comprobamos que previamente existe el socio en el sistema
            socios.remove(s);
        } else {
            System.out.println("Este socio no está registrado en el refugio.");
        }
    }

    /* CREACIÓN DE LAS LISTAS DE OBJETOS */

    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }
    public Enumeration<Socio> getSocios() {
        return Collections.enumeration(socios);
    }
    /* MÉTODOS PARA AÑADIR OBJETOS AL REFUGIO */
    public List<Adoptante> getAdoptantes() {
        List<Adoptante> adoptantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esAdoptante()) {
                adoptantes.add(s.getOperacionesAdoptante());
            }
        }
        return adoptantes;
    }

    public List<Voluntario> getVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esVoluntario()) {
                voluntarios.add(s.getOperacionesVoluntario());
            }
        }
        return voluntarios;
    }

    public List<Donante> getDonantes() {
        List<Donante> donantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esDonante()) {
                donantes.add(s.getOperacionesDonante(0.00)); // Este donante no va a donar nada, es solo para acceder al objeto
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
        animalesRegistrados.add(a);
    }

    /* MÉTODOS PARA ELIMINAR OBJETOS DEL REFUGIO */
    public void removeAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (animalesRefugiados.contains(a)) {
            animalesRefugiados.remove(a);
        } else {
            System.out.println("El animal ya fue eliminado de este refugio.");
        }
    }

    /* MÉTODOS AUXILIARES PARA MOSTRAR DATOS EN CONCRETO */
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
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Animales Registrados: ").append(animalesRegistrados).append("\n");
        sb.append("Animales Refugiados: ").append(animalesRefugiados).append("\n");
        sb.append("Socios: ").append(socios).append("\n");
        sb.append("Liquidez: ").append(liquidez);
        return sb.toString();
    }
}
