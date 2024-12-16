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
        Car car2 = new Car("DGJ-324", modelA, office1);
        Car car3 = new Car("XYZ-789", modelA, office1);


       // Ponemos car1 fuera de Servicio:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha1 = sdf.parse("2025-01-01 12:00:00");


        //Ponemos car1 fuera de servicio otra vez. No debería permitirlo

        car1.takeOutOfService(fecha1); // El coche estará fuera de servicio hasta 1 de enero del 2025 y se le asocia el car2

        //Ponemos el car1 fuera de servicio otra vez. Esta vez no lo permite
        //car1.takeOutOfService(fecha1);

        //Ponemos el car2 fuera de servicio. No debería permitirlo, dado que car2 es sustituto de car1

        //car2.takeOutOfService(fecha1); // El coche estará fuera de servicio hasta 1 de enero del 2025

        //Ponemos car3 fuera de servicio: No debería de tener un sustituto

        car3.takeOutOfService(sdf.parse("2025-01-12 12:00:00"));

        //Intentamos alquilar un coche que está fuera de servicio, pero que tiene un sustituto

        Customer c1 = new Customer("12345H", "Fulanito");

        Date startDate = sdf.parse("2024-01-14 12:00:00");
        Date endDate = sdf.parse("2024-01-21 12:00:00");

        Rental rent1 = new RentalOnSite(startDate, endDate, c1, car1, office1); // No funciona bien

        Date startDate2 = sdf.parse("2024-01-14 12:30:00");
        Date endDate2 = sdf.parse("2024-01-21 12:30:00");

        //Ahora vamos a intentar alquilar el coche 2 que está siendo sustituto del coche 1

        //Descomentar esta línea para comprobar el alquiler de un coche sustituto
        //Rental rent2 = new RentalOnSite(startDate2, endDate2, c1, car2, office1);




        // Intentamos alquilar un coche que está fuera de servicio y que not tiene sustituto:

        Date startDate3 = sdf.parse("2024-01-14 12:30:00");
        Date endDate3 = sdf.parse("2024-01-21 12:30:00");
        //Falla por intentar alquilar un coche fuera de servicio
        Rental rent3 = new RentalOnSite(startDate3, endDate3, c1, car3, office1);




    }
}
