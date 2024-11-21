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
    private Date fecha;
    private Refugio r;
    public Socio(Date fecha, Refugio r) {
        this.fecha = fecha;
        this.r = r;
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
