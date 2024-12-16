//TIPO DE DESCUENTO 1 POR PORCENTAJE
public class DescuentoPorcentaje implements DescuentoEstrategia{
    private final double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        assert porcentaje >= 0 && porcentaje <= 100 : "Porcentaje invalido";
        this.porcentaje = porcentaje;
    }

    @Override
    public int aplicarDescuento(int precioBase) {
        double res = precioBase * (1-porcentaje/100);
        int sol = (int)res;
        return sol;
    }

    @Override
    public String toString() {
        return "[" + porcentaje + "]";
    }

    
         
}
