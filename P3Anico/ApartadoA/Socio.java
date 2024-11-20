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
    private Date date;
    private Refugio r;
    public Socio(Date date, Refugio r) {
        this.date = date;
        this.r = r;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Refugio getR() {
        return this.r;
    }
    
}
