import java.util.Set;

public class FueraDeServicio extends Estado{
    public boolean sePuedeAlquilar(){  return false;}
    @Override
    public String toString(){
        return "El coche está fuera de servicio";
    }
}
