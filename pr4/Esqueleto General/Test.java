import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Crear modelos de coches
        Model modelA = new Model("Model A", 50);
        Model modelB = new Model("Model B", 70);



        // Crear oficinas de alquiler
        RentalOffice office1 = new RentalOffice("Office 1", 20);
        RentalOffice office2 = new RentalOffice("Office 2", 25);
        // Crear coches
        Car car1 = new Car("ABC-123", modelA, office1);
        Car car2 = new Car("XYZ-789", modelB, office2);

        // Asignar coches a oficinas
        office1.addCar(car1);
        office2.addCar(car2);

        // Crear clientes
        Customer customer1 = new Customer("12345678A", "Alice");

        // Alquiler con fechas solapadas
        Date startDate1 = new GregorianCalendar(2024, Calendar.JANUARY, 1).getTime();
        Date endDate1 = new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime();
        Date startDate2 = new GregorianCalendar(2024, Calendar.JANUARY, 5).getTime(); // Solapado
        Date endDate2 = new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime();

        Rental rental1 = new RentalOnSite("First rental", startDate1, endDate1, customer1, car1, office1);
        Rental rental2 = new RentalOnSite("Overlapping rental", startDate2, endDate2, customer1, car1, office1);

        // Añadir alquileres al cliente
        customer1.addRental(rental1);
        customer1.addRental(rental2); // Esto viola la restricción de solapamiento

        // Alquiler con fecha de inicio posterior a la fecha de finalización
        Date invalidStartDate = new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime();
        Date invalidEndDate = new GregorianCalendar(2024, Calendar.FEBRUARY, 5).getTime(); // Inválido

        Rental invalidRental = new WebRental(11, invalidStartDate, invalidEndDate, customer1, car2, office2);

        // Alquiler web con hora de entrega después de las 13:00
        Rental lateDeliveryRental = new WebRental(14, startDate1, endDate1, customer1, car2, office1); // Inválido

        // Añadir más alquileres
        customer1.addRental(invalidRental);
        customer1.addRental(lateDeliveryRental);

        // Imprimir resultados
        System.out.println("Customer Rentals:");
        System.out.println(customer1);

        System.out.println("\nOffice Rentals:");
        System.out.println(office1.toString());
        System.out.println(office2.toString());
    }
}
