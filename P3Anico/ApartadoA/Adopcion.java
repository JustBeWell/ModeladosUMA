/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */
import java.util.Date;
public class Adopcion {
    private Date date;

    public Adopcion(Date date) {
        this.date = date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Adopcion{" + date + "}";
    }
}
