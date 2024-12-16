import java.util.Collection;
import java.util.List;

public interface RentalCollection {

    RentalIterator createIterator(); // Crear el iterador estándar
    RentalIterator createFilteredIterator();
    void addRental(Rental rental);   // Añadir un alquiler
    void removeRental(Rental rental);// Eliminar un alquiler
}
