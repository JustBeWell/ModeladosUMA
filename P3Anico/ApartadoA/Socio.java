/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

public abstract class Socio { //Esta clase es la clase padre de voluntario adoptante y donante con el fin de que todas esas clases compartan tanto los mismos metodos como variables
    private int ID; //Identificador único del socio
    private Date fecha; //Fecha en la que se restristro
    private final Refugio refugioAsociado; //Es una variable final porque solo mantenemos una instancia de refugio

    public Socio(int ID, Date fecha, Refugio refugioAsociado) {
        //Comprobamos que todos los campos sean validos y no nulos
        assert ID > 0 : "El ID del socio debe ser válido.";
        assert fecha != null : "La fecha de registro no puede ser nula.";
        assert refugioAsociado != null : "El refugio asociado no puede ser nulo.";
        //Si son validos asignamos los datos a las variables de Socio
        this.ID = ID;
        this.fecha = fecha;
        this.refugioAsociado = refugioAsociado;
    }
    public int getID(){
        return ID;
    }
    private void setID(int ID){
        assert ID > 0;
        this.ID = ID;
    }
    public Date getDate() {
        return this.fecha;
    }
    public void setDate(Date fecha) {
        assert  fecha != null;
        this.fecha = fecha;
    }
    public Refugio getRefugio() {
        return this.refugioAsociado;
    }
    
}
