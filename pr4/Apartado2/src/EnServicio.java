public class EnServicio extends Estado{

    public void rent(Rental r, Car c){
        c.addRental(r);
        r.setCar(c);
    }

}
