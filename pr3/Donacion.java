import java.util.*;
public class Donacion {

    private double cantidad;
    private Date fecha;
    private Donante donante;

    public Donacion (double cantidad, Date fecha, Donante donante){
            this.cantidad = cantidad;
            this.fecha = fecha;
            this.donante = donante;

    }

    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }

    public double getCantidad(){
        return cantidad;
    }

    public void setDate(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return fecha;
    }

}

