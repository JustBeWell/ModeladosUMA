package sistema;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Collections;
import java.util.Date;

public abstract class Socio { //Esta clase es la clase padre de voluntario adoptante y donante con el fin de que todas esas clases compartan tanto los mismos metodos como variables
    private int ID; //Identificador único del socio
    private Date registro; //Fecha en la que se restristro
    private final Refugio refugioAsociado; //Es una variable final porque solo mantenemos una instancia de refugio asociada

    public Socio(int ID, Date fechaRegistro, Refugio refugioAsociado) {
        //Comprobamos que todos los campos sean validos y no nulos
        assert ID > 0 : "El ID del socio debe ser válido.";
        assert fechaRegistro != null : "La fecha de registro no puede ser nula.";
        assert refugioAsociado != null : "El refugio asociado no puede ser nulo.";

        //Si son validos asignamos los datos a las variables de Socio
        this.ID = ID;
        this.registro = fechaRegistro;
        this.refugioAsociado = refugioAsociado;
        refugioAsociado.addSocio(this);
        assert refugioAsociado.getSocios().hasMoreElements() && Collections.list(refugioAsociado.getSocios()).contains(this);
    }
    public int getID(){
        return ID;
    }
    private void setID(int ID){
        assert ID > 0;
        assert Collections.list(this.getRefugio().getSocios()).stream().noneMatch(s -> s.getID() == ID)
            : "El ID ya existe en el refugio";
        this.ID = ID;
    }
    public Date getRegistro() {
        return this.registro;
    }
    public void setRegistro(Date fechaRegistro) {
        assert  fechaRegistro != null;
        this.registro = fechaRegistro;
    }
    public Refugio getRefugio() {
        return this.refugioAsociado;
    }
  @Override
    public boolean equals(Object obj) {
        if( this == obj ) return true;
        if(obj instanceof Socio ){
            Socio socio = (Socio) obj;
            return this.ID == socio.ID;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }
}
