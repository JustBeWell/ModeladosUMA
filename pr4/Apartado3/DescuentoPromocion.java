//TIPO DE DESCUENO 2 POR DESCUENTO 
public class DescuentoPromocion implements DescuentoEstrategia{
    private final int descuento;

    public DescuentoPromocion(int descuento) {
        assert descuento >= 0 : "Descuento no puede ser negativo";
        this.descuento = descuento;
    }

    @Override
    public int aplicarDescuento(int precioBase) {
        if(descuento >= precioBase) return 0;
        return precioBase - descuento;
    }

    @Override
    public String toString() {
        return "[" + descuento + "]";
    }

    
}