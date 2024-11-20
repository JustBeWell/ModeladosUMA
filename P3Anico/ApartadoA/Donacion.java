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

    public Donacion(Double cantidad, Date date) {
        this.cantidad = cantidad;
        this.date = date;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Date getDate() {
        return date;
    }
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
