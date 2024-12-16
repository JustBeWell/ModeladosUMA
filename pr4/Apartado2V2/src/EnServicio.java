import java.util.Date;
import java.util.Set;

public class EnServicio extends Estado{


   public EnServicio(Car context) {
      super(context);
   }

   public boolean sePuedeAlquilar(){ return true;}

   @Override
   public void takeOutOfService(Date backToService) {
      assert !context.esSustituto(): "El coche es el sustituto del otro";                          // "El coche es sustituto del otro coche";
      context.setEstado(new FueraDeServicio(context, backToService));       // Ponemos un coche fuera de servicio
      context.setSustituto(context.encontrarSustituto());       // Buscamos un coche sustituto

   }

   @Override
   public void addRental(Rental rental) {
      context.validateAndAddRental(rental);
   }

   @Override
   public void removeRental(Rental rental) {
      context.removeRental(rental);
   }

   @Override
   public String toString(){
      return context.toString() + "El coche está en servicio";
   }
}