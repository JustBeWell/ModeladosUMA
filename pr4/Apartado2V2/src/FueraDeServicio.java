import java.util.Date;
import java.util.Set;

public class FueraDeServicio extends Estado{
    Date backToService;
    public FueraDeServicio(Car context) {
        super(context);
    }
    public FueraDeServicio(Car context, Date backToService) {
        super(context);
        this.backToService = backToService;
    }

    public boolean sePuedeAlquilar(){  return false;}

    @Override
    public void takeOutOfService(Date backToService) {
        throw new IllegalStateException("El coche ya se encuentra fuera de Servicio");
    }

    @Override
    public void addRental(Rental rental) {
        if (this.context.getSustituto() != null){
            context.getSustituto().addRental(rental);
        }else{
            throw new IllegalStateException("El coche está fuera de servicio y no tiene sustituto");
        }

    }

    @Override
    public void removeRental(Rental rental) {
        if (this.context.getSustituto() != null){
            context.getSustituto().removeRental(rental);
        }else{
            throw new IllegalStateException("El coche está fuera de servicio y no tiene sustituto");
        }
    }

    @Override
    public String toString(){
        return context.toString() + "El coche está fuera de servicio";
    }
}
