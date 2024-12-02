package sistema; /**
 *
 * @author byani
 */
import java.util.Date;
import java.util.Objects;

public class Donacion {
    private float cantidad;
    private Date date;
    //Constructor para la clase Donacion
    public Donacion(float cantidad, Date date) {
        //Comprobamos que todos los datos sean validos y no nulos
        assert  cantidad > 0 : "La cantidad debe ser positiva.";
        assert date != null && !date.after(new Date()) : "La fecha no puede ser nula ni estar en el futuro.";

        //Si todos los datos son correctos asignamos los valores a la donacion
        this.cantidad = cantidad;
        this.date = date;
    }

    public float getCantidad() {
        assert cantidad > 0 : "La cantidad no puede ser nula.";
        return cantidad;
    }
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public Date getDate() {
        assert date != null : "La fecha no puede ser nula.";
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return String.format("Donacion: %.2f, %tY-%tB-%td", cantidad, date, date, date);
    }

    //Se redefine porque está en un set (el de Donante)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donacion donacion = (Donacion) o;
        return Float.compare(cantidad, donacion.cantidad) == 0 && Objects.equals(date, donacion.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, date);
    }
}
