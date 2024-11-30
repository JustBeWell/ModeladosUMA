import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println("Pruebas del sistema de refugio de animales\n");

        // Caso 1: Pruebas exitosas (configuración y operaciones válidas)
        try {
            System.out.println("Caso 1: Pruebas exitosas\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00);

            // Crear socios
            Voluntario voluntario = new Voluntario(1, new Date(), refugio);
            Donante donante = new Donante(2, new Date(), refugio, 100.00);
            Adoptante adoptante = new Adoptante(3, new Date(), refugio);

            // Registrar animales en el refugio
            Animal animal1 = new Animal(101, new Date(), EstadoAnimal.DISPONIBLE, refugio, null);
            Animal animal2 = new Animal(102, new Date(), EstadoAnimal.DISPONIBLE, refugio, null);
            refugio.addAnimalesRefugiados(animal1);
            refugio.addAnimalesRefugiados(animal2);

            // Donante realiza una donación adicional
            donante.donar(50.00);

            // Adoptante adopta un animal
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
            Refugio refugio = new Refugio(500.00);

            // Intentar registrar un animal nulo
            Animal animalInvalido = null;
            refugio.addAnimalesRefugiados(animalInvalido); // Esto debería fallar

        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        try {
            // Crear un animal con estado nulo
            Animal animalEstadoInvalido = new Animal(103, new Date(), null, new Refugio(100.00), null); // Esto debería fallar
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        try {
            // Intentar adoptar un animal no disponible
            Refugio refugio = new Refugio(500.00);
            Voluntario voluntario = new Voluntario(4, new Date(), refugio);
            Adoptante adoptante = new Adoptante(5, new Date(), refugio);

            Animal animalNoDisponible = new Animal(104, new Date(), EstadoAnimal.ADOPTADO, refugio, new Adopcion(null, adoptante, voluntario, new Date()));
            refugio.addAnimalesRefugiados(animalNoDisponible);

            adoptante.adoptar(animalNoDisponible, voluntario); // Esto debería fallar
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        System.out.println("\nPruebas finalizadas.");
    }
}
