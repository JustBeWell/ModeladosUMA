import java.util.HashSet;
import java.util.Set;

public class RentalSet implements RentalCollection{
    private HashSet<Rental> rentals;

    public RentalSet() {
        rentals = new HashSet<>();
    }

    protected Set<Rental> getRentals() {
        return rentals;
    }

    @Override
    public RentalIterator createIterator() {
        return new RentalSetIterator(this);
    }

    @Override
    public RentalIterator createFilteredIterator() {
        return new FilteredRentalIterator(this);
    }


    @Override
    public void addRental(Rental rental) {
        assert rental != null;
        rentals.add(rental);
    }

    @Override
    public void removeRental(Rental rental) {
        assert rental != null;
        rentals.remove(rental);
    }
}
