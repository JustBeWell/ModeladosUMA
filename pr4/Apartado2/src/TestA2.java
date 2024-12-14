import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestA2 {
    public static void main(String[] args) throws ParseException {
        // Crear modelos de coches
        Model modelA = new Model("Model A", 50);

        // Crear oficinas de alquiler
        RentalOffice office1 = new RentalOffice("Office 1", 20);

        // Crear coches
        Car car1 = new Car("ABC-123", modelA, office1);
        Car car2 = new Car("XYZ-789", modelA, office1);

       // Ponemos car1 fuera de Servicio:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha1 = sdf.parse("2025-01-01 12:00:00");
        car1.takeOutOfService(fecha1); // El coche estará fuera de servicio hasta 1 de enero del 2025

        System.out.println("Estado del coche 1:" + car1.getEstado()); // Obtenemos el estado del coche1. Debería indicar que el coche está fuera de servicio
        System.out.println("Sustituto del coche 1: " + car1.getSustituto()); // Obtenemos al sustituto. Debería devolver la placa del coche2

        //Ponemos car1 fuera de servicio otra vez. No debería permitirlo

        //car1.takeOutOfService(fecha1);

        //Ponemos el car2 fuera de servicio. No debería permitirlo, dado que car2 es sustituto de car1

         car2.takeOutOfService(fecha1); // El coche estará fuera de servicio hasta 1 de enero del 2025



    }
}
