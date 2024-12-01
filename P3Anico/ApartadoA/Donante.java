
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Donante extends Socio{
    private Set<Donacion> donaciones; //Utilizamos un set para ahorrarnos tener que comprobar que no hayan elementos repetidos
    public Donante(int ID, Date date,Refugio r, Double cantidad) { //Se ha decidido meter la cantidad en el constructor, ya que es una condición necesaria y suficiente para ser donante.
        super(ID,date,r); //Asignamos los valores a traves del constructor de la clase padre de la que hereda
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad inicial donada debe ser mayor a cero.";


        donaciones = new HashSet<>(); //Se ha decicido utilizar un set en vez de una lista ya que no queremos donantes duplicados y es mas eficiente
        this.donar(cantidad); //Cuando creamos un donante es obvio que va a donar instantaneamente por eso se le llama en el propio constructor.
    }
    //Metodo que simula una donacion en el sistema a partir de una cantidad a donar
    public void donar(Double cantidad){ //En vez de utilizar
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad donada debe ser mayor a cero.";
        LocalDate fechaDonacion = LocalDate.now();
        Donacion d = new Donacion(cantidad, Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this); //Instanciamos una donacion
        donaciones.add(d);
        Refugio r = super.getRefugio(); //Como hereda de la clase socio podemos acceder al refugio de la clase padre
        r.setLiquidez(r.getLiquidez() + cantidad); //Asignamos el nuevo valor de liquidez tras la donacion
        r.addSocio(this);
        assert donaciones.contains(d);
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    //Para eliminar donaciones o modificar la cantidad, se puede acceder a la propia donación, lo cual tendrá un efecto en la lista que la contiene (en este caso donaciones)
    @Override
    public String toString() {
        return "Donante{}";
    }

    
}
