
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public  class Donante {
    private Set<Donacion> donaciones; //Utilizamos un set para ahorrarnos tener que comprobar que no hayan elementos repetidos
    private final Socio socio;   // El socio que toma el papel del adoptante

    public Donante(Socio socio, Double cantidad) { //Se ha decidido meter la cantidad en el constructor, ya que es una condición necesaria y suficiente para ser donante.
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad inicial donada debe ser mayor a cero.";
        donaciones = new HashSet<>(); //Se ha decicido utilizar un set en vez de una lista ya que no queremos donantes duplicados y es mas eficiente
        this.socio = socio;  // Inicializamos al socio
    }

    public Socio getSocio(){
        return this.socio;
    }

    //Metodo que simula una donacion en el sistema a partir de una cantidad a donar
    public void donar(Double cantidad){ //En vez de utilizar
        //Comprobamos que la cantidad sea valida
        assert cantidad > 0 : "La cantidad donada debe ser mayor a cero.";
        LocalDate fechaDonacion = LocalDate.now();  // Conseguimos la fecha actual
        // Ahora el socio es responsable del trámite
        Donacion d = new Donacion(cantidad, Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this); //Instanciamos una donacion
        this.donaciones.add(d);   // Añadimos la donación a la lista de donaciones
        Refugio r = socio.getRefugio(); //Como hereda de la clase socio podemos acceder al refugio de la clase padre
        r.setLiquidez(r.getLiquidez() + cantidad); //Asignamos el nuevo valor de liquidez tras la donacion
        r.addSocio(socio);
        assert donaciones.contains(d);
    }
    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }


    //Para eliminar donaciones o modificar la cantidad, se puede acceder a la propia donación, lo cual tendrá un efecto en la lista que la contiene (en este caso donaciones)

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Donaciones: ").append(donaciones).append("\n");
        sb.append("Datos: ").append(this.socio.toString()).append("\n");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj){
        return obj == socio || ((obj instanceof Socio) && ((Socio)obj).getID() == socio.getID());
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(socio.getID());
    }
    
}
