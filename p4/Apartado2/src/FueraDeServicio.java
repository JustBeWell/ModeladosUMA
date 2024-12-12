import java.util.*;

public class FueraDeServicio extends Estado{
    Model m;
    public void rent(Rental r, Car c){
        System.out.println("El coche está fuera de servicio");

        //Buscamos un sustituto para el coche que está fuera de servicio
        RentalOffice office = c.getRentalOffice(); // La oficina asociada al coche
        Iterator<Car> it = office.getCars().iterator();

        while(it.hasNext()){
            Car tmp = it.next();
            if(tmp.getModel().equals(c.getModel()) && tmp.getEstado() instanceof EnServicio){
                tmp.rent(r);
                break;
            }
        }

    }
}
