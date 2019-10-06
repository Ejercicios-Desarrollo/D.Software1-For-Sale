package domain;

public class PH extends Inmueble {

    public PH(int metrosCuadrados, int cantidadAmbientes, Zona zona){
        super(metrosCuadrados,cantidadAmbientes, zona);
    }

    @Override
    protected void calcularPrecio(){
      double precioBase = 500000;
      double precioPorMetro = 14000;
      this.precio = plus() + this.metrosCuadrados * precioPorMetro + precioBase;
    }
}
