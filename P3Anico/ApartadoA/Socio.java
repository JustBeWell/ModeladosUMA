/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Collections;
import java.util.Date;

public abstract class Socio {
    private int ID; //Identificador único del socio
    private Date fecha; //Fecha en la que se restristro
    private final Refugio refugioAsociado;
    public Socio(int ID, Date fecha, Refugio refugioAsociado) {
        assert ID > 0 : "El ID del socio debe ser válido.";
        assert fecha != null : "La fecha de registro no puede ser nula.";
        assert refugioAsociado != null : "El refugio asociado no puede ser nulo.";
        assert !Collections.list(refugioAsociado.getDonantesEnRefugio()).contains(this) : "El donante ya está registrado en el refugio.";
        this.ID = ID;
        this.fecha = fecha;
        this.refugioAsociado = refugioAsociado;
    }
    public int getID(){
        return ID;
    }
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
        return this.refugioAsociado;
    }
    
}
