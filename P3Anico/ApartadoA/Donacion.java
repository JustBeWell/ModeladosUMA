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
    //Constructor para la clase Donacion
    public Donacion(Double cantidad, Date date, Donante donante) {
        //Comprobamos que todos los datos sean validos y no nulos
        assert cantidad != null && cantidad > 0 : "La cantidad debe ser positiva.";
        assert date != null && !date.after(new Date()) : "La fecha no puede ser nula ni estar en el futuro.";
        assert donante != null : "El donante no puede ser nulo.";
        //Si todos los datos son correctos asignamos los valores a la donacion
        this.cantidad = cantidad;
        this.date = date;
        this.donante = donante;
    }

    public Double getCantidad() {
        assert cantidad != null && cantidad > 0 : "La cantidad no puede ser nula.";
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Date getDate() {
        assert date != null : "La fecha no puede ser nula.";
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Donante getDonante(){
        return this.donante;
    }
    @Override
    public String toString() {
        return String.format("Donacion: %.2f, %tY-%tB-%td", cantidad, date, date, date);
    }
}
