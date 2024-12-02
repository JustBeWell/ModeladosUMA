package sistema;

import java.util.*;

public class Adoptante extends Socio {
    private Set<Adopcion> adopciones; //Para poder guardar las Adopciones en un adoptante hemos decidido utilizar un set para no permitir elementos repetidos en los datos del sistema

    //Constructor para un adoptante
    public Adoptante(int ID, Date date, Refugio r) {
        super(ID, date,r); //Asigno los parametros a traves de la clase padre de la que hereda adoptante
        adopciones = new HashSet<>(); //Por terminos de eficiencia en ejecucion utilizamos Hashset que permiten el accesso en tiempo O(1)

    }

    //Metodo que simula una adopcion en el sistema a partir de un voluntario y un animal
    public void adoptar(Animal a, Voluntario v) {
        //Comprobamos si previamente el animal a ya se encontraba adoptado en el sistema
        assert a.getEstadoAnimal() == EstadoAnimal.DISPONIBLE: "El animal ya ha sido adoptado";
        //Si no, se tramita la adopcion
        Refugio refugioDelVoluntario = v.getRefugio();
        a.setEstadoAnimal(EstadoAnimal.ADOPTADO); //El estado del animal debe pasar a ADOPTADO
        refugioDelVoluntario.removeAnimalesRefugiados(a); //El animal ya no debe estar en el refugio por haber sido adoptado


        v.tramitarAdopcion(a, this);

    }

    protected void addAdopcion(Adopcion a){
        this.adopciones.add(a); //En caso de que ya exista la adopción directamente no se insertará
    }

    protected void removeAdopcion(Adopcion a){
        if (adopciones.contains(a)) adopciones.remove(a); //Comprobamos si previamente el animal a ya se encontraba en el sistema
        else System.out.println("Este animal ya no está asociado al adoptante");
    }
    public Enumeration<Adopcion> getAdopciones(){
        return Collections.enumeration(adopciones);
    }

    //Metodo que comprueba si dos adoptantes son iguales
        //Dos adoptantes son iguales si y solo si sus campos ID son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj instanceof Adoptante ){
            Adoptante adoptante = (Adoptante) obj;
            return adoptante.getID() == this.getID();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.getID());
    }

    @Override
    public String toString() {
        return "Adoptante " + super.getID();
    }

    
}
