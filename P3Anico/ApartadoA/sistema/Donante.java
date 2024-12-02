package sistema;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Donante extends Socio{
    private Set<Donacion> donaciones; //Utilizamos un set para ahorrarnos tener que comprobar que no hayan elementos repetidos
    public Donante(int ID, Date date,Refugio r, float cantidad) { //Se ha decidido meter la cantidad en el constructor, ya que es una condición necesaria y suficiente para ser donante.
        super(ID,date,r); //Asignamos los valores a traves del constructor de la clase padre de la que hereda
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad inicial donada debe ser mayor a cero.";


        donaciones = new HashSet<>(); //Se ha decicido utilizar un set en vez de una lista ya que no queremos donantes duplicados y es mas eficiente

        //Cuando creamos un donante es obvio que va a donar instantaneamente por eso se le llama en el propio constructor.
        donar(cantidad);
    }
    //Metodo que simula una donacion en el sistema a partir de una cantidad a donar
    public void donar(float cantidad){ //En vez de utilizar
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad donada debe ser mayor a cero.";
        assert Collections.list(this.getRefugio().getSocios()).contains(this): "El socio debe ser donante antes de poder donar"; //En caso de que el socio ya fuese donante del refugio tiene permitido donar, ya que la asociación se define en su constructor
        LocalDate fechaDonacion = LocalDate.now();
        Donacion d = new Donacion(cantidad, Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant())); //Instanciamos una donacion
        addDonacion(d);
        Refugio r = super.getRefugio(); //Como hereda de la clase socio podemos acceder al refugio de la clase padre
        r.setLiquidez(r.getLiquidez() + cantidad); //Asignamos el nuevo valor de liquidez tras la donacion
        assert donaciones.contains(d); //Asegura que las donaciones contengan la nueva ;)
    }

    protected void addDonacion(Donacion donacion){
        assert donacion != null: "La donación no puede ser nula";
        donaciones.add(donacion);
    }

    protected void removeDonacion(Donacion donacion){
        assert donacion != null : "La donación no puede ser nula.";
        if (donaciones.contains(donacion) && donaciones.size() > 1) {
            donaciones.remove(donacion);
        } else if (donaciones.contains(donacion) && donaciones.size() == 1) {
            System.out.println("Todo donante debe tener al menos una donación, estás intentando eliminar la única donación asociada a este socio donante");
        } else {
            System.out.println("Este socio no ha realizado la donación que intentas eliminar");
        }
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    //Para eliminar donaciones o modificar la cantidad, se puede acceder a la propia donación, lo cual tendrá un efecto en la lista que la contiene (en este caso donaciones)
    @Override
    public String toString() {
        return "Donante " + super.getID();
    }

    
}
