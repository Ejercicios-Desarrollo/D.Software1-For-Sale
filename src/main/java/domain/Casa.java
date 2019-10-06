package domain;

public class Casa extends Inmueble {

    public Casa(int metrosCuadrados, int cantidadAmbientes, double precio){
        super(metrosCuadrados,cantidadAmbientes);
        this.precio = precio;
        calcularPrecio();
    }

    @Override
    protected void calcularPrecio(){
        this.precio += plus();
    }
}
