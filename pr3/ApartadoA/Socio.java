

import java.util.Date;

public abstract class Socio {
    private int ID;
    private Date fecha;
    private final Refugio r;
    public Socio(int ID, Date fecha, Refugio r) {
        assert ID > 0 : "El ID del socio debe ser válido.";
        assert fecha != null : "La fecha de registro no puede ser nula.";
        this.ID = ID;
        this.fecha = fecha;
        this.r = r;
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
        return this.r;
    }
    
}
