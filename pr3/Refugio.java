import java.util.*;

public class Refugio{
    private double liquidez;    
    private List<Animal> animales = new LinkedList<Animal>(); // Composición con clase Animal
    
    public void registrar(Animal a){
        animales.add(a);
    }
    
    public void setLiquidez(double liquidez){
        this.liquidez = liquidez;
    }
    
    
}