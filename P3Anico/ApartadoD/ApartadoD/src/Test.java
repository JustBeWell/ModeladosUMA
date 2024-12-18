import sistema.*;

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
            Socio socio = new Socio(1, new Date(), refugio);
            socio.createVoluntario();

            socio.createDonante(100.00f);
            socio.createAdoptante();

            Voluntario voluntario = socio.getVoluntario();
            Donante donante = socio.getDonante();
            Adoptante adoptante = socio.getAdoptante();


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
            adoptante.adoptar(animal1, voluntario);
            //adoptante.adoptar(animal1, voluntario); Falla porque el animal ya ha sido adoptado

            // Mostrar estado final del refugio
            System.out.println(refugio.toString());
        } catch (Exception e) {
            System.out.println("Error en el Caso 1: " + e.getMessage());
        }

        // Caso 2: Pruebas de errores (fallos en los asserts)
        try {
            System.out.println("\nCaso 2: Adoptar dos veces el mismo animal\n");

            // Intentar registrar un animal nulo
            //Se ha asumido que solo se puede crear un refugio

            // Crear socios

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);
            //Se ha asumido que solo se puede crear un refugio

            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);
            socio.createVoluntario();
            socio.createDonante(100.00f);
            socio.createAdoptante();

            Animal animal1 = new Animal(101, new Date(), EstadoAnimal.ENTRATAMIENTO);
            Voluntario voluntario = socio.getVoluntario();
            Adoptante adoptante = socio.getAdoptante();

            voluntario.registrar(animal1);

            adoptante.adoptar(animal1, voluntario);
            adoptante.adoptar(animal1, voluntario);

            System.out.println(refugio.toString());

        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }
        // Caso 3: Intentar meter dos veces el mismo socio en el mismo refugio
        try {
            System.out.println("\nCaso 3: Intentar meter dos veces el mismo socio en el mismo refugio\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            //Se ha asumido que solo se puede crear un refugio
            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);
            Socio socio2 = new Socio(1, new Date(), refugio);

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        // Caso 4:  Intentar que un socio sea dos voluntarios
        try {
            System.out.println("\nCaso 4: Intentar que un socio sea dos donantes, voluntarios y adoptantes\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            //Se ha asumido que solo se puede crear un refugio
            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);

            socio.createVoluntario();
            socio.createDonante(100.00f);
            socio.createAdoptante();

            socio.createVoluntario();
            //socio.createDonante(1.00f);
            //socio.createAdoptante();

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        // Caso 5:  Intentar que un socio sea dos donantes
        try {
            System.out.println("\nCaso 5:  Intentar que un socio sea dos donantes\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            //Se ha asumido que solo se puede crear un refugio
            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);

            socio.createVoluntario();
            socio.createDonante(100.00f);
            socio.createAdoptante();

            //socio.createVoluntario();
            socio.createDonante(1.00f);
            //socio.createAdoptante();

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }
        // Caso 6:  Intentar que un socio sea dos adoptantes
        try {
            System.out.println("\nCaso 6:  Intentar que un socio sea dos adoptantes\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            //Se ha asumido que solo se puede crear un refugio
            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);

            socio.createVoluntario();
            socio.createDonante(100.00f);
            socio.createAdoptante();

            //socio.createVoluntario();
            //socio.createDonante(1.00f);
            socio.createAdoptante();

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        // Caso 7: Meter un animal dos veces en el mismo refugio, el mismo animal y luego dos distintos, desde refugio y desde voluntario
        try {
            System.out.println("\nCaso 7: Meter un animal dos veces en el mismo refugio, el mismo animal y luego dos distintos, desde refugio y desde voluntario\n");

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);

            //Se ha asumido que solo se puede crear un refugio
            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);

            Animal animal = new Animal(101, new Date(), EstadoAnimal.ENTRATAMIENTO);
            Animal animal2 = new Animal(102, new Date(), EstadoAnimal.ENTRATAMIENTO);

            Voluntario voluntario = socio.createVoluntario();
            voluntario.registrar(animal);
            voluntario.registrar(animal);

            refugio.registrar(animal2);
            refugio.registrar(animal2);

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        // Caso 8: Dos personas distintas intentan adoptar al mismo animal
        try {
            System.out.println("\nCaso 8: Dos personas distintas intentan adoptar al mismo animal\n");

            // Intentar registrar un animal nulo
            //Se ha asumido que solo se puede crear un refugio

            // Crear socios

            // Crear un refugio con liquidez inicial
            Refugio refugio = new Refugio(500.00f);
            //Se ha asumido que solo se puede crear un refugio

            //Crear socios
            Socio socio = new Socio(1, new Date(), refugio);
            Socio socio2 = new Socio(2, new Date(), refugio);
            socio.createVoluntario();
            socio.createDonante(100.00f);
            socio.createAdoptante();

            Animal animal1 = new Animal(101, new Date(), EstadoAnimal.ENTRATAMIENTO);
            Adoptante adoptante = socio.getAdoptante();
            Voluntario voluntario = socio2.createVoluntario();

            Adoptante adoptante2 = socio2.createAdoptante();

            voluntario.registrar(animal1);

            adoptante.adoptar(animal1, voluntario);
            adoptante2.adoptar(animal1, voluntario);

            System.out.println(refugio.toString());
        } catch (AssertionError e) {
            System.out.println("Error detectado: " + e.getMessage());
        }
    }
}
