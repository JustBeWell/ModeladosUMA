import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println("Pruebas del sistema de refugio de animales\n");

        // Caso 1: Pruebas exitosas (configuración y operaciones válidas)
        try {
            System.out.println("Caso 1: Pruebas exitosas\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);
            //Se ha asumido que solo se puede crear un refugio

            // Crear socios
            Voluntario voluntario = new Voluntario(1, new Date(), refugio);


            refugio.addSocio(voluntario);//No se añade porque es un set
            Donante donante = new Donante(2, new Date(), refugio, 100.00f);
            Adoptante adoptante = new Adoptante(3, new Date(), refugio);
            Voluntario voluntario2= new Voluntario(1, new Date(), refugio);//No se añade porque el equals es igual que el 1, es el mismo socio
            //Hasta aquí hemos garantizado que: no se añadan voluntarios duplicados, que todos los tipos de socio se añaden correctamente con todos sus atributos y que impedimos que un socio tenga varios refugios asociados.
            // Registrar animales en el refugio
            //Se entiende que el estado de ENTRATAMIENTO es el estado en el que se encuentra un animal que no está ni disponible ni adoptado
            Animal animal1 = new Animal(101, new Date(), EstadoAnimal.ENTRATAMIENTO);
            Animal animal2 = new Animal(102, new Date(), EstadoAnimal.ENTRATAMIENTO);
            voluntario.registrar(animal1);
            voluntario.registrar(animal2); //Si ya nos hemos encargado de que un socio no pertenezca a dos refugios, y la única forma de añadir el animal es así no se puede meter un animal es dos refugios
            //Creo un socio asociado a otro refugio e intento meter el mismo animal

            // Donante realiza una donación adicional
            donante.donar(50.00f);
            //Hasta aquí funciona el registro de socios, el méto do donar y el méto do registrar funcionan perfactemente.
            // Adoptante adopta un animal
            adoptante.adoptar(animal1, voluntario2);
            adoptante.adoptar(animal1, voluntario);

            // Mostrar estado final del refugio
            System.out.println(refugio.toString());
        } catch (Exception e) {
            System.out.println("Error en el Caso 1: " + e.getMessage());
        }

        // Caso 2: Pruebas de errores (fallos en los asserts)
        try {
            System.out.println("\nCaso 2: Pruebas de errores\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            // Intentar registrar un animal nulo
            Animal animalInvalido = null;
            refugio.addAnimalesRefugiados(animalInvalido); // Esto debería fallar

        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        try {
            // Crear un animal con estado nulo
            Animal animalEstadoInvalido = new Animal(103, new Date(), null); // Esto debería fallar
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        try {
            // Intentar adoptar un animal no disponible
            Refugio refugio = new Refugio(500.00f);
            Voluntario voluntario = new Voluntario(4, new Date(), refugio);
            Adoptante adoptante = new Adoptante(5, new Date(), refugio);

            Animal animalNoDisponible = new Animal(104, new Date(), EstadoAnimal.ADOPTADO);
            refugio.addAnimalesRefugiados(animalNoDisponible);

            adoptante.adoptar(animalNoDisponible, voluntario); // Esto debería fallar*/
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        System.out.println("\nPruebas finalizadas.");
    }
}
