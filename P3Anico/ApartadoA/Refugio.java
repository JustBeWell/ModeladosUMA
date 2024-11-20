/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
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

    public List<Adoptante> getAdoptantes() {
        return adoptantes;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public List<Donante> getDonantes() {
        return donantes;
    }
    
    public List<Animal> getAnimalesRegistrados() {
        return animalesRegistrados;
    }

    public void registrar(Animal a){
        a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
    }
    public void añadirAdoptante(Adoptante a){
        adoptantes.add(a);
    }
    public void añadirVoluntario(Voluntario v){
        voluntarios.add(v);
    }
    public void añadirDonante(Donante d){
        donantes.add(d);
    }
    public void añadirAnimalesRefugiados(Animal a){
        animalesRefugiados.add(a);
    }
    public void añadirAnimalesRegistrados(Animal a){
        animalesRegistrados.add(a);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnimalesRegistrados: ").append(animalesRegistrados).append("\n");
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
