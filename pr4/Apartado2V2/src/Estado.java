import java.util.Date;
import java.util.Set;

public abstract class Estado {
    protected Car context;
    public Estado(Car context) {
        this.context = context;
    }
    public abstract boolean sePuedeAlquilar();
    public abstract void takeOutOfService(Date backToService);
    public abstract Car getCocheParaAlquilar();
    public abstract void addRental( Rental rental);
    public abstract void removeRental( Rental rental);
}
