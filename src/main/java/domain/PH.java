package domain;

public class PH extends Inmueble {

    public PH(int metrosCuadrados, int cantidadAmbientes){
        super(metrosCuadrados,cantidadAmbientes);
    }

    @Override
    protected void calcularPrecio(){
      double precioBase = 500000;
      double precioPorMetro = 14000;
      this.precio = plus() + this.metrosCuadrados * precioPorMetro + precioBase;
    }
}
