import java.util.Collection;
import java.util.List;

public interface RentalCollection {

    RentalIterator createIterator(); // Crear el iterador estándar
    RentalIterator createFilteredIterator(); // Crear iterador que filtra por la condición
    void addRental(Rental rental);   // Añadir un alquiler
    void removeRental(Rental rental);// Eliminar un alquiler
}
