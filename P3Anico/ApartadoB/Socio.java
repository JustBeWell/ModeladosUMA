/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Socio {

    private int ID;  // Identificador único del socio
    private Date fecha; // La fecha en que fue registrado en el sistema
    private final Refugio r; // refugio al que está asociado

    private Donante donante;
    private Voluntario voluntario;
    private Adoptante adoptante;


    //Constructor de Socio. Al instanciar el objeto podemos elegir qué roles tiene. Lo podemos cambiar también de manera dinámica.
    public Socio(int ID, Date fecha, Refugio r) {
        this.ID = ID;
        this.fecha = fecha;
        this.r = r;
    }

    public int getID(){return ID;}
    private void setID(int ID){
        this.ID = ID;
    }
    public Date getDate() {
        return this.fecha;
    }
    public void setDate(Date fecha) {
        this.fecha = fecha;
    }
    public Refugio getRefugio() {
        return this.r;
    }

    // Métodos para consultar o cambiar los roles
    public boolean esDonante() {
        return this.donante != null;
    }
    private Donante createDonante() {
        this.donante = new Donante(this);
        return this.donante;
    }
    public boolean esVoluntario() {
        return this.voluntario != null;
    }
    private Voluntario createVoluntario() {
        this.voluntario = new Voluntario(this);
        return this.voluntario;
    }
    public boolean esAdoptante() {
        return adoptante != null;
    }
    private Adoptante createAdoptante(boolean esAdoptante) {
        this.adoptante = new Adoptante(this);
        return this.adoptante;
    }
    public Voluntario getOperacionesVoluntario(){
        return this.esVoluntario() ? this.voluntario : this.createVoluntario();
    }
    public Donante getOperacionesDonante(){
        return this.esDonante() ? this.donante : this.createDonante();
    }
    public Adoptante getOperacionesAdoptante(){
        return this.esAdoptante() ? this.adoptante : this.createAdoptante();
    }

    @Override
    public String toString(){
        return String.format("registrado= %tY-%tB-%td", this.fecha, this.fecha, this.fecha);
    }
}