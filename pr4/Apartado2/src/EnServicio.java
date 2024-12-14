import java.util.Set;

public class EnServicio extends Estado{

   public boolean sePuedeAlquilar(){ return true;}
   @Override
   public String toString(){
      return "El coche está en servicio";
   }
}
