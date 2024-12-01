
import java.util.Date;

public class Animal {
    private int ID;
    private Date nacimiento;
    private EstadoAnimal estadoAnimal; 
    // Declaramos el Refugio como final porque estamos seguros que solo existirá una instancia de él
    final private Refugio refugio;
    private Adopcion adopcion;
    // Contructor para la clase Animal
    public Animal(int ID, Date nacimiento, EstadoAnimal estadoAnimal, Refugio refugio, Adopcion adopcion) {
        //Comprobamos que todos los campos sean validos y no nulos
        assert ID > 0 : "El ID del animal debe ser válido.";
        assert nacimiento != null : "La fecha de nacimiento no puede ser nula.";
        assert estadoAnimal != null : "El estado del animal debe estar definido.";
        assert refugio != null : "El refugio debe existir.";
        //Si todo esta correcto asignamos los datos a las variables del animal
        this.ID = ID;
        this.nacimiento = nacimiento;
        this.estadoAnimal = estadoAnimal;
        this.refugio = refugio;
        this.adopcion = adopcion;
    }

    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }
    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        assert estadoAnimal != null : "El estado del animal debe estar definido.";
        this.estadoAnimal = estadoAnimal;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(Date nacimiento) {
        assert nacimiento != null : "La fecha de nacimiento no puede ser nula";
        this.nacimiento = nacimiento;
    }
    public Refugio getRefugio() {
        return refugio;
    }
    public Adopcion getAdopcion() {
        return this.adopcion;
    }
    public void setAdopcion(Adopcion adopcion){
        assert  adopcion != null;
        this.adopcion = adopcion;
    }
    
    //Metodo que comprueba si dos animales son iguales
        //Dos animales son iguales si y solo si sus campos ID son iguales
    @Override
    public boolean equals(Object obj) {
        if( this == obj ) return true;
        if(obj instanceof Animal ){
            Animal animal = (Animal) obj;
            return this.ID == animal.ID;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }
    @Override
    public String toString() {
        return String.format("Animal: ID=%d, nacimiento=%tF, estado=%s", ID, nacimiento, estadoAnimal);
    }

}
