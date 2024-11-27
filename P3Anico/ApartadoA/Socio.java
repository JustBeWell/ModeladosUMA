/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */

import  java.util.Date;

public abstract class Socio {
    private int ID;        // Un socio se va a identificar a través de un ID
    private Date fecha;
    private final Refugio r;
    public Socio(int ID, Date fecha, Refugio r) {
        this.ID = ID;
        this.fecha = fecha;
        this.r = r;
    }
    public int getID(){ return ID;}
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
    
}
