package domain;

public class Casa extends Inmueble {

    public Casa(int metrosCuadrados, int cantidadAmbientes, Zona zona, double precio){
        super(metrosCuadrados,cantidadAmbientes, zona);
        this.precio = precio;
        calcularPrecio();
    }

    @Override
    protected void calcularPrecio(){
        this.precio += plus();
    }
}
