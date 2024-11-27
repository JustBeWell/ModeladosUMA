/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
import java.util.Date;
public class Donacion {
    private Double cantidad;
    private Date date;
    private final Donante donante;

    public Donacion(Double cantidad, Date date, Donante donante) {
        this.cantidad = cantidad;
        this.date = date;
        this.donante = donante;
    }

    public Double getCantidad() {
        return cantidad;
    }
    public Date getDate() {
        return date;
    }
    public Donante getDonante(){ return this.donante;}
    public void setDate(Date date) {
        this.date = date;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return "Donacion{" + "cantidad=" + cantidad + ", date=" + date + '}';
    }
}
